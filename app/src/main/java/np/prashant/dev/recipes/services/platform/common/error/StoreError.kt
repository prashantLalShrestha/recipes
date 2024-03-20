package np.prashant.dev.recipes.services.platform.common.error

sealed class StoreError : Exception() {
    data object DataNotFound: StoreError()
    data object Invalidated: StoreError()
}
