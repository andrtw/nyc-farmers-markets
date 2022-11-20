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
import androidx.compose.material.icons.filled.PinDrop
import androidx.compose.material3.*
import androidx.compose.material3.windowsizeclass.WindowSizeClass
import androidx.compose.material3.windowsizeclass.WindowWidthSizeClass
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.runtime.getValue
import androidx.compose.runtime.remember
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.Dp
import androidx.compose.ui.unit.dp
import androidx.hilt.navigation.compose.hiltViewModel
import androidx.lifecycle.compose.ExperimentalLifecycleComposeApi
import androidx.lifecycle.compose.collectAsStateWithLifecycle
import com.andrtw.nycfarmersmarkets.feature.detail.model.DetailScreenUiState
import com.andrtw.nycfarmersmarkets.feature.detail.model.UiMarketDetail
import com.andrtw.nycfarmersmarkets.feature.detail.model.UiMarketFeature
import com.andrtw.nycfarmersmarkets.feature.detail.util.DottedShape
import com.google.accompanist.flowlayout.FlowRow
import kotlin.math.floor

@OptIn(ExperimentalLifecycleComposeApi::class)
@Composable
fun DetailScreen(
    viewModel: DetailViewModel = hiltViewModel(),
    marketName: String,
    windowSizeClass: WindowSizeClass,
    onBackClick: () -> Unit,
) {
    val state by viewModel.uiState.collectAsStateWithLifecycle()

    LaunchedEffect(key1 = marketName) {
        viewModel.loadDetail(marketName)
    }

    DetailScreen(
        state = state,
        onBackClick = onBackClick,
        windowSizeClass = windowSizeClass,
    )
}

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun DetailScreen(
    state: DetailScreenUiState,
    onBackClick: () -> Unit,
    windowSizeClass: WindowSizeClass,
) {
    Scaffold(
        topBar = {
            TopAppBar(
                title = if (state is DetailScreenUiState.Success) state.marketDetail.marketName else "",
                onCloseClick = onBackClick
            )
        }
    ) { padding ->
        Box(modifier = Modifier.padding(padding)) {
            when (state) {
                DetailScreenUiState.Loading -> LoadingIndicator()
                is DetailScreenUiState.Error -> ErrorMessage(text = stringResource(id = state.errorMessage))
                is DetailScreenUiState.Success -> MarketDetail(
                    detail = state.marketDetail,
                    windowSizeClass = windowSizeClass
                )
            }
        }
    }
}

@Composable
fun TopAppBar(
    modifier: Modifier = Modifier,
    title: String,
    onCloseClick: () -> Unit,
) {
    SmallTopAppBar(
        modifier = modifier,
        title = { Text(title, fontWeight = FontWeight.Bold) },
        navigationIcon = {
            IconButton(onClick = onCloseClick) {
                Icon(
                    Icons.Default.Close,
                    contentDescription = stringResource(id = R.string.close_content_description)
                )
            }
        }
    )
}

@Composable
fun LoadingIndicator(modifier: Modifier = Modifier) {
    Box(
        modifier = modifier.fillMaxSize(),
        contentAlignment = Alignment.Center,
    ) {
        CircularProgressIndicator()
    }
}

@Composable
fun MarketDetail(
    windowSizeClass: WindowSizeClass,
    detail: UiMarketDetail,
    modifier: Modifier = Modifier,
) {
    val scrollState = rememberScrollState()

    Column(
        modifier = modifier
            .fillMaxSize()
            .padding(16.dp)
            .verticalScroll(scrollState),
    ) {
        detail.fullAddress?.let {
            MarketAddress(address = it)
        }

        Spacer(modifier = Modifier.height(8.dp))

        detail.daysOperation?.let {
            MarketSection(
                modifier = Modifier.padding(top = 16.dp),
                sectionName = stringResource(id = R.string.market_section_days_of_operation)
            ) {
                Text(it)
            }
        }
        detail.hoursOperations?.let {
            MarketSection(
                modifier = Modifier.padding(top = 16.dp),
                sectionName = stringResource(id = R.string.market_section_hours_of_operation)
            ) {
                Text(it)
            }
        }
        detail.seasonDates?.let {
            MarketSection(
                modifier = Modifier.padding(top = 16.dp),
                sectionName = stringResource(id = R.string.market_section_season_dates)
            ) {
                Text(it)
            }
        }

        MarketSection(
            modifier = Modifier.padding(top = 16.dp),
            sectionName = stringResource(id = R.string.market_section_features)
        ) {
            BoxWithConstraints {
                FeaturesGrid(
                    columnsCount = rememberColumns(maxWidth, windowSizeClass),
                    width = maxWidth,
                    features = detail.features,
                )
            }
        }

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
fun MarketAddress(
    address: String,
    modifier: Modifier = Modifier,
) {
    Row(modifier = modifier) {
        Icon(
            Icons.Default.PinDrop,
            tint = MaterialTheme.colorScheme.primary,
            contentDescription = null, // decorative image
        )
        Spacer(modifier = Modifier.width(8.dp))
        Text(text = address)
    }
}

@Composable
fun ErrorMessage(
    text: String,
    modifier: Modifier = Modifier,
) {
    Text(
        modifier = modifier,
        text = text,
        color = MaterialTheme.colorScheme.error
    )
}

@Composable
fun MarketSection(
    sectionName: String,
    modifier: Modifier = Modifier,
    content: @Composable () -> Unit,
) {
    Column(modifier = modifier) {
        Text(
            text = sectionName,
            color = MaterialTheme.colorScheme.primary,
            style = MaterialTheme.typography.titleMedium,
        )
        content()
    }
}

@Composable
fun FeaturesGrid(
    columnsCount: Int,
    width: Dp,
    features: List<UiMarketFeature>,
    modifier: Modifier = Modifier,
) {
    val mainAxisSpacing = 16.dp
    val featureWidth = (width / columnsCount) - mainAxisSpacing
    FlowRow(
        modifier = modifier,
        mainAxisSpacing = mainAxisSpacing,
    ) {
        for (feature in features) {
            MarketFeature(
                featureName = stringResource(id = feature.featureName),
                hasFeature = feature.hasFeature,
                modifier = Modifier.width(featureWidth)
            )
        }
    }
}

@Composable
fun MarketFeature(
    featureName: String,
    hasFeature: Boolean,
    modifier: Modifier = Modifier,
) {
    Row(
        modifier = modifier,
        verticalAlignment = Alignment.CenterVertically
    ) {
        Text(text = featureName)
        Box(
            Modifier
                .weight(1f)
                .height(1.dp)
                .padding(start = 4.dp)
                .background(Color.Gray, shape = DottedShape(step = 6.dp))
        )
        if (hasFeature) {
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

@Composable
fun rememberColumns(
    width: Dp,
    windowSizeClass: WindowSizeClass,
) = remember(windowSizeClass) {
    when (windowSizeClass.widthSizeClass) {
        WindowWidthSizeClass.Compact -> 1
        else -> floor(width / 300.dp).toInt().coerceIn(1..3)
    }
}
