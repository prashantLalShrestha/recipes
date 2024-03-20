package np.prashant.dev.recipes.services.platform.recipe.repositories

import kotlinx.coroutines.flow.Flow
import np.prashant.dev.recipes.services.domain.recipes.model.RecipeElement
import np.prashant.dev.recipes.services.domain.recipes.repositories.RecipeRepository
import np.prashant.dev.recipes.services.platform.common.repositories.Repository
import np.prashant.dev.recipes.services.platform.recipe.contract.remote.RecipeRemote
import np.prashant.dev.recipes.services.platform.recipe.contract.store.RecipeStore
import javax.inject.Inject

class DefaultRecipeRepository @Inject constructor(
    private val recipeRemote: RecipeRemote,
    private val recipeStore: RecipeStore
) : Repository(), RecipeRepository {
    override fun searchRecipe(query: String): Flow<List<RecipeElement>> {
        return makeFlow {
            recipeRemote.searchRecipe(query)
        }
    }

}