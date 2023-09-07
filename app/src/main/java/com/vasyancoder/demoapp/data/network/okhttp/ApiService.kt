package com.vasyancoder.demoapp.data.network.okhttp

import com.vasyancoder.demoapp.data.network.dto.GifsDto

interface ApiService {

    suspend fun getTrendGifList(): GifsDto
}