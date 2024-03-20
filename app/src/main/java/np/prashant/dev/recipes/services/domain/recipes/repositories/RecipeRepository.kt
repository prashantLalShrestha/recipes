package np.prashant.dev.recipes.services.domain.recipes.repositories

import kotlinx.coroutines.flow.Flow
import np.prashant.dev.recipes.services.domain.recipes.model.RecipeElement

interface RecipeRepository {
    fun searchRecipe(query: String): Flow<List<RecipeElement>>
}