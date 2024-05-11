package np.prashant.dev.recipes.ui.navigation.model

import androidx.navigation.NamedNavArgument
import androidx.navigation.NavDeepLink
import androidx.navigation.NavType
import androidx.navigation.navArgument

interface NavScreen {
    val fullRoute: String
    val arguments: List<NamedNavArgument>
    val deepLinks: List<NavDeepLink>
}

open class NavScreenWithNoArgs(route: String) : NavScreen {
    override val fullRoute = route
    override val arguments = emptyList<NamedNavArgument>()
    override val deepLinks = emptyList<NavDeepLink>()

    operator fun invoke(): String = fullRoute
}

open class NavScreenWithArgs(
    protected val route: String,
    vararg args: NavArgType,
) : NavScreen {

    private val requiredArgKeys = args.filterIsInstance<NavArg>().map { it.key }
    private val optionalArgKeys = args.filterIsInstance<OptionalNavArg>().map { it.key }

    override val fullRoute: String = buildString {
        append(route)
        requiredArgKeys.forEach { append("/{${it}}") }
        if (optionalArgKeys.isNotEmpty()) {
            append("?")
            optionalArgKeys.forEachIndexed { index, arg ->
                if (index > 0) append("&")
                append("${arg}={${arg}}")
            }
        }
    }

    override val arguments = args.map { arg ->
        when (arg) {
            is OptionalNavArg -> {
                navArgument(arg.key) {
                    if (arg.defaultValue == null) {
                        nullable = true
                    } else {
                        defaultValue = arg.defaultValue
                    }
                    type = arg.type
                }
            }

            else -> {
                navArgument(arg.key) {
                    type = arg.type
                }
            }
        }
    }

    override val deepLinks = emptyList<NavDeepLink>()

    protected fun String.appendParams(vararg params: Pair<String, Any?>): String {
        val builder = StringBuilder(this)
        requiredArgKeys.forEach { arg ->
            params.firstOrNull { it.first == arg }?.let { (_, value) ->
                value.let { builder.append("/$it") }
            }
        }
        if (optionalArgKeys.isNotEmpty()) {
            params.filter { param -> optionalArgKeys.any { it == param.first } }
                .forEach { (key, value) ->
                    val separator = if (builder.contains("?")) "&" else "?"
                    value?.let { builder.append("$separator${key}=$it") }
                }
        }
        return builder.toString()
    }
}


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
