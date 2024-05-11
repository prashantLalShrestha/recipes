package np.prashant.dev.recipes.ui.navigation

import androidx.navigation.NavType
import np.prashant.dev.recipes.ui.navigation.model.NavArg
import np.prashant.dev.recipes.ui.navigation.model.NavScreen
import np.prashant.dev.recipes.ui.navigation.model.NavScreenWithArgs
import np.prashant.dev.recipes.ui.navigation.model.NavScreenWithNoArgs

object NavigationGraph {

    const val GRAPH_ROUTE = "/root"
    const val GRAPH_DEEPLINK_PREFIX = "android-app://androidx.navigation"

    sealed class Screen : NavScreen {
        data object Splash : NavScreenWithNoArgs(Routes.SPLASH)
        data object RecipeSearch : NavScreenWithNoArgs(Routes.RECIPE_SEARCH)
        data object Favourites : NavScreenWithNoArgs(Routes.FAVOURITES)
        data object RecipeDetail : NavScreenWithArgs(
            Routes.RECIPE_DETAIL,
            NavArg(NavArguments.RECIPE_ID, NavType.LongType)
        ) {
            operator fun invoke(id: Long): String = route.appendParams(
                NavArguments.RECIPE_ID to id,
            )
        }
    }

    private object Routes {
        const val SPLASH = "splash"
        const val RECIPE_SEARCH = "recipe-search"
        const val FAVOURITES = "favourites"
        const val RECIPE_DETAIL = "recipe-detail"
    }

    object NavArguments {
        const val RECIPE_ID = "recipeId"
    }
}
