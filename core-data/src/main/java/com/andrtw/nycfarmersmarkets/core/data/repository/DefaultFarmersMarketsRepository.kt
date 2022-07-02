package com.andrtw.nycfarmersmarkets.core.data.repository

import com.andrtw.nycfarmersmarkets.core.data.source.FarmersMarketsLocalDataSource
import com.andrtw.nycfarmersmarkets.core.data.source.FarmersMarketsRemoteDataSource
import com.andrtw.nycfarmersmarkets.core.model.FarmersMarket
import kotlinx.coroutines.flow.Flow
import javax.inject.Inject

class DefaultFarmersMarketsRepository @Inject constructor(
    private val remoteDataSource: FarmersMarketsRemoteDataSource,
    private val localDataSource: FarmersMarketsLocalDataSource,
) : FarmersMarketsRepository {

    override fun getFarmersMarkets(): Flow<List<FarmersMarket>> {
        return localDataSource.getFarmersMarkets()
    }

    override fun getFarmersMarketByName(name: String): Flow<FarmersMarket?> {
        return localDataSource.getFarmersMarketByName(name)
    }

    override suspend fun updateFarmersMarkets() {
        val markets = remoteDataSource.getFarmersMarkets()
        localDataSource.insertFarmersMarkets(markets)
    }
}
