package com.andrtw.nycfarmersmarkets.feature.map

import com.andrtw.nycfarmersmarkets.core.data.testing.FakeFarmersMarketsRepository
import com.andrtw.nycfarmersmarkets.core.testing.MainDispatcherRule
import com.andrtw.nycfarmersmarkets.feature.map.fake.fakeUiFarmersMarket
import com.andrtw.nycfarmersmarkets.feature.map.model.MapScreenUiState
import com.google.common.truth.Truth.assertThat
import kotlinx.coroutines.flow.collect
import kotlinx.coroutines.launch
import kotlinx.coroutines.test.UnconfinedTestDispatcher
import kotlinx.coroutines.test.runTest
import org.junit.Before
import org.junit.Rule
import org.junit.Test

class MapViewModelTest {

    @get:Rule
    val dispatcherRule = MainDispatcherRule()

    private lateinit var repository: FakeFarmersMarketsRepository
    private lateinit var viewModel: MapViewModel

    @Before
    fun setUp() {
        repository = FakeFarmersMarketsRepository()
        viewModel = MapViewModel(repository)
    }

    @Test
    fun `markets are refreshed initially`() = runTest {
        val collectJob = launch(UnconfinedTestDispatcher()) { viewModel.uiState.collect() }

        assertThat(viewModel.uiState.value).isEqualTo(
            MapScreenUiState(
                pins = listOf(
                    fakeUiFarmersMarket("Test Farmers Market 1"),
                    fakeUiFarmersMarket("Test Farmers Market 2"),
                    fakeUiFarmersMarket("New Farmers Market 1"),
                ),
                isLoading = false,
                errorMessage = null,
            )
        )

        collectJob.cancel()
    }

    @Test
    fun `markets are updated, one market is added`() = runTest {
        val collectJob = launch(UnconfinedTestDispatcher()) { viewModel.uiState.collect() }

        viewModel.refreshFarmersMarkets()

        assertThat(viewModel.uiState.value).isEqualTo(
            MapScreenUiState(
                pins = listOf(
                    fakeUiFarmersMarket("Test Farmers Market 1"),
                    fakeUiFarmersMarket("Test Farmers Market 2"),
                    fakeUiFarmersMarket("New Farmers Market 1"),
                    fakeUiFarmersMarket("New Farmers Market 2"),
                ),
                isLoading = false,
                errorMessage = null,
            )
        )

        collectJob.cancel()
    }

    @Test
    fun `thrown exception results in error message`() = runTest {
        val collectJob = launch(UnconfinedTestDispatcher()) { viewModel.uiState.collect() }

        repository.failUpdate = true

        viewModel.refreshFarmersMarkets()

        assertThat(viewModel.uiState.value).isEqualTo(
            MapScreenUiState(
                pins = listOf(
                    fakeUiFarmersMarket("Test Farmers Market 1"),
                    fakeUiFarmersMarket("Test Farmers Market 2"),
                    fakeUiFarmersMarket("New Farmers Market 1"),
                ),
                isLoading = false,
                errorMessage = R.string.refresh_error,
            )
        )

        collectJob.cancel()
    }

    @Test
    fun `error message is cleared`() {
        repository.failUpdate = true

        viewModel.refreshFarmersMarkets()
        viewModel.errorMessageShown()

        assertThat(viewModel.uiState.value.errorMessage).isNull()
    }
}
