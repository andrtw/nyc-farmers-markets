package com.andrtw.nycfarmersmarkets.core.data.repository

import com.andrtw.nycfarmersmarkets.core.model.FarmersMarket
import kotlinx.coroutines.flow.Flow

interface FarmersMarketsRepository {
    suspend fun getFarmersMarkets(): Flow<List<FarmersMarket>>

    suspend fun updateFarmersMarkets()
}
