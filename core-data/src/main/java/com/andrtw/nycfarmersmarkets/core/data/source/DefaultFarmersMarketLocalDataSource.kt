package com.andrtw.nycfarmersmarkets.core.data.source

import com.andrtw.nycfarmersmarkets.core.data.mapper.toDomainModel
import com.andrtw.nycfarmersmarkets.core.data.mapper.toEntityModel
import com.andrtw.nycfarmersmarkets.core.database.dao.FarmersMarketsDao
import com.andrtw.nycfarmersmarkets.core.database.entity.FarmersMarketEntity
import com.andrtw.nycfarmersmarkets.core.model.FarmersMarket
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.map
import javax.inject.Inject

class DefaultFarmersMarketLocalDataSource @Inject constructor(
    private val dao: FarmersMarketsDao,
) : FarmersMarketsLocalDataSource {

    override fun getFarmersMarkets(): Flow<List<FarmersMarket>> {
        return dao.getFarmersMarketsStream().map { it.map(FarmersMarketEntity::toDomainModel) }
    }

    override fun getFarmersMarketByName(name: String): Flow<FarmersMarket?> {
        return dao.getFarmersMarketByNameStream(name).map { it?.toDomainModel() }
    }

    override suspend fun insertFarmersMarkets(markets: List<FarmersMarket>) {
        dao.upsertFarmersMarkets(markets.map(FarmersMarket::toEntityModel))
    }
}
