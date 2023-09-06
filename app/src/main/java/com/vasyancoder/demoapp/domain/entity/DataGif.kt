package com.vasyancoder.demoapp.domain.entity


import com.squareup.moshi.Json

data class DataGif(
    @Json(name = "id")
    val id: String,
    @Json(name = "title")
    val title: String,
    @Json(name = "url")
    val url: String,
    @Json(name = "username")
    val username: String
)