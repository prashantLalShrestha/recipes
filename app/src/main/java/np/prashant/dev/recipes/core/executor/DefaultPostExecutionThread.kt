package np.prashant.dev.recipes.core.executor

import kotlinx.coroutines.CoroutineDispatcher
import kotlinx.coroutines.Dispatchers
import np.prashant.dev.recipes.services.domain.common.executor.PostExecutionThread
import javax.inject.Inject

class DefaultPostExecutionThread @Inject constructor() : PostExecutionThread {
    override val main: CoroutineDispatcher = Dispatchers.Main
    override val io: CoroutineDispatcher = Dispatchers.IO
    override val default: CoroutineDispatcher = Dispatchers.Default
}