package com.penatabahasa.a10119200latihan7.model.detail

import com.google.gson.annotations.SerializedName

/*
14 Juli 2022
10119200
Muhammad Jafar Shidik
IF-5
*/

data class Urls(
    @SerializedName("announcement")
    val announcement: List<String>?,
    @SerializedName("chat")
    val chat: List<String>?,
    @SerializedName("explorer")
    val explorer: List<String>?,
    @SerializedName("facebook")
    val facebook: List<Any>?,
    @SerializedName("message_board")
    val messageBoard: List<String>?,
    @SerializedName("reddit")
    val reddit: List<String>?,
    @SerializedName("source_code")
    val sourceCode: List<String>?,
    @SerializedName("technical_doc")
    val technicalDoc: List<String>?,
    @SerializedName("twitter")
    val twitter: List<String>?,
    @SerializedName("website")
    val website: List<String>?
)