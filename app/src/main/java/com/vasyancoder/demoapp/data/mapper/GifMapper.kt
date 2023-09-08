package com.vasyancoder.demoapp.data.mapper

import com.vasyancoder.demoapp.data.network.dto.GifsDto
import com.vasyancoder.demoapp.domain.entity.DataGif
import com.vasyancoder.demoapp.domain.entity.Gifs

class GifMapper {

    fun mapDtoToEntity(dto: GifsDto): Gifs = Gifs(
        dataGif = dto.dataGifDto.map { dataGifDto ->
            DataGif(
                id = dataGifDto.id,
                title = dataGifDto.title,
                url = dataGifDto.images.originalSize.url,
                username = dataGifDto.username
            )
        }
    )
}