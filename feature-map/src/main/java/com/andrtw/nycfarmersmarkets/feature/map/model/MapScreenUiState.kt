package com.andrtw.nycfarmersmarkets.feature.map.model

import androidx.annotation.StringRes

data class MapScreenUiState(
    val pins: List<UiFarmersMarket> = emptyList(),
    val isLoading: Boolean = false,
    @StringRes val errorMessage: Int? = null,
)
