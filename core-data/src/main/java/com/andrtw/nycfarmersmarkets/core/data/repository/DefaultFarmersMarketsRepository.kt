package com.andrtw.nycfarmersmarkets.core.data.repository

import com.andrtw.nycfarmersmarkets.core.data.source.FarmersMarketsRemoteDataSource
import com.andrtw.nycfarmersmarkets.core.model.FarmersMarket
import javax.inject.Inject

class DefaultFarmersMarketsRepository @Inject constructor(
    private val remoteDataSource: FarmersMarketsRemoteDataSource,
) : FarmersMarketsRepository {

    override suspend fun getFarmersMarkets(): List<FarmersMarket> {
        return remoteDataSource.getFarmersMarkets()
    }
}
