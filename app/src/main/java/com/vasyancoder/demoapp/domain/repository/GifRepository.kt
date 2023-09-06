package com.vasyancoder.demoapp.domain.repository

import com.vasyancoder.demoapp.domain.entity.Gif

interface GifRepository {

    suspend fun getTrendGifListUseCase(): List<Gif>
}