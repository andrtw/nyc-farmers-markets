package com.andrtw.nycfarmersmarkets.core.database

import androidx.room.Database
import androidx.room.RoomDatabase
import com.andrtw.nycfarmersmarkets.core.database.dao.FarmersMarketsDao
import com.andrtw.nycfarmersmarkets.core.database.entity.FarmersMarketEntity

@Database(
    entities = [
        FarmersMarketEntity::class,
    ],
    version = 1,
)
abstract class NycFarmersMarketsDatabase : RoomDatabase() {

    abstract fun farmersMarketsDao(): FarmersMarketsDao
}
