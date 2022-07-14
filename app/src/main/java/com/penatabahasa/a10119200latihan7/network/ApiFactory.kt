package com.penatabahasa.a10119200latihan7.network

import com.penatabahasa.a10119200latihan7.model.detail.DetailResponse
import com.penatabahasa.a10119200latihan7.model.home.CryptoResponse
import retrofit2.http.GET
import retrofit2.http.Header
import retrofit2.http.Query

/*
14 Juli 2022
10119200
Muhammad Jafar Shidik
IF-5
*/

interface ApiFactory {

    @GET("v1/cryptocurrency/listings/latest")
    suspend fun getData(
        @Header("X-CMC_PRO_API_KEY") apiKey: String,
        @Query("limit") limit: String
    ): CryptoResponse

    @GET("v2/cryptocurrency/info")
    suspend fun getDetail(
        @Header("X-CMC_PRO_API_KEY") apiKey: String,
        @Query("symbol") symbol: String
    ): DetailResponse
}