package com.red_velvet.flix.ui.topratedmovie

import com.red_velvet.flix.R
import com.red_velvet.flix.ui.base.BaseAdapter
import com.red_velvet.flix.ui.base.BaseInteractionListener
import com.red_velvet.flix.ui.topratedmovie.uiState.MovieTopRatedUiState

class MoviesTopRatedAdapter (
    item: List<MovieTopRatedUiState>,
    listener: MovieTopRatedInteractionListener
): BaseAdapter<MovieTopRatedUiState>(item,listener){
    override val layoutId: Int = R.layout.fragment_top_rated_movies

}

interface MovieTopRatedInteractionListener : BaseInteractionListener {
    fun onMovieTopRatedCardClick(id: Int)
}