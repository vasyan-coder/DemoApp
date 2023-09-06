package com.vasyancoder.demoapp.domain.entity


import com.squareup.moshi.Json

data class Gif(
    @Json(name = "data")
    val dataGif: List<DataGif>
)