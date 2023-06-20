package com.red_velvet.flix.ui.upcomingmovies

import com.red_velvet.flix.R
import com.red_velvet.flix.ui.base.BaseAdapter
import com.red_velvet.flix.ui.base.BaseInteractionListener
import com.red_velvet.flix.ui.upcomingmovies.uiState.MovieUpComingUiState

class MoviesUpComingAdapter(
    item: List<MovieUpComingUiState>,
    listener: MovieUpComingInteractionListener
) : BaseAdapter<MovieUpComingUiState>(item, listener) {
    override val layoutId: Int = R.layout.item_up_coming_movies
}


interface MovieUpComingInteractionListener : BaseInteractionListener {
    fun onMovieUpComingCardClick(id: Int)
}