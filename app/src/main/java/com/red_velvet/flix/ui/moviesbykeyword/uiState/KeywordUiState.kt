package com.red_velvet.flix.ui.moviesbykeyword.uiState

import com.red_velvet.flix.ui.base.BaseUiState
import com.red_velvet.flix.ui.base.ErrorUiState

data class KeywordUiState(
    val movieList : List<MovieKeywordsUiState> = emptyList(),
    val error: ErrorUiState? = null
) : BaseUiState