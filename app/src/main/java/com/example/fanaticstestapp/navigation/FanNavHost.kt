package com.example.fanaticstestapp.navigation

import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.navigation.NavType
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import androidx.navigation.navArgument
import com.example.fanaticstestapp.ui.screens.details.FanCharacterScreen
import com.example.fanaticstestapp.ui.screens.home.FanHomeScreen

enum class FanNavRoutes { LIST, DETAILS }

const val CHARACTER_ID = "CHARACTER_ID"

@Composable
fun FanNavHost(
    modifier: Modifier = Modifier,
) {
    val navController = rememberNavController()
    NavHost(
        navController = navController,
        startDestination = FanNavRoutes.LIST.name,
        modifier = modifier
    ) {
        composable(
            route = FanNavRoutes.LIST.name,
        ) {
            FanHomeScreen(
                { characterModel ->
                    navController.navigate("${FanNavRoutes.DETAILS.name}/${characterModel.id}")
                },
            )
        }

        composable(
            route = "${FanNavRoutes.DETAILS.name}/{$CHARACTER_ID}",
            arguments = listOf(
                navArgument(CHARACTER_ID) {
                    type = NavType.StringType
                },
            ),
        ) {
            FanCharacterScreen(onNavigateBack = navController::navigateUp )
        }
    }
}