package com.andrtw.nycfarmersmarkets.core.data.fake

import com.andrtw.nycfarmersmarkets.core.model.FarmersMarket

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

internal val localMarkets = listOf(
    fakeFarmersMarket("Local Market 1"),
    fakeFarmersMarket("Local Market 2"),
    fakeFarmersMarket("Local Market 3"),
)

internal val remoteMarkets = listOf(
    fakeFarmersMarket("Remote Market 1"),
    fakeFarmersMarket("Remote Market 2"),
)
