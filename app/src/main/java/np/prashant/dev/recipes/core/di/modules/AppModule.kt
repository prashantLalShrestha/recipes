package np.prashant.dev.recipes.core.di.modules

import androidx.lifecycle.ProcessLifecycleOwner
import androidx.lifecycle.coroutineScope
import dagger.Binds
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import kotlinx.coroutines.CoroutineScope
import np.prashant.dev.recipes.core.di.scopes.ProcessLifetime
import np.prashant.dev.recipes.ui.navigation.navigator.AppNavigator
import np.prashant.dev.recipes.ui.navigation.navigator.Navigator
import javax.inject.Singleton

@[Module InstallIn(SingletonComponent::class)]
interface AppModule {

    @[Binds Singleton]
    fun navigator(navigator: AppNavigator): Navigator

    companion object {

        @[Provides ProcessLifetime]
        fun provideLongLifetimeScope(): CoroutineScope =
            ProcessLifecycleOwner.get().lifecycle.coroutineScope
    }
}