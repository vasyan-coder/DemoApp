package com.vasyancoder.demoapp.domain.usecase

import com.vasyancoder.demoapp.domain.entity.Gif
import com.vasyancoder.demoapp.domain.repository.GifRepository

class GetTrendGifListUseCase(
    private val repository: GifRepository
) {

    suspend operator fun invoke(): List<Gif> {
        return repository.getTrendGifListUseCase()
    }
}