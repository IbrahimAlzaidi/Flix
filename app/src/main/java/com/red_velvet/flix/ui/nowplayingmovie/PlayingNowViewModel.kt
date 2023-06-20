package com.red_velvet.flix.ui.nowplayingmovie

import com.red_velvet.flix.domain.entity.movie.MovieEntity
import com.red_velvet.flix.domain.usecase.home.movies.GetNowPlayingMoviesUseCase
import com.red_velvet.flix.ui.base.BaseViewModel
import com.red_velvet.flix.ui.base.ErrorUiState
import com.red_velvet.flix.ui.nowplayingmovie.uiState.NowPlayingUiState
import com.red_velvet.flix.ui.nowplayingmovie.uiState.toMoviesNowPlayingUiState
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.flow.update
import javax.inject.Inject

@HiltViewModel
class PlayingNowViewModel @Inject constructor(
    private val getMoviesNowPlayingUseCase: GetNowPlayingMoviesUseCase
) : BaseViewModel<NowPlayingUiState>(), MovieNowPlayingInteractionListener {
    override val _state = MutableStateFlow(NowPlayingUiState())
    override val state: StateFlow<NowPlayingUiState> = _state

    init {
        getNowPlayingMovies()
    }

    private fun getNowPlayingMovies() {
        _state.update { it.copy(isLoading = true) }
        tryToExecuteHome(
            getMoviesNowPlayingUseCase::invoke,
            onSuccess = ::onNowPlayingMoviesSuccess,
            onError = ::onNowPlayingMoviesError
        )
    }

    private fun onNowPlayingMoviesSuccess(movies: List<MovieEntity>) {
        val movieUiStates = movies.map { it.toMoviesNowPlayingUiState() }
        _state.update { it.copy(movieList = movieUiStates, isLoading = false) }

    }


    private fun onNowPlayingMoviesError(errorUiState: ErrorUiState) {
        _state.update { it.copy(error = errorUiState) }
    }


    override fun onMoviePlayingNowCardClick(id: Int) {
        TODO("Not yet implemented")
    }
}