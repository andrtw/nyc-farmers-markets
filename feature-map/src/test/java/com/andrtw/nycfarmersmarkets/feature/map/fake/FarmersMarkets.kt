package com.andrtw.nycfarmersmarkets.feature.map.fake

import com.andrtw.nycfarmersmarkets.feature.map.model.UiFarmersMarket

internal fun fakeUiFarmersMarket(marketName: String) = UiFarmersMarket(
    marketName = marketName,
    streetAddress = "",
    latitude = 0.0,
    longitude = 0.0,
)
