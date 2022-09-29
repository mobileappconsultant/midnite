package com.android.midnite.data.model

import com.google.gson.annotations.SerializedName

data class MidniteMatchesDto(
    @SerializedName("data")
    val matchData: List<MatchDataDto>,
    @SerializedName("page")
    val page: Int,
    @SerializedName("page_size")
    val pageSize: Int,
    @SerializedName("pages")
    val pages: Int
)
