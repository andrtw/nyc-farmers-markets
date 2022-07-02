package com.andrtw.nycfarmersmarkets.feature.detail

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.andrtw.nycfarmersmarkets.core.data.repository.FarmersMarketsRepository
import com.andrtw.nycfarmersmarkets.feature.detail.mapper.toUiModel
import com.andrtw.nycfarmersmarkets.feature.detail.model.DetailScreenUiState
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.asStateFlow
import kotlinx.coroutines.flow.map
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class DetailViewModel @Inject constructor(
    private val farmersMarketsRepository: FarmersMarketsRepository,
) : ViewModel() {

    private val _uiState = MutableStateFlow<DetailScreenUiState>(DetailScreenUiState.Loading)
    val uiState = _uiState.asStateFlow()

    fun loadDetail(marketName: String) {
        viewModelScope.launch {
            farmersMarketsRepository.getFarmersMarketByName(marketName)
                .map { market ->
                    if (market == null) {
                        DetailScreenUiState.Error(errorMessage = R.string.error_unknown_market)
                    } else {
                        DetailScreenUiState.Success(marketDetail = market.toUiModel())
                    }
                }
                .collect { state ->
                    _uiState.value = state
                }
        }
    }
}
