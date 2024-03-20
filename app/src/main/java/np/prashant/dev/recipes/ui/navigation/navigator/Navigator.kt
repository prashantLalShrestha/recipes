package np.prashant.dev.recipes.ui.navigation.navigator

import androidx.navigation.NavController

typealias Navigation = (NavController) -> Unit

/**
 * Interface that exposes high level functionality for navigation.
 */
interface Navigator {
    fun navigate(navigation: Navigation)
}