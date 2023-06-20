package com.red_velvet.flix.ui.nowplayingmovie.uiState

import com.red_velvet.flix.domain.entity.movie.MovieEntity

fun MovieEntity.toMoviesNowPlayingUiState(): MovieNowPlayingUiState {
    return MovieNowPlayingUiState(
        id = id,
        title = title,
        image = imageUrl,
        releaseDate = releaseDate,
    )
}