package com.andrtw.nycfarmersmarkets.feature.map.navigation

import androidx.compose.foundation.layout.Box
import androidx.compose.material3.SnackbarHostState
import androidx.navigation.NavGraphBuilder
import androidx.navigation.compose.composable
import com.andrtw.nycfarmersmarkets.feature.map.MapScreen

fun NavGraphBuilder.mapGraph(
    snackbarHostState: SnackbarHostState,
    onPinInfoClick: (String) -> Unit,
) {
    composable(route = MapDestination.route) {
        Box {
            MapScreen(
                snackbarHostState = snackbarHostState,
                onPinInfoClick = onPinInfoClick,
            )
        }
    }
}
