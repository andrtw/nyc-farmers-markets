package com.andrtw.nycfarmersmarkets.feature.detail

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.andrtw.nycfarmersmarkets.feature.detail.model.DetailScreenUiState
import com.andrtw.nycfarmersmarkets.feature.detail.usecase.GetFarmersMarketsDetail
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.asStateFlow
import kotlinx.coroutines.flow.map
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class DetailViewModel @Inject constructor(
    private val getFarmersMarketsDetail: GetFarmersMarketsDetail,
) : ViewModel() {

    private val _uiState = MutableStateFlow<DetailScreenUiState>(DetailScreenUiState.Loading)
    val uiState = _uiState.asStateFlow()

    fun loadDetail(marketName: String) {
        viewModelScope.launch {
            getFarmersMarketsDetail(marketName)
                .map { detail ->
                    if (detail == null) {
                        DetailScreenUiState.Error(errorMessage = R.string.error_unknown_market)
                    } else {
                        DetailScreenUiState.Success(detail)
                    }
                }
                .collect { state ->
                    _uiState.value = state
                }
        }
    }
}
