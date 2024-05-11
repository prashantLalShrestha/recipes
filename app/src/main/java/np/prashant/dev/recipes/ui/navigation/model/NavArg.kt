package np.prashant.dev.recipes.ui.navigation.model

import androidx.navigation.NavType

sealed interface NavArgType {
    val key: String
    val type: NavType<*>
}

data class NavArg(
    override val key: String,
    override val type: NavType<*> = NavType.StringType
) : NavArgType

data class OptionalNavArg(
    override val key: String,
    override val type: NavType<*> = NavType.StringType,
    val defaultValue: Any? = null,
) : NavArgType