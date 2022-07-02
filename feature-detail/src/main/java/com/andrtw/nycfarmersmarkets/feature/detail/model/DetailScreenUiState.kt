package com.andrtw.nycfarmersmarkets.feature.detail.model

import androidx.annotation.StringRes

sealed interface DetailScreenUiState {
    object Loading : DetailScreenUiState

    data class Success(val marketDetail: UiMarketDetail) : DetailScreenUiState

    data class Error(@StringRes val errorMessage: Int) : DetailScreenUiState
}
