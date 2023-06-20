package com.red_velvet.flix.ui.moviesbykeyword

import com.red_velvet.flix.R
import com.red_velvet.flix.ui.base.BaseAdapter
import com.red_velvet.flix.ui.base.BaseInteractionListener
import com.red_velvet.flix.ui.moviesbykeyword.uiState.MovieKeywordsUiState
class MoviesKeywordAdapter (items: List<MovieKeywordsUiState>, listener: MovieInteractionListener) :
    BaseAdapter<MovieKeywordsUiState>(items, listener) {
    override val layoutId: Int = R.layout.item_movie_keyword
}

interface MovieInteractionListener : BaseInteractionListener {
    fun onMovieClick(id: Int)
}