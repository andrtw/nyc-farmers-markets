package com.andrtw.nycfarmersmarkets.feature.detail.mapper

import com.andrtw.nycfarmersmarkets.core.model.FarmersMarket
import com.andrtw.nycfarmersmarkets.feature.detail.R
import com.andrtw.nycfarmersmarkets.feature.detail.model.UiMarketDetail
import com.andrtw.nycfarmersmarkets.feature.detail.model.UiMarketFeature

fun FarmersMarket.toUiModel() = UiMarketDetail(
    latitude = latitude,
    longitude = longitude,
    marketName = marketName,
    fullAddress = streetAddress?.let { address ->
        buildString {
            append(address)
            borough?.let { append(", $it") }
        }
    },
    daysOperation = daysOperation,
    hoursOperations = hoursOperations,
    seasonDates = seasonDates,
    features = listOf(
        UiMarketFeature(
            featureName = R.string.market_feature_accepts_ebt,
            hasFeature = acceptsEbt,
        ),
        UiMarketFeature(
            featureName = R.string.market_feature_open_year_round,
            hasFeature = openYearRound,
        ),
        UiMarketFeature(
            featureName = R.string.market_feature_nyc_dept_of_health_cooking,
            hasFeature = nycDeptOfHealthCooking,
        ),
        UiMarketFeature(
            featureName = R.string.market_feature_kids,
            hasFeature = kids,
        ),
    ),
)
