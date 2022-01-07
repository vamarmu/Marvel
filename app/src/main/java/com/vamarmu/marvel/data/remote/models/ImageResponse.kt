package com.vamarmu.marvel.data.remote.models

import com.google.gson.annotations.SerializedName

data class ImageResponse(
    @SerializedName("path")
    val path : String?,
    @SerializedName("extension")
    val extension: String?
)
