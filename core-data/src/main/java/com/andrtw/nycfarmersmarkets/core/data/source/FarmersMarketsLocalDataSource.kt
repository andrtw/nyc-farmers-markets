package com.andrtw.nycfarmersmarkets.core.data.source

import com.andrtw.nycfarmersmarkets.core.model.FarmersMarket
import kotlinx.coroutines.flow.Flow

interface FarmersMarketsLocalDataSource {
    fun getFarmersMarkets(): Flow<List<FarmersMarket>>

    suspend fun insertFarmersMarkets(markets: List<FarmersMarket>)
}
