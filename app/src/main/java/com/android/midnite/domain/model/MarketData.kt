package com.android.midnite.domain.model

data class MarketData(
    val name: String,
    val status: String,
    val contracts: List<MarketContract>
)

data class MarketContract(
    val name: String,
    val price: String,
    val maxBet: String
)
