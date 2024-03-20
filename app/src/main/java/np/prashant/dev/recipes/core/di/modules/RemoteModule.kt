package np.prashant.dev.recipes.core.di.modules

import dagger.Binds
import dagger.Module
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import np.prashant.dev.recipes.services.platform.recipe.contract.remote.RecipeRemote
import np.prashant.dev.recipes.services.remote.recipe.remote.DefaultRecipeRemote
import javax.inject.Singleton

@[Module InstallIn(SingletonComponent::class)]
interface RemoteModule {

    @[Binds Singleton]
    fun recipeRemote(remote: DefaultRecipeRemote): RecipeRemote

    companion object {

    }
}