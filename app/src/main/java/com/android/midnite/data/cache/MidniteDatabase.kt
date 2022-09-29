package com.android.midnite.data.cache

import androidx.room.Database
import androidx.room.RoomDatabase
import com.android.midnite.data.cache.dao.MidniteMatchDao
import com.android.midnite.data.cache.entity.MidniteMatchEntity

@Database(entities = [MidniteMatchEntity::class], version = 1, exportSchema = false)
abstract class MidniteDatabase : RoomDatabase() {
    abstract fun midniteDao(): MidniteMatchDao
}
