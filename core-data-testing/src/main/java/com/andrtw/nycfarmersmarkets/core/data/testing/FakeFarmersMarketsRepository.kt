package com.andrtw.nycfarmersmarkets.core.data.testing

import com.andrtw.nycfarmersmarkets.core.data.repository.FarmersMarketsRepository
import com.andrtw.nycfarmersmarkets.core.model.FarmersMarket
import com.andrtw.nycfarmersmarkets.core.testing.fake.fakeFarmersMarket
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.flow
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

    override fun getFarmersMarketByName(name: String): Flow<FarmersMarket?> = flow {
        emit(markets.value.find { it.marketName == name })
    }

    override suspend fun updateFarmersMarkets() {
        if (failUpdate) {
            throw RuntimeException("Stubbed Exception")
        }
        markets.update { it + fakeFarmersMarket("New Farmers Market ${++newMarketsCount}") }
    }
}
