package np.prashant.dev.recipes.services.platform.recipe.contract.remote

import np.prashant.dev.recipes.services.domain.recipes.model.RecipeElement

interface RecipeRemote {
    suspend fun searchRecipe(query: String): List<RecipeElement>
}