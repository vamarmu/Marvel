package com.vamarmu.marvel.di

import com.vamarmu.data.repository.Repository
import com.vamarmu.data.source.RemoteDataSource
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import javax.inject.Named


@Module
@InstallIn(SingletonComponent::class)
object DataModule {

    @Provides
    fun repositoryProvider(
        remoteDataSource : RemoteDataSource
    ) : Repository =  Repository(
        remoteDataSource = remoteDataSource

    )


}