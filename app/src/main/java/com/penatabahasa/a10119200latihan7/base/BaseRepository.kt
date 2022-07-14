package com.penatabahasa.a10119200latihan7.base

import com.penatabahasa.a10119200latihan7.di.CryptoApp.Companion.getAppContext
import com.penatabahasa.a10119200latihan7.model.errorResponse.ErrorResponse
import com.penatabahasa.a10119200latihan7.utils.NetworkResult
import com.google.gson.Gson
import com.penatabahasa.a10119200latihan7.R
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.withContext
import retrofit2.HttpException
import java.lang.Exception

/*
14 Juli 2022
10119200
Muhammad Jafar Shidik
IF-5
*/

abstract class BaseRepository {

    suspend fun <T> safeApiRequest(
        apiRequest: suspend () -> T
    ): NetworkResult<T> {
        return withContext(Dispatchers.IO) {
            try {
                NetworkResult.Success(apiRequest.invoke())
            } catch (throwable: Throwable) {
                when (throwable) {
                    is HttpException -> {
                        NetworkResult.Error(
                            false,
                            errorBodyParser(throwable.response()?.errorBody()?.string())
                        )
                    }
                    else -> NetworkResult.Error(true, throwable.localizedMessage)
                }
            }
        }
    }
}

private fun errorBodyParser(error: String?): String {
    error?.let {
        return try {
            val errorResponse = Gson().fromJson(error, ErrorResponse::class.java)
            val errorMessage = errorResponse.status?.errorMessage
            errorMessage ?: getAppContext().resources.getString(R.string.error_message)
        } catch (e: Exception) {
            getAppContext().resources.getString(R.string.error_message)
        }
    }
    return getAppContext().resources.getString(R.string.error_message)
}