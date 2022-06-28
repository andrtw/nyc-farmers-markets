package com.andrtw.nycfarmersmarkets.core.database.entity

import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity(tableName = "farmers_markets")
data class FarmersMarketEntity(
    @PrimaryKey val marketName: String,
    val borough: String?,
    val streetAddress: String?,
    val communityDistrict: String?,
    val latitude: String?,
    val longitude: String?,
    val daysOperation: String?,
    val hoursOperations: String?,
    val seasonDates: String?,
    val acceptsEbt: Boolean,
    val openYearRound: Boolean,
    val nycDeptOfHealthCooking: Boolean,
    val kids: Boolean,
)
