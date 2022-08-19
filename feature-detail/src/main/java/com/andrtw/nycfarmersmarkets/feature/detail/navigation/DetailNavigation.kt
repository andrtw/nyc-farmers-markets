package com.andrtw.nycfarmersmarkets.feature.detail.navigation

import androidx.compose.material3.windowsizeclass.WindowSizeClass
import androidx.navigation.NavGraphBuilder
import androidx.navigation.NavType
import androidx.navigation.compose.composable
import androidx.navigation.navArgument
import com.andrtw.nycfarmersmarkets.feature.detail.DetailScreen

fun NavGraphBuilder.detailGraph(
    windowSizeClass: WindowSizeClass,
    onBackClick: () -> Unit,
) {
    composable(
        route = "${DetailDestination.route}/{${DetailDestination.marketNameArg}}",
        arguments = listOf(
            navArgument(DetailDestination.marketNameArg) {
                type = NavType.StringType
            }
        )
    ) {
        val marketName = it.arguments?.getString(DetailDestination.marketNameArg) ?: ""
        DetailScreen(
            marketName = marketName,
            windowSizeClass = windowSizeClass,
            onBackClick = onBackClick,
        )
    }
}
