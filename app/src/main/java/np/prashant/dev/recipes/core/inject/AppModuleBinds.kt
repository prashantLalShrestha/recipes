package np.prashant.dev.recipes.core.inject

import dagger.Binds
import dagger.Module
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import np.prashant.dev.recipes.ui.navigation.AppNavigator
import np.prashant.dev.recipes.ui.navigation.Navigator

@Module
@InstallIn(SingletonComponent::class)
abstract class AppModuleBinds {

    @Binds
    abstract fun navigator(navigator: AppNavigator): Navigator
}