package com.andrtw.nycfarmersmarkets.core.data.repository

import com.andrtw.nycfarmersmarkets.core.model.FarmersMarket

interface FarmersMarketsRepository {
    suspend fun getFarmersMarkets(): List<FarmersMarket>
}
