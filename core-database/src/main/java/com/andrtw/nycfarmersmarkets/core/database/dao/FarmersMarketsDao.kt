package com.andrtw.nycfarmersmarkets.core.database.dao

import androidx.room.*
import com.andrtw.nycfarmersmarkets.core.database.entity.FarmersMarketEntity
import com.andrtw.nycfarmersmarkets.core.database.util.upsert
import kotlinx.coroutines.flow.Flow

@Dao
interface FarmersMarketsDao {
    @Query("SELECT * FROM farmers_markets")
    fun getFarmersMarketsStream(): Flow<List<FarmersMarketEntity>>

    @Insert(onConflict = OnConflictStrategy.IGNORE)
    suspend fun insertOrIgnoreFarmersMarkets(markets: List<FarmersMarketEntity>): List<Long>

    @Update
    suspend fun updateFarmersMarkets(markets: List<FarmersMarketEntity>)

    @Transaction
    suspend fun upsertFarmersMarkets(markets: List<FarmersMarketEntity>) = upsert(
        entities = markets,
        onInsert = { insertOrIgnoreFarmersMarkets(it) },
        onUpdate = { updateFarmersMarkets(it) },
    )

    @Query("DELETE FROM farmers_markets WHERE marketName in (:marketNames)")
    suspend fun deleteFarmersMarkets(marketNames: List<String>)
}
