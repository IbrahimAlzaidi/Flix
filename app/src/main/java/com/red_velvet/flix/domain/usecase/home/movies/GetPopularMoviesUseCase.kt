package com.red_velvet.flix.domain.usecase.home.movies

import android.util.Log
import com.red_velvet.flix.domain.entity.movie.MovieEntity
import com.red_velvet.flix.domain.repository.MovieRepository
import com.red_velvet.flix.domain.usecase.FormatMediaDateAndCountryCodeUsecase
import com.red_velvet.flix.domain.usecase.cachingTimeStamps.ShouldCacheApiResponseUseCase
import javax.inject.Inject
import kotlinx.coroutines.flow.Flow


class GetPopularMoviesUseCase @Inject constructor(
    private val movieRepository: MovieRepository,
    private val shouldCacheApiResponseUseCase: ShouldCacheApiResponseUseCase,
    private val formatMediaDateAndCountryCodeUsecase: FormatMediaDateAndCountryCodeUsecase,
) {

    suspend operator fun invoke(): Flow<List<MovieEntity>> {
        if (shouldCacheApiResponseUseCase("popular_movies")) {
            refreshLocalPopularMovies().also {
                Log.d("refreshLocalPopularMovies", "invoke: $it")
            }
        }
        return movieRepository.getLocalPopularMovies().also {
            Log.d("getLocalPopularMovies", "invoke: $it")
        }
    }
    private suspend fun getPopularMovies(): List<MovieEntity> {
        return movieRepository.getPopularMovies().map {
            it.copy(
                formattedDate = formatMediaDateAndCountryCodeUsecase(
                    it.releaseDate, it.originalLanguage
                ),
            )
        }.also {
            Log.d("getPopularMovies", "$it")
        }

    }

    private suspend fun refreshLocalPopularMovies() {
        val popularMovies = getPopularMovies()
        if (popularMovies.isNotEmpty()) {
            movieRepository.cachePopularMovies(popularMovies).also{
                Log.d("refreshLocalPopularMovies", "Caching completed")
            }
        }
    }

}