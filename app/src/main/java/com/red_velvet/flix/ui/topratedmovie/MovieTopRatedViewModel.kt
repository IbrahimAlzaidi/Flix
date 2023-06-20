package com.red_velvet.flix.ui.topratedmovie

import com.red_velvet.flix.domain.entity.movie.MovieEntity
import com.red_velvet.flix.domain.usecase.home.movies.GetTopRatedMoviesUseCase
import com.red_velvet.flix.ui.base.BaseViewModel
import com.red_velvet.flix.ui.base.ErrorUiState
import com.red_velvet.flix.ui.topratedmovie.uiState.TopRatedUiState
import com.red_velvet.flix.ui.topratedmovie.uiState.toMovieTopRatedUiState
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.flow.update
import javax.inject.Inject

@HiltViewModel
class MovieTopRatedViewModel @Inject constructor(
    private val getMoviesTopRatedUseCase: GetTopRatedMoviesUseCase

) : BaseViewModel<TopRatedUiState>(), MovieTopRatedInteractionListener {
    override val _state = MutableStateFlow(TopRatedUiState())
    override val state: StateFlow<TopRatedUiState> = _state

    init {
        getMovieTopRated()
    }

    private fun getMovieTopRated() {
        _state.update { it.copy(isLoading = true) }
        tryToExecuteHome(
            getMoviesTopRatedUseCase::invoke,
            onSuccess = ::onTopRatedMoviesSuccess,
            onError = ::onTopRatedMoviesError
        )
    }

    private fun onTopRatedMoviesError(errorUiState: ErrorUiState) {
        _state.update { it.copy(error = errorUiState) }
    }

    private fun onTopRatedMoviesSuccess(movies: List<MovieEntity>) {
        val movieUiState = movies.map { it.toMovieTopRatedUiState() }
        _state.update { it.copy(movieList = movieUiState, isLoading = false) }
    }

    override fun onMovieTopRatedCardClick(id: Int) {

    }
}