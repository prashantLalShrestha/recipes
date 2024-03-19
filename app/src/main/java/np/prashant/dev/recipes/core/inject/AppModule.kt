package np.prashant.dev.recipes.core.inject

import androidx.lifecycle.ProcessLifecycleOwner
import androidx.lifecycle.coroutineScope
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import kotlinx.coroutines.CoroutineScope

@Module(includes = [AppModuleBinds::class])
@InstallIn(SingletonComponent::class)
object AppModule {

    @Provides
    @ProcessLifetime
    fun provideLongLifetimeScope(): CoroutineScope =
        ProcessLifecycleOwner.get().lifecycle.coroutineScope

}