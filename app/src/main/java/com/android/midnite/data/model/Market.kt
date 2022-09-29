package com.android.midnite.data.model

import com.google.gson.annotations.SerializedName

data class Market(
    @SerializedName("contracts")
    val contracts: List<Contract>,
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
