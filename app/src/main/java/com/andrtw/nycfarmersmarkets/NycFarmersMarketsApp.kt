package com.andrtw.nycfarmersmarkets

import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.material3.SnackbarHostState
import androidx.compose.material3.Surface
import androidx.compose.material3.windowsizeclass.WindowSizeClass
import androidx.compose.runtime.Composable
import androidx.compose.runtime.remember
import androidx.compose.runtime.rememberCoroutineScope
import androidx.compose.ui.Modifier
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.rememberNavController
import com.andrtw.nycfarmersmarkets.feature.detail.navigation.DetailDestination
import com.andrtw.nycfarmersmarkets.feature.detail.navigation.detailGraph
import com.andrtw.nycfarmersmarkets.feature.map.navigation.MapDestination
import com.andrtw.nycfarmersmarkets.feature.map.navigation.mapGraph
import com.andrtw.nycfarmersmarkets.ui.theme.NycFarmersMarketsTheme
import kotlinx.coroutines.launch

@Composable
fun NycFarmersMarketsApp(
    windowSizeClass: WindowSizeClass,
) {
    NycFarmersMarketsTheme {
        Surface(
            modifier = Modifier.fillMaxSize()
        ) {
            val snackbarHostState = remember { SnackbarHostState() }
            val navController = rememberNavController()
            val scope = rememberCoroutineScope()

            NavHost(
                navController = navController,
                startDestination = MapDestination.route
            ) {
                mapGraph(
                    snackbarHostState = snackbarHostState,
                    onPinInfoClick = { marketName ->
                        scope.launch {
                            navController.navigate(DetailDestination.route(marketName))
                        }
                    }
                )
                detailGraph(
                    windowSizeClass = windowSizeClass,
                    onBackClick = navController::popBackStack
                )
            }
        }
    }

}
