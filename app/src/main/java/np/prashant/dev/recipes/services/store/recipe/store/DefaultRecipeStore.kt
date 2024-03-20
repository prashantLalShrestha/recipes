package np.prashant.dev.recipes.services.store.recipe.store

import np.prashant.dev.recipes.services.platform.recipe.contract.store.RecipeStore
import np.prashant.dev.recipes.services.store.recipe.dao.RecipeDao
import javax.inject.Inject


class DefaultRecipeStore @Inject constructor(
    private val recipeDao: RecipeDao,
) : RecipeStore {

}