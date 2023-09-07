package com.vasyancoder.demoapp.data.repository

import com.vasyancoder.demoapp.data.mapper.GifMapper
import com.vasyancoder.demoapp.data.network.okhttp.ApiServiceImpl
import com.vasyancoder.demoapp.domain.entity.Gifs
import com.vasyancoder.demoapp.domain.repository.GifRepository

class GifRepositoryImpl : GifRepository {

    private val api = ApiServiceImpl()
    private val mapper = GifMapper()

    override suspend fun getTrendGifListUseCase(): Gifs =
        mapper.mapDtoToEntity(api.getTrendGifList())
}