package com.android.midnite.data.repository

import com.android.midnite.data.api.MidniteApi
import com.android.midnite.data.model.MidniteMatchesDto
import com.android.midnite.data.model.details.MidniteMatchDetailDto
import com.android.midnite.utils.ApiResult
import com.android.midnite.utils.apiResult
import javax.inject.Inject

class MidniteRemoteRepositoryImpl @Inject constructor(
    private val matchesApi: MidniteApi,
) : MidniteRemoteRepository {
    override suspend fun getUpcomingMatches(page: Int?): ApiResult<MidniteMatchesDto> {
        return apiResult { matchesApi.getUpcomingMatches(page) }
    }

    override suspend fun getMatchDetails(id: Int): ApiResult<MidniteMatchDetailDto> {
        return apiResult { matchesApi.getMatchDetails(id) }
    }
}
