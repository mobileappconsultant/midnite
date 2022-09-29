package com.android.midnite.data.cache.entity

import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity(tableName = "match_entity")
data class MidniteMatchEntity(
    @PrimaryKey
    val id: Int,
    val page: Int,
    val homeTeam: String,
    val awayTeam: String,
    val homeImageUrl: String,
    val awayImageUrl: String,
    val gameName: String,
    val competitionName: String,
    val startTime: String
)
