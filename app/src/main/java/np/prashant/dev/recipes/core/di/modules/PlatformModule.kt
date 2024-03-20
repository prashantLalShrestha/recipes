package np.prashant.dev.recipes.core.di.modules

import dagger.Binds
import dagger.Module
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import np.prashant.dev.recipes.services.domain.recipes.repositories.RecipeRepository
import np.prashant.dev.recipes.services.platform.recipe.repositories.DefaultRecipeRepository
import javax.inject.Singleton

@[Module InstallIn(SingletonComponent::class)]
interface PlatformModule {

    @[Binds Singleton]
    fun recipeRepository(repository: DefaultRecipeRepository): RecipeRepository
}