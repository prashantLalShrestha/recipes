package np.prashant.dev.recipes.core.extensions

inline fun <T> tryOrNull(f: () -> T) =
    try {
        f()
    } catch (_: Exception) {
        null
    }