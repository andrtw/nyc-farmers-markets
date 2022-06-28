package com.andrtw.nycfarmersmarkets.core.data.fake

import com.andrtw.nycfarmersmarkets.core.data.source.FarmersMarketsRemoteDataSource
import com.andrtw.nycfarmersmarkets.core.model.FarmersMarket

class FakeFarmersMarketsRemoteDataSource : FarmersMarketsRemoteDataSource {
    override suspend fun getFarmersMarkets(): List<FarmersMarket> {
        return listOf(*remoteMarkets.toTypedArray())
    }
}
