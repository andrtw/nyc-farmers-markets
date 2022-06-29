package com.andrtw.nycfarmersmarkets.core.model

data class FarmersMarket(
    val marketName: String,
    val borough: String?,
    val streetAddress: String?,
    val communityDistrict: String?,
    val latitude: Double,
    val longitude: Double,
    val daysOperation: String?,
    val hoursOperations: String?,
    val seasonDates: String?,
    val acceptsEbt: Boolean,
    val openYearRound: Boolean,
    val nycDeptOfHealthCooking: Boolean,
    val kids: Boolean,
)
