package com.android.midnite.domain.model

data class UpcomingMatchItem(
    val id: Int,
    val homeTeam: String,
    val awayTeam: String,
    val homeImageUrl: String,
    val awayImageUrl: String,
    val gameName: String,
    val competitionName: String,
    val startTime: String
)
