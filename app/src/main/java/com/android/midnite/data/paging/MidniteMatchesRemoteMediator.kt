package com.android.midnite.data.paging

import androidx.paging.ExperimentalPagingApi
import androidx.paging.LoadType
import androidx.paging.PagingState
import androidx.paging.RemoteMediator
import com.android.midnite.data.cache.entity.MidniteMatchEntity
import com.android.midnite.data.repository.MatchesLocalRepository
import com.android.midnite.data.repository.MidniteRemoteRepository
import com.android.midnite.domain.mapper.MidniteMatchesMapper
import com.android.midnite.utils.ApiResult
import java.util.concurrent.TimeUnit
import timber.log.Timber

@OptIn(ExperimentalPagingApi::class)
class MidniteMatchesRemoteMediator(
    private val midniteRemoteRepository: MidniteRemoteRepository,
    private val matchesLocalRepository: MatchesLocalRepository,
    private val mapper: MidniteMatchesMapper
) : RemoteMediator<Int, MidniteMatchEntity>() {
    override suspend fun load(
        loadType: LoadType,
        state: PagingState<Int, MidniteMatchEntity>
    ): MediatorResult {
        val loadKey = when (loadType) {
            LoadType.REFRESH -> {
                Timber.d("Loading Refresh")
                null
            }
            LoadType.PREPEND -> {
                Timber.d("Loading Prepend")

                return MediatorResult.Success(endOfPaginationReached = true)
            }
            LoadType.APPEND -> {
                Timber.d("Loading Append")
                val lastItem = matchesLocalRepository.getLastInsertedPage()
                    ?: return MediatorResult.Success(
                        endOfPaginationReached = true
                    )
                lastItem + 1
            }
        }

        Timber.d("Load type: $loadType")

        return when (val response = midniteRemoteRepository.getUpcomingMatches(loadKey)) {
            is ApiResult.NetworkError -> MediatorResult.Error(response.e)
            is ApiResult.Success -> {
                if (loadType == LoadType.REFRESH) {
                    matchesLocalRepository.clearDb()
                }
                matchesLocalRepository.insertUpcomingMatches(response.data.matchData.map { mapper.mapToEntity(it, response.data.page) })
                MediatorResult.Success(
                    endOfPaginationReached = response.data.page == response.data.pages
                )
            }
        }
    }

    override suspend fun initialize(): InitializeAction {
        val cacheTimeout = TimeUnit.MILLISECONDS.convert(1, TimeUnit.MINUTES)
        return InitializeAction.LAUNCH_INITIAL_REFRESH
    }
}
