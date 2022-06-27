package com.andrtw.nycfarmersmarkets.core.network

import com.andrtw.nycfarmersmarkets.core.network.model.NetworkMarket
import retrofit2.http.GET

interface NycFarmersMarketsApi {
    @GET("resource/8vwk-6iz2.json")
    suspend fun getMarkets(): List<NetworkMarket>
}
