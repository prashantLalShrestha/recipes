package np.prashant.dev.recipes.core.extensions

import np.prashant.dev.recipes.services.domain.common.error.DomainError

fun Throwable.toDomainError(): DomainError {
    return if (this is DomainError) this
    else message?.let { DomainError.Error(it) } ?: DomainError.Unknown
}