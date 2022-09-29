package com.android.midnite.domain.usecase

import androidx.paging.ExperimentalPagingApi
import androidx.paging.Pager
import androidx.paging.PagingConfig
import androidx.paging.PagingData
import androidx.paging.map
import com.android.midnite.data.paging.MidniteMatchesRemoteMediator
import com.android.midnite.data.repository.MatchesLocalRepository
import com.android.midnite.data.repository.MidniteRemoteRepository
import com.android.midnite.domain.mapper.MidniteMatchesMapper
import com.android.midnite.domain.model.UpcomingMatchItem
import dagger.hilt.android.scopes.ViewModelScoped
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.flow
import javax.inject.Inject
import kotlinx.coroutines.flow.map

@OptIn(ExperimentalPagingApi::class)
@ViewModelScoped
class GetUpcomingMatchesUseCase @Inject constructor(
    private val midniteRemoteRepository: MidniteRemoteRepository,
    private val midniteLocalRepository: MatchesLocalRepository,
    private val midniteMapper: MidniteMatchesMapper
) {
    fun execute(): Flow<PagingData<UpcomingMatchItem>> {
        val pager = Pager(
            config = PagingConfig(pageSize = 30),
            initialKey = null,
            remoteMediator = MidniteMatchesRemoteMediator(
                midniteRemoteRepository, midniteLocalRepository, midniteMapper
            )
        ) {
            midniteLocalRepository.getUpcomingMatches()
        }

        return pager.flow.map {
            it.map {
                midniteMapper.mapToItem(it)
            }
        }
    }
}
