package com.andrtw.nycfarmersmarkets.core.database.fake

import com.andrtw.nycfarmersmarkets.core.database.entity.FarmersMarketEntity

internal fun fakeFarmersMarketEntity(
    name: String = "Test Market",
    daysOperation: String = "Mon-Fri",
) = FarmersMarketEntity(
    marketName = name,
    borough = "Manhattan",
    streetAddress = "W. Test Avenue",
    communityDistrict = "123",
    latitude = 0.0,
    longitude = 0.0,
    daysOperation = daysOperation,
    hoursOperations = "8am-6pm",
    seasonDates = "Mar-Sep",
    acceptsEbt = false,
    openYearRound = false,
    nycDeptOfHealthCooking = false,
    kids = false,
)
