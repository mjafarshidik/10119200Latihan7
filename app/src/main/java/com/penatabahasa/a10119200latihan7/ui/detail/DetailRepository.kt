package com.penatabahasa.a10119200latihan7.ui.detail

import com.penatabahasa.a10119200latihan7.base.BaseRepository
import com.penatabahasa.a10119200latihan7.network.ApiFactory
import javax.inject.Inject

/*
14 Juli 2022
10119200
Muhammad Jafar Shidik
IF-5
*/

class DetailRepository @Inject constructor(private val apiFactory: ApiFactory) : BaseRepository() {

    suspend fun getDetail(
        apiKey: String,
        symbol: String
    ) = safeApiRequest {
        apiFactory.getDetail(apiKey, symbol)
    }
}