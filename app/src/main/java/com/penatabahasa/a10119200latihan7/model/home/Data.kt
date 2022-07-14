package com.penatabahasa.a10119200latihan7.model.home

import com.google.gson.annotations.SerializedName

/*
14 Juli 2022
10119200
Muhammad Jafar Shidik
IF-5
*/

data class Data(
    @SerializedName("date_added")
    val dateAdded: String?,
    @SerializedName("id")
    val id: Int?,
    @SerializedName("last_updated")
    val lastUpdated: String?,
    @SerializedName("name")
    val name: String?,
    @SerializedName("platform")
    val platform: Any?,
    @SerializedName("quote")
    val quote: Quote?,
    @SerializedName("self_reported_circulating_supply")
    val selfReportedCirculatingSupply: Any?,
    @SerializedName("self_reported_market_cap")
    val selfReportedMarketCap: Any?,
    @SerializedName("slug")
    val slug: String?,
    @SerializedName("symbol")
    val symbol: String?,
    @SerializedName("tags")
    val tags: List<String>?
)