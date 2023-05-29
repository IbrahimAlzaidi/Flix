package com.red_velvet.flix.data.remote.dtos

import com.google.gson.annotations.SerializedName

data class PaginationDto<T>(
    @SerializedName("page")
    val page: Int?,
    @SerializedName("results")
    val items: List<T>?,
    @SerializedName("total_pages")
    val totalPages: Int?,
    @SerializedName("total_results")
    val totalResults: Int?,
)