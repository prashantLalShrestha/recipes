package np.prashant.dev.recipes.ui.navigation.navigator

/**
 * Interface that exposes high level functionality for navigation.
 */
interface Navigator {

    fun navigateBack(
        route: String? = null,
        inclusive: Boolean = false,
        params: List<Pair<String, Any?>> = listOf(),
    )

    fun navigateTo(
        route: String,
        popUpToRoute: String? = null,
        inclusive: Boolean = false,
        isSingleTop: Boolean = false,
    )
}