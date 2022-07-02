package com.andrtw.nycfarmersmarkets.core.data.fake

import com.andrtw.nycfarmersmarkets.core.testing.fake.fakeFarmersMarket

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
