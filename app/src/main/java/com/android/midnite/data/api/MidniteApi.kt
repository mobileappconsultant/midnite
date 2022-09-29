package com.android.midnite.data.api

import com.android.midnite.data.model.MidniteMatchesDto
import com.android.midnite.data.model.details.MidniteMatchDetailDto
import retrofit2.http.GET
import retrofit2.http.Path
import retrofit2.http.Query

interface MidniteApi {

    @GET("v0/matches/upcoming")
    suspend fun getUpcomingMatches(
        @Query("page") page: Int? = 1
    ): MidniteMatchesDto

    @GET("v0/matches/{id}")
    suspend fun getMatchDetails(
        @Path("id") id: Int
    ): MidniteMatchDetailDto
}
