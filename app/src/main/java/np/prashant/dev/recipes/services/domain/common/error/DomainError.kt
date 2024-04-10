package np.prashant.dev.recipes.services.domain.common.error

sealed class DomainError(override val message: String) : Exception() {
    data class Error(override val message: String) : DomainError(message)
    data object NoConnection : DomainError("No internet connection")
    data object Unauthorized : DomainError("Unauthorized access")
    data object Unknown : DomainError("Something seems to be broken. Please contact customer support.")
}