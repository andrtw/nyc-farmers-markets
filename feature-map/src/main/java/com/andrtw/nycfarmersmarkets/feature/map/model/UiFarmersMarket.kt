package com.andrtw.nycfarmersmarkets.feature.map.model

data class UiFarmersMarket(
    val marketName: String,
    val streetAddress: String?,
    val latitude: Double,
    val longitude: Double,
)
