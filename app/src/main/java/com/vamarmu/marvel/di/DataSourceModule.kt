package com.vamarmu.marvel.di


import com.vamarmu.data.source.RemoteDataSource
import com.vamarmu.marvel.data.remote.MarvelDataSource
import dagger.Binds
import dagger.Module
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import javax.inject.Singleton


@Module
@InstallIn(SingletonComponent::class)
abstract class RemoteDataSourceModule{

    @Singleton
    @Binds
    abstract fun binMarvelDataSource (impl : MarvelDataSource) : RemoteDataSource

}

