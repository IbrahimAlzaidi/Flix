package com.red_velvet.flix.ui.topratedmovie.uiState

import com.red_velvet.flix.ui.base.BaseUiState
import com.red_velvet.flix.ui.base.ErrorUiState

data class TopRatedUiState(
    val movieList: List<MovieTopRatedUiState> = emptyList(),
    val error: ErrorUiState? = null,
    val isLoading: Boolean = false
) : BaseUiState
