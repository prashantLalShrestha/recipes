package np.prashant.dev.recipes.services.platform.common.extensions

import np.prashant.dev.recipes.services.domain.common.error.DomainError
import np.prashant.dev.recipes.services.platform.common.error.RemoteError

internal fun Throwable.toDomainError() : DomainError {
    return when (this) {
        is RemoteError -> this.toDomainError()
        else -> this.message?.let { DomainError.Error(it) } ?: DomainError.Unknown
    }
}

private fun RemoteError.toDomainError() : DomainError {
    return when(this) {
        is RemoteError.Error -> message?.let { DomainError.Error(it) } ?: DomainError.Unknown
        RemoteError.Forbidden -> DomainError.Unknown
        RemoteError.ServerError -> DomainError.Error("Something unexpected occurred. Please contact customer service for further detail.")
        RemoteError.Unauthorized -> DomainError.Unauthorized
        RemoteError.Unavailable -> DomainError.NoConnection
    }
}