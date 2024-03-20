package np.prashant.dev.recipes.services.platform.common.error

import java.io.IOException

sealed class RemoteError : IOException() {
    data class Error(override val message: String?) : RemoteError()
    data object Forbidden : RemoteError()
    data object ServerError : RemoteError()
    data object Unauthorized : RemoteError()
    data object Unavailable : RemoteError()
}
