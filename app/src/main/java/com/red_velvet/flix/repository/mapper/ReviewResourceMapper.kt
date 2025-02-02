package com.red_velvet.flix.repository.mapper

import com.red_velvet.flix.data.remote.recoures.Pagination
import com.red_velvet.flix.data.remote.recoures.review.AuthorDetailsResource
import com.red_velvet.flix.data.remote.recoures.review.ReviewResource
import com.red_velvet.flix.domain.entity.ReviewEntity
import com.red_velvet.flix.domain.entity.movie.AuthorDetailsEntity
import com.red_velvet.flix.domain.utils.orZero


fun ReviewResource.toEntity(): ReviewEntity {
    return ReviewEntity(
        id = id?.toInt()!!,
        author = authorDetails?.toEntity()!!,
        content = content.orEmpty(),
        createdAt = createdAt.orEmpty(),
        updatedAt = updatedAt.orEmpty(),
        imageUrl = authorDetails.avatarPath.orEmpty(),
        rating = authorDetails.rating.orZero(),
        username = authorDetails.username.orEmpty(),
    )
}

fun AuthorDetailsResource.toEntity(): AuthorDetailsEntity {
    return AuthorDetailsEntity(
        avatarPath = avatarPath.orEmpty(),
        name = name.orEmpty(),
        rating = rating.orZero(),
        username = username.orEmpty(),
    )
}

fun Pagination<ReviewResource>.toEntity(): List<ReviewEntity> {
    return items?.map { it.toEntity() } ?: emptyList()
}