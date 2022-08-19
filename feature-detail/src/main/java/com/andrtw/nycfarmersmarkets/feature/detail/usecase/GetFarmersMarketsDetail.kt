package com.andrtw.nycfarmersmarkets.feature.detail.usecase

import com.andrtw.nycfarmersmarkets.core.data.repository.FarmersMarketsRepository
import com.andrtw.nycfarmersmarkets.feature.detail.mapper.toUiModel
import com.andrtw.nycfarmersmarkets.feature.detail.model.UiMarketDetail
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.map
import javax.inject.Inject

class GetFarmersMarketsDetail @Inject constructor(
    private val repository: FarmersMarketsRepository
) {
    operator fun invoke(marketName: String): Flow<UiMarketDetail?> {
        return repository
            .getFarmersMarketByName(marketName)
            .map { market -> market?.toUiModel() }
    }
}
