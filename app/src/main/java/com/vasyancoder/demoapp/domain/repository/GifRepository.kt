package com.vasyancoder.demoapp.domain.repository

import com.vasyancoder.demoapp.domain.Resource
import com.vasyancoder.demoapp.domain.entity.Gifs

interface GifRepository {

    suspend fun getTrendGifListUseCase(): Resource<Gifs>
}