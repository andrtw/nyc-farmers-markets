package com.andrtw.nycfarmersmarkets.feature.detail.model

import androidx.annotation.StringRes

data class UiMarketDetail(
    val latitude: Double,
    val longitude: Double,
    val marketName: String,
    val streetAddress: String?,
    val borough: String?,
    val daysOperation: String?,
    val hoursOperations: String?,
    val seasonDates: String?,
    val features: List<UiMarketFeature>,
)

data class UiMarketFeature(
    @StringRes val featureName: Int,
    val hasFeature: Boolean,
)
