package com.vasyancoder.demoapp.data.network.dto

import com.squareup.moshi.Json

data class GifsDto(
    @Json(name = "data")
    val dataGifDto: List<DataGifDto>
)