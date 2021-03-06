package com.andrtw.nycfarmersmarkets.core.data.source

import com.andrtw.nycfarmersmarkets.core.data.mapper.toDomainModel
import com.andrtw.nycfarmersmarkets.core.model.FarmersMarket
import com.andrtw.nycfarmersmarkets.core.network.NycFarmersMarketsApi
import com.andrtw.nycfarmersmarkets.core.network.model.NetworkFarmersMarket
import javax.inject.Inject

class DefaultFarmersMarketsRemoteDataSource @Inject constructor(
    private val api: NycFarmersMarketsApi,
) : FarmersMarketsRemoteDataSource {

    override suspend fun getFarmersMarkets(): List<FarmersMarket> {
        return api.getMarkets().mapNotNull(NetworkFarmersMarket::toDomainModel)
    }
}
