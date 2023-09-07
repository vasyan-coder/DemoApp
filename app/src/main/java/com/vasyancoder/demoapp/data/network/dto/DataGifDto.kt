package com.vasyancoder.demoapp.data.network.dto

import com.squareup.moshi.Json

data class DataGifDto(
    @Json(name = "id")
    val id: String,
    @Json(name = "title")
    val title: String,
    @Json(name = "url")
    val url: String,
    @Json(name = "username")
    val username: String
)
