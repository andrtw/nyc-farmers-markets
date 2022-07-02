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

internal val localFarmersMarket1 = fakeFarmersMarket("Local Market 1")
internal val localFarmersMarket2 = fakeFarmersMarket("Local Market 2")
internal val localFarmersMarket3 = fakeFarmersMarket("Local Market 3")

internal val remoteFarmersMarket1 = fakeFarmersMarket("Remote Market 1")
internal val remoteFarmersMarket2 = fakeFarmersMarket("Remote Market 2")

internal val localMarkets = listOf(
    localFarmersMarket1,
    localFarmersMarket2,
    localFarmersMarket3,
)

internal val remoteMarkets = listOf(
    remoteFarmersMarket1,
    remoteFarmersMarket2,
)

internal val allMarkets = localMarkets + remoteMarkets
