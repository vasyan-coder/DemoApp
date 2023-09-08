package com.vasyancoder.demoapp.data.network.dto

import com.squareup.moshi.Json

data class OriginalSize(
    @Json(name = "url")
    val url: String
)
