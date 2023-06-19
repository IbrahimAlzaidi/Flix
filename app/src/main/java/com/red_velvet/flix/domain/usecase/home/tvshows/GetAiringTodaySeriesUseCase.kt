package com.red_velvet.flix.domain.usecase.home.tvshows

import android.util.Log
import com.red_velvet.flix.domain.entity.series.SeriesEntity
import com.red_velvet.flix.domain.repository.SeriesRepository
import com.red_velvet.flix.domain.usecase.FormatMediaDateAndCountryCodeUsecase
import com.red_velvet.flix.domain.usecase.cachingTimeStamps.ShouldCacheApiResponseUseCase
import kotlinx.coroutines.flow.Flow
import javax.inject.Inject


class GetAiringTodaySeriesUseCase @Inject constructor(
    private val seriesRepository: SeriesRepository,
    private val shouldCacheApiResponseUseCase: ShouldCacheApiResponseUseCase,
    private val formatMediaDateAndCountryCodeUsecase: FormatMediaDateAndCountryCodeUsecase,
) {

    suspend operator fun invoke(): Flow<List<SeriesEntity>> {
        try {
            refreshLocalAiringTodaySeries().also {
                Log.d("GetAiringTodaySeriesUseCase", "refreshLocalAiringTodaySeries $it ")
            }
            return seriesRepository.getLocalAiringTodaySeries().also {
                Log.d("getLocalAiringTodaySeries", "$it")
            }
        } catch (e: Exception) {
            Log.e("GetAiringTodaySeriesUseCase", "Exception in invoke: ${e.stackTrace}", e)
            throw e
        }
    }

    private suspend fun getAiringTodaySeries(): List<SeriesEntity> {
        try {
            return seriesRepository.getAiringTodaySeries().map {
                it.copy(
                    formattedDate = formatMediaDateAndCountryCodeUsecase.getFormattedSeriesDate(
                        it.firstAirDate
                    ),
                )
            }.also {
                Log.d("GetAiringTodaySeriesUseCase", "getAiringTodaySeries $it ")
            }
        } catch (e: Exception) {
            Log.e("GetAiringTodaySeriesUseCase", "Exception in getAiringTodaySeries: ${e.stackTrace}", e)
            throw e
        }
    }

    private suspend fun refreshLocalAiringTodaySeries() {
        try {
            val airingTodaySeries = getAiringTodaySeries().also {
                Log.d("GetAiringTodaySeriesUseCase", "refreshLocalAiringTodaySeries $it ")
            }
            seriesRepository.cacheAiringTodaySeries(airingTodaySeries).also {
                Log.d("GetAiringTodaySeriesUseCase", "refreshLocalAiringTodaySeries $it ")
            }
        } catch (e: Exception) {
            Log.e("GetAiringTodaySeriesUseCase", "Exception in refreshLocalAiringTodaySeries: ${e.stackTrace}", e)
            throw e
        }
    }
}