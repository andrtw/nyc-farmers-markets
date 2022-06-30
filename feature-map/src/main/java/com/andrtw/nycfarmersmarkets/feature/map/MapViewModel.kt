package com.andrtw.nycfarmersmarkets.feature.map

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.andrtw.nycfarmersmarkets.core.data.repository.FarmersMarketsRepository
import com.andrtw.nycfarmersmarkets.core.model.FarmersMarket
import com.andrtw.nycfarmersmarkets.feature.map.mapper.toUiModel
import com.andrtw.nycfarmersmarkets.feature.map.model.MapScreenUiState
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.Job
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.asStateFlow
import kotlinx.coroutines.flow.map
import kotlinx.coroutines.flow.update
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class MapViewModel @Inject constructor(
    private val farmersMarketsRepository: FarmersMarketsRepository,
) : ViewModel() {

    private val _uiState = MutableStateFlow(MapScreenUiState())
    val uiState = _uiState.asStateFlow()

    private var refreshJob: Job? = null

    init {
        viewModelScope.launch {
            farmersMarketsRepository.getFarmersMarkets()
                .map { markets ->
                    markets.map(FarmersMarket::toUiModel)
                }
                .collect { markets ->
                    _uiState.update { it.copy(pins = markets) }
                }
        }

        refreshFarmersMarkets()
    }

    fun refreshFarmersMarkets() {
        refreshJob?.cancel()
        refreshJob = viewModelScope.launch {
            try {
                _uiState.update { it.copy(isLoading = true) }
                farmersMarketsRepository.updateFarmersMarkets()
            } catch (e: Exception) {
                _uiState.update { it.copy(errorMessage = R.string.refresh_error) }
            } finally {
                _uiState.update { it.copy(isLoading = false) }
            }
        }
    }

    fun errorMessageShown() {
        _uiState.update { it.copy(errorMessage = null) }
    }
}
