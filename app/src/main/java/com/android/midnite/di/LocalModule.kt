package com.android.midnite.di

import android.content.Context
import android.content.SharedPreferences
import androidx.room.Room
import com.android.midnite.data.cache.MidniteDatabase
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.android.qualifiers.ApplicationContext
import dagger.hilt.components.SingletonComponent
import javax.inject.Singleton

@Module
@InstallIn(SingletonComponent::class)
object LocalModule {

    @Provides
    @Singleton
    fun provideDatabase(@ApplicationContext context: Context): MidniteDatabase {
        return Room.databaseBuilder(context, MidniteDatabase::class.java, "midnite_database").build()
    }

    @Provides
    @Singleton
    fun providesDao(midniteDatabase: MidniteDatabase) = midniteDatabase.midniteDao()

    @Provides
    @Singleton
    fun providesSharedPrefs(
        @ApplicationContext applicationContext: Context
    ): SharedPreferences {
        return applicationContext.getSharedPreferences("midnite_prefs", Context.MODE_PRIVATE)
    }
}
