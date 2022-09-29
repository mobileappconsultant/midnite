package com.android.midnite.data.repository

import com.android.midnite.data.model.MidniteMatchesDto
import com.android.midnite.data.model.details.MidniteMatchDetailDto
import com.android.midnite.utils.ApiResult

interface MidniteRemoteRepository {
    suspend fun getUpcomingMatches(page: Int?): ApiResult<MidniteMatchesDto>
    suspend fun getMatchDetails(id: Int): ApiResult<MidniteMatchDetailDto>
}
