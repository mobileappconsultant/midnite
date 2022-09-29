package com.android.midnite.ui.navigation

sealed class Routes(val route: String) {

    object MainScreen : Routes("mainScreen")
    object DetailsScreen : Routes("detailsScreen?id={id}") {
        fun createRoute(id: Int) = "detailsScreen?id=$id"
    }
}
