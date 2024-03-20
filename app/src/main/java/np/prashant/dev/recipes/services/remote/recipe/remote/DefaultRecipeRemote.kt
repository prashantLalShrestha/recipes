package np.prashant.dev.recipes.services.remote.recipe.remote

import np.prashant.dev.recipes.services.domain.recipes.model.RecipeElement
import np.prashant.dev.recipes.services.platform.recipe.contract.remote.RecipeRemote
import javax.inject.Inject

class DefaultRecipeRemote @Inject constructor() : RecipeRemote {

    override suspend fun searchRecipe(query: String): List<RecipeElement> {
        TODO("Not yet implemented")
    }
}