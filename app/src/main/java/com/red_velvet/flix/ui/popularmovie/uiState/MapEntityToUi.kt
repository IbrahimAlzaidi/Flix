package com.red_velvet.flix.ui.popularmovie.uiState

import com.red_velvet.flix.domain.entity.movie.MovieEntity

fun MovieEntity.toMoviePopularUiState(): MoviePopularUiState {
    return MoviePopularUiState(
        id = id,
        title = title,
        image = imageUrl,
        releaseDate = releaseDate
    )
}