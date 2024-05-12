package np.prashant.dev.recipes.services.domain.common.error

sealed class DomainError(override val message: String) : Exception() {
    data class Error(override val message: String) : DomainError(message)
    data object NoConnection : DomainError("No internet connection") {
        private fun readResolve(): Any = NoConnection
    }

    data object Unauthorized : DomainError("Unauthorized access") {
        private fun readResolve(): Any = Unauthorized
    }

    data object Unknown : DomainError("Something seems to be broken. Please contact customer support.") {
        private fun readResolve(): Any = Unknown
    }
}
