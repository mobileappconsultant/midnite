package com.android.midnite.domain.model

data class UpcomingMatchDetail(
    val id: Int,
    val homeTeam: String,
    val awayTeam: String,
    val homeImageUrl: String,
    val awayImageUrl: String,
    val gameName: String,
    val competitionName: String,
    val marketData: List<MarketData>,
    val startTime: String
)
