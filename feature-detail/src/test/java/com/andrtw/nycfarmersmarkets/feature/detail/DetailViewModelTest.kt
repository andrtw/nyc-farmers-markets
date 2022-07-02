package com.andrtw.nycfarmersmarkets.feature.detail

import com.andrtw.nycfarmersmarkets.core.data.testing.FakeFarmersMarketsRepository
import com.andrtw.nycfarmersmarkets.core.testing.MainDispatcherRule
import com.andrtw.nycfarmersmarkets.feature.detail.model.DetailScreenUiState
import com.andrtw.nycfarmersmarkets.feature.detail.model.UiMarketDetail
import com.google.common.truth.Truth.assertThat
import kotlinx.coroutines.ExperimentalCoroutinesApi
import org.junit.Before
import org.junit.Rule
import org.junit.Test

@ExperimentalCoroutinesApi
class DetailViewModelTest {

    @get:Rule
    val dispatcherRule = MainDispatcherRule()

    private lateinit var repository: FakeFarmersMarketsRepository
    private lateinit var viewModel: DetailViewModel

    @Before
    fun setUp() {
        repository = FakeFarmersMarketsRepository()
        viewModel = DetailViewModel(repository)
    }

    @Test
    fun `state is initially loading`() {
        assertThat(
            viewModel.uiState.value
        ).isEqualTo(
            DetailScreenUiState.Loading
        )
    }

    @Test
    fun `loading unknown market shows error`() {
        viewModel.loadDetail("Android Market")
        assertThat(
            viewModel.uiState.value
        ).isEqualTo(
            DetailScreenUiState.Error(R.string.error_unknown_market)
        )
    }

    @Test
    fun `loading a market shows market details`() {
        viewModel.loadDetail("Test Farmers Market 1")
        assertThat(
            viewModel.uiState.value
        ).isEqualTo(
            DetailScreenUiState.Success(
                marketDetail = UiMarketDetail(
                    latitude = 0.0,
                    longitude = 0.0,
                    marketName = "Test Farmers Market 1",
                    streetAddress = "W. Test Avenue",
                    borough = "Manhattan",
                    daysOperation = "Mon-Fri",
                    hoursOperations = "8am-6pm",
                    seasonDates = "Mar-Sep",
                    acceptsEbt = false,
                    openYearRound = false,
                    nycDeptOfHealthCooking = false,
                    kids = false
                )
            )
        )
    }
}
