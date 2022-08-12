package com.andrtw.nycfarmersmarkets.feature.map.fake

import com.andrtw.nycfarmersmarkets.feature.map.model.UiFarmersMarket

internal fun fakeUiFarmersMarket(marketName: String) = UiFarmersMarket(
    marketName = marketName,
    streetAddress = "W. Test Avenue",
    latitude = 0.0,
    longitude = 0.0,
)
