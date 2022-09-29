package com.android.midnite.data.repository

import androidx.paging.PagingSource
import com.android.midnite.data.cache.MidniteDatabase
import com.android.midnite.data.cache.entity.MidniteMatchEntity
import com.android.midnite.data.prefs.SharedPrefs
import javax.inject.Inject

interface MatchesLocalRepository {
    fun getUpcomingMatches(): PagingSource<Int, MidniteMatchEntity>
    suspend fun insertUpcomingMatches(matches: List<MidniteMatchEntity>)
    suspend fun getLastInsertedPage(): Int?
    suspend fun clearDb()
}

class MatchesLocalRepositoryImpl @Inject constructor(
    database: MidniteDatabase,
    private val sharedPrefs: SharedPrefs
) : MatchesLocalRepository {
    private val matchesDao = database.midniteDao()

    override fun getUpcomingMatches(): PagingSource<Int, MidniteMatchEntity> = matchesDao.getMatches()

    override suspend fun insertUpcomingMatches(matches: List<MidniteMatchEntity>) {
        matchesDao.insertMatches(matches)
        sharedPrefs.updateLastDbUpdateTime(System.currentTimeMillis())
    }

    override suspend fun getLastInsertedPage(): Int? = matchesDao.getLastInsertedPage()?.page
    override suspend fun clearDb() {
        matchesDao.clearDatabase()
    }
}
