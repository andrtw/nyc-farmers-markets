package com.andrtw.nycfarmersmarkets.core.model

data class Market(
    val borough: String?,
    val marketName: String?,
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
