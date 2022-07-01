package com.andrtw.nycfarmersmarkets.feature.map

import androidx.compose.foundation.background
import androidx.compose.foundation.border
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Info
import androidx.compose.material.icons.filled.Refresh
import androidx.compose.material3.*
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.runtime.collectAsState
import androidx.compose.runtime.getValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.platform.testTag
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.hilt.navigation.compose.hiltViewModel
import com.andrtw.nycfarmersmarkets.feature.map.model.MapScreenUiState
import com.andrtw.nycfarmersmarkets.feature.map.model.UiFarmersMarket
import com.andrtw.nycfarmersmarkets.feature.map.util.TestTags
import com.google.android.gms.maps.model.CameraPosition
import com.google.android.gms.maps.model.LatLng
import com.google.android.gms.maps.model.Marker
import com.google.maps.android.compose.GoogleMap
import com.google.maps.android.compose.MarkerInfoWindowContent
import com.google.maps.android.compose.MarkerState
import com.google.maps.android.compose.rememberCameraPositionState

@ExperimentalMaterial3Api
@Composable
fun MapScreen(
    viewModel: MapViewModel = hiltViewModel(),
    snackbarHostState: SnackbarHostState,
    onPinInfoClick: (String) -> Unit,
) {
    val state by viewModel.uiState.collectAsState()

    MapScreen(
        state = state,
        snackbarHostState = snackbarHostState,
        onPinInfoClick = { onPinInfoClick(it.marketName) },
        onRefreshMarketsClick = viewModel::refreshFarmersMarkets,
        onErrorShown = viewModel::errorMessageShown
    )
}

@ExperimentalMaterial3Api
@Composable
fun MapScreen(
    state: MapScreenUiState,
    snackbarHostState: SnackbarHostState,
    onPinInfoClick: (UiFarmersMarket) -> Unit,
    onRefreshMarketsClick: () -> Unit,
    onErrorShown: () -> Unit,
) {
    Scaffold(
        snackbarHost = { SnackbarHost(snackbarHostState) },
    ) { padding ->
        if (state.errorMessage != null) {
            val message = stringResource(id = state.errorMessage)
            LaunchedEffect(state.errorMessage) {
                snackbarHostState.showSnackbar(message)
                onErrorShown()
            }
        }
        Box {
            GoogleMap(
                pins = state.pins,
                onPinInfoClick = onPinInfoClick,
                modifier = Modifier
                    .fillMaxSize()
                    .padding(padding),
            )
            Box(
                modifier = Modifier
                    .fillMaxWidth()
                    .padding(12.dp),
                contentAlignment = Alignment.CenterEnd,
            ) {
                RefreshButton(
                    onClick = onRefreshMarketsClick,
                    isLoading = state.isLoading,
                )
            }
        }
    }
}

@Composable
fun RefreshButton(
    modifier: Modifier = Modifier,
    onClick: () -> Unit,
    isLoading: Boolean,
) {
    val shape = RoundedCornerShape(2.dp)

    Box(
        modifier = modifier
            .size(42.dp)
            .border(
                width = 1.dp,
                shape = shape,
                color = Color.Black.copy(alpha = 0.1f)
            )
            .clip(shape)
            .background(Color.White.copy(alpha = 0.75f))
            .clickable(enabled = !isLoading, onClick = onClick),
        contentAlignment = Alignment.Center,
    ) {
        if (isLoading) {
            CircularProgressIndicator(
                modifier = Modifier
                    .size(24.dp)
                    .testTag(TestTags.ProgressIndicatorTag),
                strokeWidth = 2.dp,
            )
        } else {
            Icon(
                Icons.Default.Refresh,
                contentDescription = stringResource(id = R.string.refresh_content_description),
                tint = Color.Black.copy(alpha = 0.5f),
                modifier = Modifier.size(28.dp)
            )
        }
    }
}

@Composable
fun GoogleMap(
    modifier: Modifier = Modifier,
    pins: List<UiFarmersMarket>,
    onPinInfoClick: (UiFarmersMarket) -> Unit,
) {
    val cameraPositionState = rememberCameraPositionState {
        position = CameraPosition.fromLatLngZoom(NEW_YORK, ZOOM_LEVEL)
    }

    GoogleMap(
        modifier = modifier.fillMaxSize(),
        cameraPositionState = cameraPositionState,
    ) {
        for (pin in pins) {
            val position = LatLng(pin.latitude, pin.longitude)
            MarkerInfoWindowContent(
                state = MarkerState(position),
                title = pin.marketName,
                snippet = pin.streetAddress,
                onInfoWindowClick = { onPinInfoClick(pin) },
            ) { marker ->
                InfoWindowContent(marker = marker)
            }
        }
    }
}

@Composable
fun InfoWindowContent(
    marker: Marker,
    modifier: Modifier = Modifier,
) {
    Row(
        modifier = modifier,
        verticalAlignment = Alignment.CenterVertically
    ) {
        Column(horizontalAlignment = Alignment.CenterHorizontally) {
            marker.title?.let {
                Text(
                    it,
                    style = MaterialTheme.typography.bodyMedium,
                    fontWeight = FontWeight.Bold
                )
            }
            marker.snippet?.let {
                Text(it, style = MaterialTheme.typography.bodySmall)
            }
        }
        Spacer(modifier = Modifier.width(8.dp))
        Icon(
            Icons.Default.Info,
            contentDescription = stringResource(id = R.string.market_info_content_description),
        )
    }
}

private val NEW_YORK = LatLng(40.732971, -73.9407838)
private const val ZOOM_LEVEL = 11f
