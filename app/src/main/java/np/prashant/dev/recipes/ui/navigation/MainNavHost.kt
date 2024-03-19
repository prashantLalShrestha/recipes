package np.prashant.dev.recipes.ui.navigation

import androidx.compose.runtime.Composable
import androidx.navigation.NavHostController
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import np.prashant.dev.recipes.ui.navigation.NavigationGraph.Screen
import np.prashant.dev.recipes.ui.search.RecipeSearchScreen
import np.prashant.dev.recipes.ui.splash.SplashScreen

@Composable
internal fun MainNavHost(
    navController: NavHostController
) {
    NavHost(
        navController = navController,
        route = NavigationGraph.GRAPH_ROUTE,
        startDestination = Screen.Splash.route
    ) {
        composable(route = Screen.Splash.route) { SplashScreen() }
        composable(route = Screen.RecipeSearch.route) { RecipeSearchScreen() }
    }
}