package com.red_velvet.flix.ui.moviesbykeyword.uiState

import com.red_velvet.flix.domain.entity.movie.MovieEntity
fun MovieEntity.toMovieKeywordsUiStates() : MovieKeywordsUiState {
    return MovieKeywordsUiState(
        id = id,
        title = title,
        image = imageUrl,
        releaseDate = releaseDate
    )
}