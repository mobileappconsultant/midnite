package com.android.midnite.data.model

import com.google.gson.annotations.SerializedName
import org.joda.time.DateTime

data class MatchDataDto(
    @SerializedName("away_image_url")
    val awayImageUrl: String,
    @SerializedName("away_team")
    val awayTeam: String,
    @SerializedName("away_team_id")
    val awayTeamId: Int,
    @SerializedName("best_of")
    val bestOf: Int,
    @SerializedName("competition_id")
    val competitionId: Int,
    @SerializedName("competition_name")
    val competitionName: String,
    @SerializedName("competition_region_image_url")
    val competitionRegionImageUrl: String,
    @SerializedName("displayed_format")
    val displayedFormat: String,
    @SerializedName("game_id")
    val gameId: Int,
    @SerializedName("game_name")
    val gameName: String,
    @SerializedName("home_image_url")
    val homeImageUrl: String,
    @SerializedName("home_team")
    val homeTeam: String,
    @SerializedName("home_team_id")
    val homeTeamId: Int,
    @SerializedName("id")
    val id: Int,
    @SerializedName("live_enabled")
    val liveEnabled: Boolean,
    @SerializedName("main_market_id")
    val mainMarketId: Int,
    @SerializedName("market")
    val market: Market,
    @SerializedName("name")
    val name: String,
    @SerializedName("num_bets_placed")
    val numBetsPlaced: Int,
    @SerializedName("num_boosts")
    val numBoosts: Int,
    @SerializedName("num_markets")
    val numMarkets: Int,
    @SerializedName("slug")
    val slug: String,
    @SerializedName("start_time")
    val startTime: DateTime,
    @SerializedName("status")
    val status: String,
    @SerializedName("stream_url")
    val streamUrl: String?,
    @SerializedName("twitch_channel")
    val twitchChannel: String?,
    @SerializedName("type")
    val type: String
)
