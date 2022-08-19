package com.andrtw.nycfarmersmarkets.feature.map

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.andrtw.nycfarmersmarkets.core.data.repository.FarmersMarketsRepository
import com.andrtw.nycfarmersmarkets.core.model.FarmersMarket
import com.andrtw.nycfarmersmarkets.feature.map.mapper.toUiModel
import com.andrtw.nycfarmersmarkets.feature.map.model.MapScreenUiState
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.Job
import kotlinx.coroutines.flow.*
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class MapViewModel @Inject constructor(
    private val farmersMarketsRepository: FarmersMarketsRepository,
) : ViewModel() {

    private var refreshJob: Job? = null

    private val _loadingState: MutableStateFlow<Boolean> = MutableStateFlow(false)

    private val _errorMessageState: MutableStateFlow<Int?> = MutableStateFlow(null)

    val uiState: StateFlow<MapScreenUiState> = combine(
        farmersMarketsRepository.getFarmersMarkets(),
        _loadingState,
        _errorMessageState,
    ) { markets, isLoading, errorMessage ->
        MapScreenUiState(
            pins = markets.map(FarmersMarket::toUiModel),
            isLoading = isLoading,
            errorMessage = errorMessage,
        )
    }
        .stateIn(
            scope = viewModelScope,
            started = SharingStarted.WhileSubscribed(5_000),
            initialValue = MapScreenUiState()
        )

    init {
        refreshFarmersMarkets()
    }

    fun refreshFarmersMarkets() {
        refreshJob?.cancel()
        refreshJob = viewModelScope.launch {
            try {
                _loadingState.value = true
                farmersMarketsRepository.updateFarmersMarkets()
            } catch (e: Exception) {
                _errorMessageState.value = R.string.refresh_error
            } finally {
                _loadingState.value = false
            }
        }
    }

    fun errorMessageShown() {
        _errorMessageState.value = null
    }
}
