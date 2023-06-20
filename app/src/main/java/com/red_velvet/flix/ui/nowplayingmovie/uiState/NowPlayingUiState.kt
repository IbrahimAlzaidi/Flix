package com.red_velvet.flix.ui.nowplayingmovie.uiState

import com.red_velvet.flix.ui.base.BaseUiState
import com.red_velvet.flix.ui.base.ErrorUiState

data class NowPlayingUiState(
    val movieList: List<MovieNowPlayingUiState> = emptyList(),
    val error: ErrorUiState? = null,
    val isLoading: Boolean = false
) : BaseUiState

