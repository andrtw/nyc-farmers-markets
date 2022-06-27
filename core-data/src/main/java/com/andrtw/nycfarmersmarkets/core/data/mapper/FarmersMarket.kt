package com.andrtw.nycfarmersmarkets.core.data.mapper

import com.andrtw.nycfarmersmarkets.core.model.FarmersMarket
import com.andrtw.nycfarmersmarkets.core.network.model.NetworkFarmersMarket

fun NetworkFarmersMarket.toDomainModel() = FarmersMarket(
    borough = borough,
    marketName = marketName,
    streetAddress = streetAddress,
    communityDistrict = communityDistrict,
    latitude = latitude,
    longitude = longitude,
    daysOperation = daysOperation,
    hoursOperations = hoursOperations,
    seasonDates = seasonDates,
    acceptsEbt = acceptsEbt,
    openYearRound = openYearRound,
    nycDeptOfHealthCooking = nycDeptOfHealthCooking,
    kids = kids,
)
