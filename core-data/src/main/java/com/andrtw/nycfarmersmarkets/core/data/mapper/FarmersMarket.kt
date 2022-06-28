package com.andrtw.nycfarmersmarkets.core.data.mapper

import com.andrtw.nycfarmersmarkets.core.database.entity.FarmersMarketEntity
import com.andrtw.nycfarmersmarkets.core.model.FarmersMarket
import com.andrtw.nycfarmersmarkets.core.network.model.NetworkFarmersMarket

fun NetworkFarmersMarket.toDomainModel() = FarmersMarket(
    marketName = marketName,
    borough = borough,
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

fun FarmersMarketEntity.toDomainModel() = FarmersMarket(
    marketName = marketName,
    borough = borough,
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
    kids = kids
)

fun FarmersMarket.toEntityModel() = FarmersMarketEntity(
    marketName = marketName,
    borough = borough,
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
    kids = kids
)
