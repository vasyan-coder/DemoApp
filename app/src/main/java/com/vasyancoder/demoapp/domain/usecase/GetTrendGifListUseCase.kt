package com.vasyancoder.demoapp.domain.usecase

import com.vasyancoder.demoapp.domain.Resource
import com.vasyancoder.demoapp.domain.entity.Gifs
import com.vasyancoder.demoapp.domain.repository.GifRepository

class GetTrendGifListUseCase(
    private val repository: GifRepository
) {

    suspend operator fun invoke(): Resource<Gifs> {
        return repository.getTrendGifListUseCase()
    }
}