package com.vasyancoder.demoapp.data.network.dto

import com.squareup.moshi.Json

data class ImagesDto(
    @Json(name = "original")
    val originalSize: OriginalSize
)