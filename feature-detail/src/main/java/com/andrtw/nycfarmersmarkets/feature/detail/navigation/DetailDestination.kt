package com.andrtw.nycfarmersmarkets.feature.detail.navigation

object DetailDestination {
    const val route = "detail"
    const val marketNameArg = "marketName"

    fun route(marketName: String) = "$route/$marketName"
}
