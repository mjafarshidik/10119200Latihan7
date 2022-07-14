package com.penatabahasa.a10119200latihan7.model.errorResponse

import com.google.gson.annotations.SerializedName

/*
14 Juli 2022
10119200
Muhammad Jafar Shidik
IF-5
*/

data class Status(
    @SerializedName("credit_count")
    val creditCount: Int?,
    @SerializedName("elapsed")
    val elapsed: Int?,
    @SerializedName("error_code")
    val errorCode: Int?,
    @SerializedName("error_message")
    val errorMessage: String?,
    @SerializedName("timestamp")
    val timestamp: String?
)