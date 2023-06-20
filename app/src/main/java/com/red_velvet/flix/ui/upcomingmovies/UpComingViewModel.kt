package com.red_velvet.flix.ui.upcomingmovies

import com.red_velvet.flix.domain.entity.movie.MovieEntity
import com.red_velvet.flix.domain.usecase.home.movies.GetUpcomingMoviesUseCase
import com.red_velvet.flix.ui.base.BaseViewModel
import com.red_velvet.flix.ui.base.ErrorUiState
import com.red_velvet.flix.ui.upcomingmovies.uiState.UpComingUiState
import com.red_velvet.flix.ui.upcomingmovies.uiState.toMoviesUpComingUiState
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.flow.update
import javax.inject.Inject

@HiltViewModel
class UpComingViewModel @Inject constructor(
    private val getMoviesUpComingUseCase: GetUpcomingMoviesUseCase
) : BaseViewModel<UpComingUiState>(), MovieUpComingInteractionListener {
    override val _state = MutableStateFlow(UpComingUiState())
    override val state: StateFlow<UpComingUiState> = _state


    init {
        getUpComingMovies()
    }

    private fun getUpComingMovies() {
        _state.update { it.copy(isLoading = true) }
        tryToExecuteHome(
            getMoviesUpComingUseCase::invoke,
            onSuccess = ::onUpComingMoviesSuccess,
            onError = ::onUpComingMoviesError
        )
    }

    private fun onUpComingMoviesError(errorUiState: ErrorUiState) {
        _state.update { it.copy(error = errorUiState) }
    }

    private fun onUpComingMoviesSuccess(movies: List<MovieEntity>) {
        val movieUiState = movies.map { it.toMoviesUpComingUiState() }
        _state.update { it.copy(movieList = movieUiState, isLoading = false) }
    }

    override fun onMovieUpComingCardClick(id: Int) {
        TODO("Not yet implemented")
    }
}