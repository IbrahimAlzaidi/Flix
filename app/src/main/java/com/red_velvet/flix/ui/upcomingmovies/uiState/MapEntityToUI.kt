package com.red_velvet.flix.ui.upcomingmovies.uiState

import com.red_velvet.flix.domain.entity.movie.MovieEntity

fun MovieEntity.toMoviesUpComingUiState(): MovieUpComingUiState {
    return MovieUpComingUiState(
        id = id,
        title = title,
        image = imageUrl,
        releaseDate = releaseDate
    )
}