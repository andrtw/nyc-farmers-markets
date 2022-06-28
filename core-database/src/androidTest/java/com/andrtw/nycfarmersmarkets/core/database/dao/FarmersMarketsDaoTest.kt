package com.andrtw.nycfarmersmarkets.core.database.dao

import android.content.Context
import androidx.room.Room
import androidx.test.core.app.ApplicationProvider
import com.andrtw.nycfarmersmarkets.core.database.NycFarmersMarketsDatabase
import com.andrtw.nycfarmersmarkets.core.database.dao.fake.fakeFarmersMarket
import com.google.common.truth.Truth.assertThat
import kotlinx.coroutines.ExperimentalCoroutinesApi
import kotlinx.coroutines.flow.first
import kotlinx.coroutines.test.runTest
import org.junit.Before
import org.junit.Test

@OptIn(ExperimentalCoroutinesApi::class)
class FarmersMarketsDaoTest {

    private lateinit var db: NycFarmersMarketsDatabase
    private lateinit var dao: FarmersMarketsDao

    @Before
    fun setUp() {
        val context = ApplicationProvider.getApplicationContext<Context>()
        db = Room.inMemoryDatabaseBuilder(context, NycFarmersMarketsDatabase::class.java).build()
        dao = db.farmersMarketsDao()
    }

    @Test
    fun farmersMarketsDao_inserts_market() = runTest {
        val marketEntity = fakeFarmersMarket()
        dao.upsertFarmersMarkets(listOf(marketEntity))

        assertThat(
            dao.getFarmersMarketsStream().first()
        ).isEqualTo(
            listOf(marketEntity)
        )
    }

    @Test
    fun farmersMarketsDao_updates_existing_market() = runTest {
        val marketEntity = fakeFarmersMarket()
        dao.upsertFarmersMarkets(listOf(marketEntity))

        val updatedMarketEntity = fakeFarmersMarket(daysOperation = "Mon, Tue")
        dao.upsertFarmersMarkets(listOf(updatedMarketEntity))

        assertThat(
            dao.getFarmersMarketsStream().first()
        ).isEqualTo(
            listOf(updatedMarketEntity)
        )
    }

    @Test
    fun farmersMarketsDao_deletes_markets_by_marketName() = runTest {
        dao.insertOrIgnoreFarmersMarkets(
            listOf(
                fakeFarmersMarket("Test Market 1"),
                fakeFarmersMarket("Test Market 2"),
                fakeFarmersMarket("Test Market 3"),
                fakeFarmersMarket("Test Market 4"),
            )
        )
        dao.deleteFarmersMarkets(
            listOf("Test Market 1", "Test Market 3")
        )

        assertThat(
            dao.getFarmersMarketsStream().first().map { it.marketName }
        ).isEqualTo(
            listOf("Test Market 2", "Test Market 4")
        )
    }
}
