package com.andrtw.nycfarmersmarkets.core.data.source

import com.andrtw.nycfarmersmarkets.core.model.FarmersMarket

interface FarmersMarketsRemoteDataSource {
    suspend fun getFarmersMarkets(): List<FarmersMarket>
}
