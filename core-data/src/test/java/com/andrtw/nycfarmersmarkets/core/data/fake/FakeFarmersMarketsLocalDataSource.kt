package com.andrtw.nycfarmersmarkets.core.data.fake

import com.andrtw.nycfarmersmarkets.core.data.source.FarmersMarketsLocalDataSource
import com.andrtw.nycfarmersmarkets.core.model.FarmersMarket
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.flow

class FakeFarmersMarketsLocalDataSource : FarmersMarketsLocalDataSource {

    private val storage = mutableListOf(*localMarkets.toTypedArray())

    override fun getFarmersMarkets(): Flow<List<FarmersMarket>> = flow {
        emit(storage)
    }

    override fun getFarmersMarketByName(name: String): Flow<FarmersMarket?> = flow {
        emit(storage.find { it.marketName == name })
    }

    override suspend fun insertFarmersMarkets(markets: List<FarmersMarket>) {
        storage.addAll(markets)
    }
}
