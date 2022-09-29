package com.android.midnite.data.cache.dao

import androidx.paging.PagingSource
import androidx.room.Dao
import androidx.room.Insert
import androidx.room.OnConflictStrategy
import androidx.room.Query
import com.android.midnite.data.cache.entity.MidniteMatchEntity

@Dao
interface MidniteMatchDao {
    @Insert(onConflict = OnConflictStrategy.REPLACE)
    suspend fun insertMatches(matches: List<MidniteMatchEntity>)

    @Query("DELETE FROM match_entity")
    suspend fun clearDatabase()

    @Query("SELECT * FROM match_entity ORDER BY page")
    fun getMatches(): PagingSource<Int, MidniteMatchEntity>

    @Query("SELECT * FROM match_entity ORDER BY page DESC LIMIT 1")
    suspend fun getLastInsertedPage(): MidniteMatchEntity?
}
