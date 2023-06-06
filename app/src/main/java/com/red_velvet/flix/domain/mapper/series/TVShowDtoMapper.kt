package com.red_velvet.flix.domain.mapper.series

import com.red_velvet.flix.BuildConfig
import com.red_velvet.flix.data.local.database.entity.AiringTodaySeriesDto
import com.red_velvet.flix.data.local.database.entity.OnTheAirSeriesDto
import com.red_velvet.flix.data.local.database.entity.PopularSeriesDto
import com.red_velvet.flix.data.local.database.entity.TopRatedSeriesDto
import com.red_velvet.flix.data.remote.recoures.tv_show.TVShowResource
import com.red_velvet.flix.domain.model.series.SeriesEntity
import com.red_velvet.flix.domain.utils.orZero

fun TVShowResource.toModel(): SeriesEntity {
    return SeriesEntity(
        id = id.orZero(),
        name = name.orEmpty(),
        imageUrl = BuildConfig.IMAGE_BASE_PATH + posterPath,
        firstAirDate = firstAirDate.orEmpty(),
        popularity = popularity.orZero(),
        voteAverage = voteAverage.orZero()
    )
}

fun List<TVShowResource>.toModel(): List<SeriesEntity> {
    return map { it.toModel() }
}


fun TVShowResource.toPopularTvShowEntity(): PopularSeriesDto {
    return PopularSeriesDto(
        id = id.orZero().toLong(),
        title = name.orEmpty(),
        originalLanguage = originalLanguage.orEmpty(),
        overview = overview.orEmpty(),
        imageUrl = BuildConfig.IMAGE_BASE_PATH + posterPath,
        date = firstAirDate.orEmpty(),
        popularity = popularity.orZero(),
        voteAverage = voteAverage.orZero()
    )
}


fun List<TVShowResource>.toPopularTvShowEntityList(): List<PopularSeriesDto> {
    return map { it.toPopularTvShowEntity() }
}

fun TVShowResource.toTopRatedTvShowEntity(): TopRatedSeriesDto {
    return TopRatedSeriesDto(
        id = id.orZero().toLong(),
        title = name.orEmpty(),
        originalLanguage = originalLanguage.orEmpty(),
        overview = overview.orEmpty(),
        imageUrl = BuildConfig.IMAGE_BASE_PATH + posterPath,
        date = firstAirDate.orEmpty(),
        popularity = popularity.orZero(),
        voteAverage = voteAverage.orZero()
    )
}

fun List<TVShowResource>.toTopRatedTvShowEntityList(): List<TopRatedSeriesDto> {
    return map { it.toTopRatedTvShowEntity() }
}


fun TVShowResource.toAirngTodayTvShowEntity(): AiringTodaySeriesDto {
    return AiringTodaySeriesDto(
        id = id.orZero().toLong(),
        title = name.orEmpty(),
        originalLanguage = originalLanguage.orEmpty(),
        overview = overview.orEmpty(),
        imageUrl = BuildConfig.IMAGE_BASE_PATH + posterPath,
        date = firstAirDate.orEmpty(),
        popularity = popularity.orZero(),
        voteAverage = voteAverage.orZero()

    )
}

fun List<TVShowResource>.toAiringTodayTvShowEntityList(): List<AiringTodaySeriesDto> {
    return map { it.toAirngTodayTvShowEntity() }
}

fun TVShowResource.toOnTheAirTvShowEntity(): OnTheAirSeriesDto {
    return OnTheAirSeriesDto(
        id = id.orZero().toLong(),
        title = name.orEmpty(),
        originalLanguage = originalLanguage.orEmpty(),
        overview = overview.orEmpty(),
        imageUrl = BuildConfig.IMAGE_BASE_PATH + posterPath,
        date = firstAirDate.orEmpty(),
        popularity = popularity.orZero(),
        voteAverage = voteAverage.orZero()
    )
}

fun List<TVShowResource>.toOnTheAirTvShowEntityList(): List<OnTheAirSeriesDto> {
    return map { it.toOnTheAirTvShowEntity() }
}
