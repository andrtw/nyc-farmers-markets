package com.andrtw.nycfarmersmarkets.core.database.di

import android.content.Context
import androidx.room.Room
import com.andrtw.nycfarmersmarkets.core.database.NycFarmersMarketsDatabase
import com.andrtw.nycfarmersmarkets.core.database.dao.FarmersMarketsDao
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.android.qualifiers.ApplicationContext
import dagger.hilt.components.SingletonComponent
import javax.inject.Singleton

@Module
@InstallIn(SingletonComponent::class)
object DatabaseModule {

    @Provides
    @Singleton
    fun provideNycFarmersMarketDatabase(@ApplicationContext context: Context): NycFarmersMarketsDatabase {
        return Room.databaseBuilder(
            context,
            NycFarmersMarketsDatabase::class.java,
            "nyc-farmers-markets"
        ).build()
    }

    @Provides
    @Singleton
    fun provideFarmersMarketsDao(database: NycFarmersMarketsDatabase): FarmersMarketsDao {
        return database.farmersMarketsDao()
    }
}
