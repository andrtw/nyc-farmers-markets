package com.andrtw.nycfarmersmarkets.feature.detail.model

data class UiMarketDetail(
    val latitude: Double,
    val longitude: Double,
    val marketName: String,
    val streetAddress: String?,
    val borough: String?,
    val daysOperation: String?,
    val hoursOperations: String?,
    val seasonDates: String?,
    val acceptsEbt: Boolean,
    val openYearRound: Boolean,
    val nycDeptOfHealthCooking: Boolean,
    val kids: Boolean,
)
