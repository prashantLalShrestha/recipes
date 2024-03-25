package np.prashant.dev.recipes.ui.navigation

object NavigationGraph {

    const val GRAPH_ROUTE = "/root"
    const val GRAPH_DEEPLINK_PREFIX = "android-app://androidx.navigation"

    enum class Screen(val route: String) {
        Splash("splash"),
        RecipeSearch("recipe-search"),
        Favourites("favourites"),
        RecipeDetail("recipe-detail"),
    }

    object NavArguments
}
