package com.andrtw.nycfarmersmarkets.core.data.repository

import com.andrtw.nycfarmersmarkets.core.data.fake.*
import com.google.common.truth.Truth.assertThat
import kotlinx.coroutines.ExperimentalCoroutinesApi
import kotlinx.coroutines.flow.first
import kotlinx.coroutines.test.runTest
import org.junit.Before
import org.junit.Test

@ExperimentalCoroutinesApi
class FarmersMarketsRepositoryTest {

    private lateinit var repository: FarmersMarketsRepository

    @Before
    fun setUp() {
        repository = DefaultFarmersMarketsRepository(
            remoteDataSource = FakeFarmersMarketsRemoteDataSource(),
            localDataSource = FakeFarmersMarketsLocalDataSource(),
        )
    }

    @Test
    fun `farmersMarketsRepository returns markets from local storage`() = runTest {
        val markets = repository.getFarmersMarkets().first()
        assertThat(markets).isEqualTo(localMarkets)
    }

    @Test
    fun `farmersMarketsRepository return market by name`() = runTest {
        val market = repository.getFarmersMarketByName("Local Market 1").first()
        assertThat(market).isEqualTo(localFarmersMarket1)
    }

    @Test
    fun `farmersMarketsRepository inserts new markets`() = runTest {
        repository.updateFarmersMarkets()
        val markets = repository.getFarmersMarkets().first()
        assertThat(markets).isEqualTo(allMarkets)
    }
}
