package np.prashant.dev.recipes.ui.navigation.compose

import androidx.compose.animation.AnimatedContentScope
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.navigation.NavBackStackEntry
import androidx.navigation.NavGraphBuilder
import androidx.navigation.NavHostController
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import np.prashant.dev.recipes.ui.navigation.model.NavScreen

@Composable
fun NavHost(
    navController: NavHostController,
    startScreen: NavScreen,
    modifier: Modifier = Modifier,
    route: String? = null,
    builder: NavGraphBuilder.() -> Unit
) {
    NavHost(
        navController = navController,
        startDestination = startScreen.fullRoute,
        modifier = modifier,
        route = route,
        builder = builder
    )
}

fun NavGraphBuilder.composable(
    screen: NavScreen,
    content: @Composable AnimatedContentScope.(NavBackStackEntry) -> Unit
) {
    composable(
        route = screen.fullRoute,
        arguments = screen.arguments,
        deepLinks = screen.deepLinks,
        content = content
    )
}