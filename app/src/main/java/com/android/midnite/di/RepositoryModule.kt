package com.android.midnite.di

import com.android.midnite.data.repository.*
import dagger.Binds
import dagger.Module
import dagger.hilt.InstallIn
import dagger.hilt.android.components.ViewModelComponent

@Module
@InstallIn(ViewModelComponent::class)
abstract class RepositoryModule {

    @Binds
    abstract fun bindMidniteRemoteRepository(midniteRemoteRepositoryImpl: MidniteRemoteRepositoryImpl): MidniteRemoteRepository

    @Binds
    abstract fun bindMidniteLocalRepository(midniteLocalRepositoryImpl: MatchesLocalRepositoryImpl): MatchesLocalRepository
}
