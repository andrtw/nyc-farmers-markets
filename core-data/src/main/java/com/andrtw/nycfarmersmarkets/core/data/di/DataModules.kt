package com.andrtw.nycfarmersmarkets.core.data.di

import com.andrtw.nycfarmersmarkets.core.data.repository.DefaultFarmersMarketsRepository
import com.andrtw.nycfarmersmarkets.core.data.repository.FarmersMarketsRepository
import com.andrtw.nycfarmersmarkets.core.data.source.DefaultFarmersMarketLocalDataSource
import com.andrtw.nycfarmersmarkets.core.data.source.DefaultFarmersMarketsRemoteDataSource
import com.andrtw.nycfarmersmarkets.core.data.source.FarmersMarketsLocalDataSource
import com.andrtw.nycfarmersmarkets.core.data.source.FarmersMarketsRemoteDataSource
import dagger.Binds
import dagger.Module
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import javax.inject.Singleton

@Module
@InstallIn(SingletonComponent::class)
interface RepositoryModule {

    @Binds
    @Singleton
    fun bindFarmersMarketRepository(repository: DefaultFarmersMarketsRepository): FarmersMarketsRepository
}

@Module
@InstallIn(SingletonComponent::class)
interface DataSourceModule {

    @Binds
    @Singleton
    fun bindFarmersMarketRemoteDataSource(remoteDataSource: DefaultFarmersMarketsRemoteDataSource): FarmersMarketsRemoteDataSource

    @Binds
    @Singleton
    fun bindFarmersMarketLocalDataSource(localDataSource: DefaultFarmersMarketLocalDataSource): FarmersMarketsLocalDataSource
}
