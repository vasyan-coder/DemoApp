package com.vasyancoder.demoapp.data.network.okhttp

import com.squareup.moshi.JsonEncodingException
import com.vasyancoder.demoapp.data.exception.ConnectionException
import com.vasyancoder.demoapp.data.network.dto.GifsDto
import okhttp3.Request

class ApiServiceImpl : ApiService {

    override suspend fun getTrendGifList(): GifsDto {
        val request = Request.Builder()
            .get()
            .url(ApiFactory.BASE_URL)
            .build()

        val call = ApiFactory.okHttpClient.newCall(request)

        val response = call.execute()

        if (response.isSuccessful) {
            val responseBodySource = response.body!!.source()
            return ApiFactory.jsonAdapter.fromJson(responseBodySource)
                ?: throw JsonEncodingException("Error reading json into ${GifsDto::class.simpleName}")
        }
        throw ConnectionException("The request failed. Response code: ${response.code}")
    }
}