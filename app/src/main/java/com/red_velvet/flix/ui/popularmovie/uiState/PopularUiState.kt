package com.red_velvet.flix.ui.popularmovie.uiState

import com.red_velvet.flix.ui.base.BaseUiState
import com.red_velvet.flix.ui.base.ErrorUiState

data class PopularUiState(
    val movieList: List<MoviePopularUiState> = emptyList(),
    val error: ErrorUiState? = null,
    val isLoading: Boolean = false
) : BaseUiState