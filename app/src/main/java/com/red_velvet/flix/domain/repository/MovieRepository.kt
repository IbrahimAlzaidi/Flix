package com.red_velvet.flix.domain.repository


import com.red_velvet.flix.data.remote.recoures.movie.MovieResource
import com.red_velvet.flix.domain.entity.ReviewEntity
import com.red_velvet.flix.domain.entity.TrailerEntity
import com.red_velvet.flix.domain.entity.movie.MovieEntity


interface MovieRepository {

    suspend fun getPopularMovies(
        page: Int? = null,
        region: String? = null,
        language: String? = null
    ): List<MovieEntity>

    suspend fun refreshPopularMovies()

    suspend fun getUpcomingMovies(
        page: Int? = null,
        region: String? = null,
        language: String? = null
    ): List<MovieEntity>

    suspend fun refreshUpcomingMovies()

    suspend fun getNowPlayingMovies(
        page: Int? = null,
        region: String? = null,
        language: String? = null
    ): List<MovieEntity>

    suspend fun refreshNowPlayingMovies()

    suspend fun getTopRatedMovies(
        page: Int? = null,
        region: String? = null,
        language: String? = null
    ): List<MovieEntity>

    suspend fun refreshTopRatedMovies()

    suspend fun getMovieDetails(movieId: Int): MovieEntity


    suspend fun getMovieKeywords(movieId: Int): List<String>

    suspend fun getSimilarMovies(
        movieId: Int,
        page: Int? = null,
        language: String? = null
    ): List<MovieEntity>

    suspend fun getMovieTrailers(
        movieId: Int,
        language: String? = null
    ): List<TrailerEntity>

    suspend fun getLatestMovie(): MovieResource

    suspend fun getMovieRecommendations(
        movieId: Int,
        page: Int? = null,
        language: String? = null
    ): List<MovieEntity>

    suspend fun rateMovie(movieId: Int, rating: Double)

    suspend fun deleteMovieRating(movieId: Int)

    suspend fun getMovieReviews(
        movieId: Int,
        page: Int? = null,
        language: String? = null
    ): List<ReviewEntity>

    suspend fun getMoviesWatchlist(
        accountId: Int,
        language: String? = null,
        page: Int? = null,
        sortBy: String? = null
    ): List<MovieEntity>

    suspend fun getFavoriteMovies(
        accountId: Int,
        language: String? = null,
        page: Int? = null,
        sortBy: String? = null
    ): List<MovieEntity>

    suspend fun search(
        query: String,
        includeAdult: Boolean = false,
        language: String? = null,
        page: Int? = null,
    ): List<MovieEntity>

    suspend fun getMoviesByKeyword(
        keywordId: Int,
        includeAdult: Boolean = false,
        language: String? = null,
        page: Int? = null,
        region: String? = null
    ): List<MovieEntity>

    suspend fun discoverMovies(
        includeAdult: Boolean = false,
        language: String? = null,
        page: Int? = null,
        sortBy: String? = null,
        voteAverageGte: Double? = null,
        year: Int? = null,
    ): List<MovieEntity>
}