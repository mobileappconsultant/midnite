package com.android.midnite.data.model.details

import com.google.gson.annotations.SerializedName

data class MarketFilter(
    @SerializedName("market_ids")
    val marketIds: List<Int>,
    @SerializedName("name")
    val name: String
)
