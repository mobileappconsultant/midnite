package com.android.midnite.data.model.details

import com.google.gson.annotations.SerializedName

data class MarketDto(
    @SerializedName("contracts")
    val contracts: List<ContractDto>,
    @SerializedName("display_order")
    val displayOrder: Int,
    @SerializedName("id")
    val id: Int,
    @SerializedName("match_id")
    val matchId: Int,
    @SerializedName("name")
    val name: String,
    @SerializedName("popular")
    val popular: Boolean,
    @SerializedName("status")
    val status: String
)
