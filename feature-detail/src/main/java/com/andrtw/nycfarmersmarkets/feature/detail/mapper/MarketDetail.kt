package com.andrtw.nycfarmersmarkets.feature.detail.mapper

import com.andrtw.nycfarmersmarkets.core.model.FarmersMarket
import com.andrtw.nycfarmersmarkets.feature.detail.model.UiMarketDetail

fun FarmersMarket.toUiModel() = UiMarketDetail(
    latitude = latitude,
    longitude = longitude,
    marketName = marketName,
    streetAddress = streetAddress,
    borough = borough,
    daysOperation = daysOperation,
    hoursOperations = hoursOperations,
    seasonDates = seasonDates,
    acceptsEbt = acceptsEbt,
    openYearRound = openYearRound,
    nycDeptOfHealthCooking = nycDeptOfHealthCooking,
    kids = kids,
)
