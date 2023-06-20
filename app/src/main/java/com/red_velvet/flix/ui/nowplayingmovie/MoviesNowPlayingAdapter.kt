package com.red_velvet.flix.ui.nowplayingmovie

import com.red_velvet.flix.R
import com.red_velvet.flix.ui.base.BaseAdapter
import com.red_velvet.flix.ui.base.BaseInteractionListener
import com.red_velvet.flix.ui.nowplayingmovie.uiState.MovieNowPlayingUiState

class MoviesNowPlayingAdapter(
    item: List<MovieNowPlayingUiState>,
    listener: MovieNowPlayingInteractionListener
) :
    BaseAdapter<MovieNowPlayingUiState>(item, listener) {
    override val layoutId: Int = R.layout.item_now_playing_movies

}


interface MovieNowPlayingInteractionListener : BaseInteractionListener {
    fun onMoviePlayingNowCardClick(id: Int)
}