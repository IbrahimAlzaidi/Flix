package com.red_velvet.flix.domain.usecase

import com.red_velvet.flix.domain.model.series.SeriesEntity
import com.red_velvet.flix.domain.repository.TVShowsRepository
import javax.inject.Inject

class GetLatestTVShowUsecase @Inject constructor(private val tvShowsRepository: TVShowsRepository) {
    suspend operator fun invoke(): SeriesEntity {
        return tvShowsRepository.getLatestTVShow()
    }
}