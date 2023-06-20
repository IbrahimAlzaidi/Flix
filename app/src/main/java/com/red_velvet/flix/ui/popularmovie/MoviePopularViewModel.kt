package com.red_velvet.flix.ui.popularmovie

import com.red_velvet.flix.domain.entity.movie.MovieEntity
import com.red_velvet.flix.domain.usecase.home.movies.GetPopularMoviesUseCase
import com.red_velvet.flix.ui.base.BaseViewModel
import com.red_velvet.flix.ui.base.ErrorUiState
import com.red_velvet.flix.ui.popularmovie.uiState.PopularUiState
import com.red_velvet.flix.ui.popularmovie.uiState.toMoviePopularUiState
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.flow.update
import javax.inject.Inject

@HiltViewModel
class MoviePopularViewModel @Inject constructor(
    private val getMoviesPopularUseCase: GetPopularMoviesUseCase
) : BaseViewModel<PopularUiState>(), MoviePopularInteractionListener {
    override val _state = MutableStateFlow(PopularUiState())
    override val state: StateFlow<PopularUiState> = _state

    init {
        getMoviePopular()
    }

    private fun getMoviePopular() {
        _state.update { it.copy(isLoading = true) }
        tryToExecuteHome(
            getMoviesPopularUseCase::invoke,
            onSuccess = ::onPopularMoviesSuccess,
            onError = ::onPopularMoviesError
        )
    }

    private fun onPopularMoviesSuccess(movies: List<MovieEntity>) {
        val movieUiStates = movies.map { it.toMoviePopularUiState() }
        _state.update { it.copy(movieList = movieUiStates, isLoading = false) }

    }

    private fun onPopularMoviesError(errorUiState: ErrorUiState) {
        _state.update { it.copy(error = errorUiState) }
    }

    override fun onMoviePopularCardClick(id: Int) {
        TODO("Not yet implemented")
    }


}