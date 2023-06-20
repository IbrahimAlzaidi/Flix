package com.red_velvet.flix.ui.topratedmovie.uiState

import com.red_velvet.flix.domain.entity.movie.MovieEntity

fun MovieEntity.toMovieTopRatedUiState(): MovieTopRatedUiState {
    return MovieTopRatedUiState(
        id = id,
        title = title,
        image = imageUrl,
        releaseDate = releaseDate
    )
}