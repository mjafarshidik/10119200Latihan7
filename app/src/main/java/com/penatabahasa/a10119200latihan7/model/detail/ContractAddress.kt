package com.penatabahasa.a10119200latihan7.model.detail

import com.google.gson.annotations.SerializedName

/*
14 Juli 2022
10119200
Muhammad Jafar Shidik
IF-5
*/

data class ContractAddress(
    @SerializedName("contract_address")
    val contractAddress: String?,
    @SerializedName("platform")
    val platform: Platform?
)