package np.prashant.dev.recipes.services.platform.common.repositories

import np.prashant.dev.recipes.services.platform.common.extensions.toDomainError
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.catch
import kotlinx.coroutines.flow.flow

abstract class Repository {

    protected fun <T> makeFlow(call: suspend () -> T) : Flow<T> {
        return flow {
            emit(call.invoke())
        }.catch { error ->
            throw error.toDomainError()
        }
    }
}