package com.red_velvet.flix.ui.upcomingmovies.uiState

import com.red_velvet.flix.ui.base.BaseUiState
import com.red_velvet.flix.ui.base.ErrorUiState

data class UpComingUiState(
    val movieList: List<MovieUpComingUiState> = emptyList(),
    val error: ErrorUiState? = null,
    val isLoading: Boolean = false
) : BaseUiState