package com.penatabahasa.a10119200latihan7.utils

/*
14 Juli 2022
10119200
Muhammad Jafar Shidik
IF-5
*/

sealed class NetworkResult<T>(
    val data: T? = null,
    val message: String? = null,
    val networkError: Boolean = false
) {
    class Success<T>(data: T) : NetworkResult<T>(data)
    class Error<T>(networkError: Boolean, message: String?) :
        NetworkResult<T>(data = null, message = message, networkError = networkError)
}