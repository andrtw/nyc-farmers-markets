package com.andrtw.nycfarmersmarkets.feature.map.fake

import com.andrtw.nycfarmersmarkets.core.model.FarmersMarket
import com.andrtw.nycfarmersmarkets.feature.map.model.UiFarmersMarket

internal fun fakeFarmersMarket(
    name: String = "Test Market",
) = FarmersMarket(
    marketName = name,
    borough = "Manhattan",
    streetAddress = "W. Test Avenue",
    communityDistrict = "123",
    latitude = 0.0,
    longitude = 0.0,
    daysOperation = "Mon-Fri",
    hoursOperations = "8am-6pm",
    seasonDates = "Mar-Sep",
    acceptsEbt = false,
    openYearRound = false,
    nycDeptOfHealthCooking = false,
    kids = false,
)

internal fun fakeUiFarmersMarket(marketName: String) = UiFarmersMarket(
    marketName = marketName,
    latitude = 0.0,
    longitude = 0.0,
)
