package com.andrtw.nycfarmersmarkets.core.testing.fake

import com.andrtw.nycfarmersmarkets.core.model.FarmersMarket

fun fakeFarmersMarket(
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
