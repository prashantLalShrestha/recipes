package np.prashant.dev.recipes.services.domain.common.error

sealed class DomainError(override val message: String) : Exception() {
    data class Error(override val message: String) : DomainError(message)
    object NoConnection : DomainError("No internet connection")
    object Unauthorized : DomainError("Unauthorized access")
    object Unknown : DomainError("Something seems to be broken. Please contact customer support.")
}