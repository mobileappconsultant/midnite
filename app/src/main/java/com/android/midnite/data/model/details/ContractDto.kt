package com.android.midnite.data.model.details

import com.google.gson.annotations.SerializedName

data class ContractDto(
    @SerializedName("display_order")
    val displayOrder: Int,
    @SerializedName("id")
    val id: Int,
    @SerializedName("market_id")
    val marketId: Int,
    @SerializedName("max_bet")
    val maxBet: String,
    @SerializedName("name")
    val name: String,
    @SerializedName("price")
    val price: String,
    @SerializedName("raw_status")
    val rawStatus: String,
    @SerializedName("status")
    val status: String
)
