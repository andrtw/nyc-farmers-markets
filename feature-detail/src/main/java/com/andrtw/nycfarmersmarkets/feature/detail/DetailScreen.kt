package com.andrtw.nycfarmersmarkets.feature.detail

import android.content.Intent
import android.net.Uri
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.verticalScroll
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Check
import androidx.compose.material.icons.filled.Close
import androidx.compose.material.icons.filled.Directions
import androidx.compose.material3.*
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.runtime.collectAsState
import androidx.compose.runtime.getValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.hilt.navigation.compose.hiltViewModel
import com.andrtw.nycfarmersmarkets.feature.detail.model.DetailScreenUiState
import com.andrtw.nycfarmersmarkets.feature.detail.model.UiMarketDetail
import com.andrtw.nycfarmersmarkets.feature.detail.util.DottedShape

@Composable
fun DetailScreen(
    viewModel: DetailViewModel = hiltViewModel(),
    marketName: String,
) {
    val state by viewModel.uiState.collectAsState()

    LaunchedEffect(key1 = marketName) {
        viewModel.loadDetail(marketName)
    }

    DetailScreen(state = state)
}

@Composable
fun DetailScreen(
    state: DetailScreenUiState,
) {
    when (state) {
        DetailScreenUiState.Loading -> LoadingIndicator()
        is DetailScreenUiState.Error -> ErrorMessage(text = stringResource(id = state.errorMessage))
        is DetailScreenUiState.Success -> MarketDetail(detail = state.marketDetail)
    }
}

@Composable
fun LoadingIndicator(modifier: Modifier = Modifier) {
    Box(
        modifier = modifier,
        contentAlignment = Alignment.Center,
    ) {
        CircularProgressIndicator()
    }
}

@Composable
fun MarketDetail(
    detail: UiMarketDetail,
) {
    val scrollState = rememberScrollState()

    Column(
        modifier = Modifier
            .fillMaxSize()
            .padding(16.dp)
            .verticalScroll(scrollState),
    ) {
        Text(
            detail.marketName,
            style = MaterialTheme.typography.titleLarge,
            fontWeight = FontWeight.Bold
        )

        val address = buildString {
            detail.streetAddress?.let { append(it) }
            detail.borough?.let { append(", $it") }
        }
        if (address.isNotEmpty()) {
            Text(text = address)
        }

        Spacer(modifier = Modifier.height(8.dp))

        detail.daysOperation?.let {
            Spacer(modifier = Modifier.height(8.dp))
            MarketSection(
                sectionName = "Days of operation",
                sectionText = it,
            )
        }
        detail.hoursOperations?.let {
            Spacer(modifier = Modifier.height(8.dp))
            MarketSection(
                sectionName = "Hours of operation",
                sectionText = it,
            )
        }
        detail.seasonDates?.let {
            Spacer(modifier = Modifier.height(8.dp))
            MarketSection(
                sectionName = "Season dates",
                sectionText = it,
            )
        }

        Spacer(modifier = Modifier.height(16.dp))

        MarketHasFeature(
            name = stringResource(id = R.string.market_feature_accepts_ebt),
            available = detail.acceptsEbt
        )
        MarketHasFeature(
            name = stringResource(id = R.string.market_feature_open_year_round),
            available = detail.openYearRound
        )
        MarketHasFeature(
            name = stringResource(id = R.string.market_feature_nyc_dept_of_health_cooking),
            available = detail.nycDeptOfHealthCooking
        )
        MarketHasFeature(
            name = stringResource(id = R.string.market_feature_kids),
            available = detail.kids
        )

        Spacer(modifier = Modifier.height(16.dp))

        GoogleMapsButton(
            marketName = detail.marketName,
            latitude = detail.latitude,
            longitude = detail.longitude,
            modifier = Modifier.fillMaxWidth(),
        )
    }
}

@Composable
fun ErrorMessage(text: String) {
    Text(text = text)
}

@Composable
fun MarketSection(
    sectionName: String,
    sectionText: String,
    modifier: Modifier = Modifier,
) {
    Column(modifier = modifier) {
        Text(text = sectionName, style = MaterialTheme.typography.titleMedium)
        Text(text = sectionText)
    }
}

@Composable
fun MarketHasFeature(
    name: String,
    available: Boolean,
    modifier: Modifier = Modifier,
) {
    Row(
        modifier = modifier,
        verticalAlignment = Alignment.CenterVertically
    ) {
        Text(
            text = name,
        )
        Box(
            Modifier
                .weight(1f)
                .height(1.dp)
                .padding(horizontal = 4.dp)
                .background(Color.Gray, shape = DottedShape(step = 6.dp))
        )
        if (available) {
            Icon(
                Icons.Default.Check,
                tint = MaterialTheme.colorScheme.primary,
                contentDescription = stringResource(id = R.string.available_content_description),
            )
        } else {
            Icon(
                Icons.Default.Close,
                tint = MaterialTheme.colorScheme.error,
                contentDescription = stringResource(id = R.string.not_available_content_description)
            )
        }
    }
}

@Composable
fun GoogleMapsButton(
    marketName: String,
    latitude: Double,
    longitude: Double,
    modifier: Modifier = Modifier,
) {
    val context = LocalContext.current

    Button(
        modifier = modifier,
        onClick = {
            val gmmIntentUri = Uri.parse("geo:$latitude,$longitude?q=${Uri.encode(marketName)}")
            val mapIntent = Intent(Intent.ACTION_VIEW, gmmIntentUri).apply {
                setPackage("com.google.android.apps.maps")
            }
            context.startActivity(mapIntent)
        }
    ) {
        Icon(Icons.Default.Directions, contentDescription = null) // decorative image
        Spacer(modifier = Modifier.width(8.dp))
        Text(text = stringResource(R.string.google_maps_button))
    }
}
