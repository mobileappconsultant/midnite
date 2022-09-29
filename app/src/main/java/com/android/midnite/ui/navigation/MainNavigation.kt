package com.android.midnite.ui.navigation

import androidx.compose.runtime.Composable
import androidx.compose.runtime.collectAsState
import androidx.compose.runtime.getValue
import androidx.compose.ui.ExperimentalComposeUiApi
import androidx.hilt.navigation.compose.hiltViewModel
import androidx.navigation.NavType
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import androidx.navigation.navArgument
import androidx.paging.compose.collectAsLazyPagingItems
import com.android.midnite.ui.screens.details.DetailsScreen
import com.android.midnite.ui.screens.main.MainScreen
import com.android.midnite.ui.viewmodel.DetailsViewModel
import com.android.midnite.ui.viewmodel.MainViewModel

@ExperimentalComposeUiApi
@Composable
fun MainNavigation() {
    val navController = rememberNavController()
    NavHost(navController, startDestination = Routes.MainScreen.route) {

        composable(route = Routes.MainScreen.route) {
            val mainViewModel: MainViewModel = hiltViewModel()
            val data = mainViewModel.pagingData.collectAsLazyPagingItems()
            MainScreen(
                data,
                {
                    mainViewModel.getUpcomingMatches()
                }
            ) {
                navController.navigate(Routes.DetailsScreen.createRoute(it.id))
            }
        }

        composable(
            route = Routes.DetailsScreen.route,
            arguments = listOf(
                navArgument("id") {
                    type = NavType.IntType
                }
            )
        ) {
            it.arguments?.getInt("id")?.let { id ->
                val detailsViewModel: DetailsViewModel = hiltViewModel()
                detailsViewModel.getMatchDetailsById(id)
                val data by detailsViewModel.state.collectAsState()
                DetailsScreen(
                    state = data,
                    onRetry = { detailsViewModel.getMatchDetailsById(id) }
                ) {
                    navController.popBackStack()
                }
            }
        }
    }
}
