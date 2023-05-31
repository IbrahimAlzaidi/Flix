package com.red_velvet.flix.domain.mapper

import com.red_velvet.flix.data.remote.dtos.movie.KeywordsDto

fun KeywordsDto.toKeywords(): List<String> {
    return keywords?.map { it?.name.orEmpty() } ?: emptyList()
}