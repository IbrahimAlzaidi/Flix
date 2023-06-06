package com.red_velvet.flix.domain.usecase

import com.red_velvet.flix.domain.model.movie.MovieEntity
import com.red_velvet.flix.domain.repository.MovieRepository
import javax.inject.Inject

class GetMoviesByKeywordUsecase @Inject constructor(
    private val movieRepository: MovieRepository
) {
    suspend operator fun invoke(
        keywordId: Int,
        includeAdult: Boolean = false,
        language: String? = null,
        page: Int? = null,
        region: String? = null
    ): List<MovieEntity> {
        return movieRepository.getMoviesByKeyword(keywordId, includeAdult, language, page, region)
    }
}