package com.red_velvet.flix.data.remote.recoures.movie

import com.google.gson.annotations.SerializedName

data class MovieCrewResource(
    @SerializedName("adult")
    val adult: Boolean?,
    @SerializedName("gender")
    val gender: Int?,
    @SerializedName("id")
    val id: Int?,
    @SerializedName("known_for_department")
    val knownForDepartment: String?,
    @SerializedName("name")
    val name: String?,
    @SerializedName("popularity")
    val popularity: Double?,
    @SerializedName("profile_path")
    val profilePath: String?,
    @SerializedName("original_name")
    val originalName: String?,
    @SerializedName("credit_id")
    val creditId: String?,
    @SerializedName("job")
    val job: String?,
    @SerializedName("Sound")
    val Sound: String?,
)
