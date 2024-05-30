package np.prashant.dev.recipes.ui.navigation

import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.navigation.NavHostController
import np.prashant.dev.recipes.ui.favourites.FavouritesListScreen
import np.prashant.dev.recipes.ui.navigation.NavigationGraph.Screen
import np.prashant.dev.recipes.ui.navigation.compose.NavHost
import np.prashant.dev.recipes.ui.navigation.compose.composable
import np.prashant.dev.recipes.ui.recipedetail.RecipeDetailScreen
import np.prashant.dev.recipes.ui.search.RecipeSearchScreen
import np.prashant.dev.recipes.ui.splash.SplashScreen

@Composable
internal fun MainNavHost(
    navController: NavHostController,
    modifier: Modifier = Modifier,
) {
    NavHost(
        modifier = modifier,
        navController = navController,
        route = NavigationGraph.GRAPH_ROUTE,
        startScreen = Screen.Splash,
    ) {
        composable(Screen.Splash) { SplashScreen() }
        composable(Screen.RecipeSearch) { RecipeSearchScreen() }
        composable(Screen.Favourites) { FavouritesListScreen() }
        composable(Screen.RecipeDetail) { RecipeDetailScreen() }
    }
}