package np.prashant.dev.recipes.core.di.modules

import dagger.Binds
import dagger.Module
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import np.prashant.dev.recipes.core.executor.DefaultPostExecutionThread
import np.prashant.dev.recipes.services.domain.common.executor.PostExecutionThread
import javax.inject.Singleton

@[Module InstallIn(SingletonComponent::class)]
interface ExecutorModule {

    @[Binds Singleton]
    fun postExecutionThread(thread: DefaultPostExecutionThread): PostExecutionThread
}