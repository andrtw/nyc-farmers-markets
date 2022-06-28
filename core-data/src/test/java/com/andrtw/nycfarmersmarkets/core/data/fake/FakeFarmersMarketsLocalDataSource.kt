package com.andrtw.nycfarmersmarkets.core.data.fake

import com.andrtw.nycfarmersmarkets.core.data.source.FarmersMarketsLocalDataSource
import com.andrtw.nycfarmersmarkets.core.model.FarmersMarket
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.flow

class FakeFarmersMarketsLocalDataSource : FarmersMarketsLocalDataSource {

    private val storage = mutableListOf(*localMarkets.toTypedArray())

    override suspend fun getFarmersMarkets(): Flow<List<FarmersMarket>> = flow {
        emit(storage)
    }

    override suspend fun insertFarmersMarkets(markets: List<FarmersMarket>) {
        storage.addAll(markets)
    }
}
