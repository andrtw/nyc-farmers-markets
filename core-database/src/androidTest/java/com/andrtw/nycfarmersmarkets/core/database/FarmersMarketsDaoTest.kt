package com.andrtw.nycfarmersmarkets.core.database

import android.content.Context
import androidx.room.Room
import androidx.test.core.app.ApplicationProvider
import com.andrtw.nycfarmersmarkets.core.database.dao.FarmersMarketsDao
import com.andrtw.nycfarmersmarkets.core.database.fake.fakeFarmersMarketEntity
import com.google.common.truth.Truth.assertThat
import kotlinx.coroutines.flow.first
import kotlinx.coroutines.test.runTest
import org.junit.After
import org.junit.Before
import org.junit.Test

class FarmersMarketsDaoTest {

    private lateinit var db: NycFarmersMarketsDatabase
    private lateinit var dao: FarmersMarketsDao

    @Before
    fun setUp() {
        val context = ApplicationProvider.getApplicationContext<Context>()
        db = Room.inMemoryDatabaseBuilder(context, NycFarmersMarketsDatabase::class.java).build()
        dao = db.farmersMarketsDao()
    }

    @After
    fun teardown() {
        db.close()
    }

    @Test
    fun farmersMarketsDao_returns_market_by_name() = runTest {
        val marketEntity = fakeFarmersMarketEntity(name = "Test Market")
        dao.upsertFarmersMarkets(listOf(marketEntity))

        assertThat(
            dao.getFarmersMarketByNameStream("Test Market").first()
        ).isEqualTo(
            marketEntity
        )
    }

    @Test
    fun farmersMarketsDao_returns_null_for_non_existent_market() = runTest {
        val marketEntity = fakeFarmersMarketEntity(name = "Test Market")
        dao.upsertFarmersMarkets(listOf(marketEntity))

        assertThat(dao.getFarmersMarketByNameStream("Android Market").first()).isNull()
    }

    @Test
    fun farmersMarketsDao_inserts_market() = runTest {
        val marketEntity = fakeFarmersMarketEntity()
        dao.upsertFarmersMarkets(listOf(marketEntity))

        assertThat(
            dao.getFarmersMarketsStream().first()
        ).isEqualTo(
            listOf(marketEntity)
        )
    }

    @Test
    fun farmersMarketsDao_updates_existing_market() = runTest {
        val marketEntity = fakeFarmersMarketEntity()
        dao.upsertFarmersMarkets(listOf(marketEntity))

        val updatedMarketEntity = fakeFarmersMarketEntity(daysOperation = "Mon, Tue")
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
                fakeFarmersMarketEntity("Test Market 1"),
                fakeFarmersMarketEntity("Test Market 2"),
                fakeFarmersMarketEntity("Test Market 3"),
                fakeFarmersMarketEntity("Test Market 4"),
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
