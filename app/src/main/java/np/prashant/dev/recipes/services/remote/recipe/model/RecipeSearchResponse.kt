package np.prashant.dev.recipes.services.remote.recipe.model

import kotlinx.serialization.Serializable

@Serializable
data class RecipeSearchResponse(
    val offset: Int,
    val number: Int,
    val totalResults: Int,
    val results: List<RecipeDataResponse>
)
