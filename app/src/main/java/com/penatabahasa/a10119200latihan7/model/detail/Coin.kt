package com.penatabahasa.a10119200latihan7.model.detail

import com.google.gson.annotations.SerializedName

/*
14 Juli 2022
10119200
Muhammad Jafar Shidik
IF-5
*/

data class Coin(
    @SerializedName("id")
    val id: String?,
    @SerializedName("name")
    val name: String?,
    @SerializedName("slug")
    val slug: String?,
    @SerializedName("symbol")
    val symbol: String?
)