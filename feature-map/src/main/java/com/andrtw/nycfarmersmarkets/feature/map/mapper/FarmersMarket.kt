package com.andrtw.nycfarmersmarkets.feature.map.mapper

import com.andrtw.nycfarmersmarkets.core.model.FarmersMarket
import com.andrtw.nycfarmersmarkets.feature.map.model.UiFarmersMarket

fun FarmersMarket.toUiModel() = UiFarmersMarket(
    marketName = marketName,
    streetAddress = streetAddress,
    latitude = latitude,
    longitude = longitude,
)
