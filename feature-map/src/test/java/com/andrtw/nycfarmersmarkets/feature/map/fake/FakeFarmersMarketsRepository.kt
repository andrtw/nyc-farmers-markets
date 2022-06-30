package com.andrtw.nycfarmersmarkets.feature.map.fake

import com.andrtw.nycfarmersmarkets.core.data.repository.FarmersMarketsRepository
import com.andrtw.nycfarmersmarkets.core.model.FarmersMarket
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.update

class FakeFarmersMarketsRepository : FarmersMarketsRepository {

    var failUpdate = false

    private var newMarketsCount = 0

    private val markets = MutableStateFlow(
        listOf(
            fakeFarmersMarket("Test Farmers Market 1"),
            fakeFarmersMarket("Test Farmers Market 2"),
        )
    )

    override fun getFarmersMarkets(): Flow<List<FarmersMarket>> = markets

    override suspend fun updateFarmersMarkets() {
        if (failUpdate) {
            throw RuntimeException("Stubbed Exception")
        }
        markets.update { it + fakeFarmersMarket("New Farmers Market ${++newMarketsCount}") }
    }
}
