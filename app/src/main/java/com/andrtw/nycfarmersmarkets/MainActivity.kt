package com.andrtw.nycfarmersmarkets

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.SnackbarHostState
import androidx.compose.material3.Surface
import androidx.compose.material3.windowsizeclass.ExperimentalMaterial3WindowSizeClassApi
import androidx.compose.material3.windowsizeclass.calculateWindowSizeClass
import androidx.compose.runtime.remember
import androidx.compose.runtime.rememberCoroutineScope
import androidx.compose.ui.Modifier
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.rememberNavController
import com.andrtw.nycfarmersmarkets.feature.detail.navigation.DetailDestination
import com.andrtw.nycfarmersmarkets.feature.detail.navigation.detailGraph
import com.andrtw.nycfarmersmarkets.feature.map.navigation.MapDestination
import com.andrtw.nycfarmersmarkets.feature.map.navigation.mapGraph
import com.andrtw.nycfarmersmarkets.ui.theme.NycfarmersmarketsTheme
import dagger.hilt.android.AndroidEntryPoint
import kotlinx.coroutines.launch

@ExperimentalMaterial3WindowSizeClassApi
@ExperimentalMaterial3Api
@AndroidEntryPoint
class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        setContent {
            val windowSizeClass = calculateWindowSizeClass(this)

            NycfarmersmarketsTheme {
                Surface(
                    modifier = Modifier.fillMaxSize(),
                    color = MaterialTheme.colorScheme.background
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
    }
}
