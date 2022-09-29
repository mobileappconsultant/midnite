package com.android.midnite.domain.usecase

import com.android.midnite.data.repository.MidniteRemoteRepository
import com.android.midnite.domain.mapper.MidniteMatchesMapper
import com.android.midnite.domain.model.UpcomingMatchDetail
import com.android.midnite.utils.ApiResult
import javax.inject.Inject

class GetMatchDetailsUseCase @Inject constructor(
    private val midniteRemoteRepository: MidniteRemoteRepository,
    private val matchesMapper: MidniteMatchesMapper
) {
    suspend fun execute(id: Int): DetailsResult {
        val response = midniteRemoteRepository.getMatchDetails(id)
        val errorMessage: String
        val data: UpcomingMatchDetail?
        when (response) {
            is ApiResult.NetworkError -> {
                errorMessage = response.e.localizedMessage ?: "An error occurred"
                data = null
            }
            is ApiResult.Success -> {
                errorMessage = "Data fetched"
                data = matchesMapper.mapToItem(response.data)
            }
        }

        return DetailsResult(
            message = errorMessage,
            data = data
        )
    }
}

data class DetailsResult(
    val message: String,
    val data: UpcomingMatchDetail?
)
