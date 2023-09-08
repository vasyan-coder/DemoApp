package com.vasyancoder.demoapp.data.network.okhttp

import com.squareup.moshi.JsonAdapter
import com.squareup.moshi.Moshi
import com.squareup.moshi.kotlin.reflect.KotlinJsonAdapterFactory
import com.vasyancoder.demoapp.BuildConfig
import com.vasyancoder.demoapp.data.network.dto.GifsDto
import okhttp3.OkHttpClient

object ApiFactory {


    const val BASE_URL =
        "https://api.giphy.com/v1/gifs/trending?api_key=${BuildConfig.API_KEY}&limit=25&offset=0&rating=g&bundle=messaging_non_clips"

    val okHttpClient = OkHttpClient()

    private val moshi: Moshi = Moshi.Builder()
        .addLast(KotlinJsonAdapterFactory())
        .build()
    val jsonAdapter: JsonAdapter<GifsDto> = moshi.adapter(GifsDto::class.java)
}