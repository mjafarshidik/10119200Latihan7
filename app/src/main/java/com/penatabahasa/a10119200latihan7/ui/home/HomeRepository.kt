package com.penatabahasa.a10119200latihan7.ui.home

import com.penatabahasa.a10119200latihan7.base.BaseRepository
import com.penatabahasa.a10119200latihan7.network.ApiFactory
import javax.inject.Inject

class HomeRepository @Inject constructor(private val apiFactory: ApiFactory) : BaseRepository() {

    suspend fun getData(
        apiKey: String,
        limit: String
    ) = safeApiRequest {
        apiFactory.getData(apiKey, limit)
    }
}