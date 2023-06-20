package com.red_velvet.flix.ui.popularmovie

import com.red_velvet.flix.R
import com.red_velvet.flix.ui.base.BaseAdapter
import com.red_velvet.flix.ui.base.BaseInteractionListener
import com.red_velvet.flix.ui.popularmovie.uiState.MoviePopularUiState

class MoviePopularAdapter(item: List<MoviePopularUiState>, listener: MoviePopularInteractionListener) :
    BaseAdapter<MoviePopularUiState>(item, listener) {
    override val layoutId: Int = R.layout.item_popular_movie

}

interface MoviePopularInteractionListener : BaseInteractionListener {
    fun onMoviePopularCardClick(id: Int)
}