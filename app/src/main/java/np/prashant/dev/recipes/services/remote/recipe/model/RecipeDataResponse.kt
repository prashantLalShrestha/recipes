package np.prashant.dev.recipes.services.remote.recipe.model

import kotlinx.serialization.Serializable

@Serializable
data class RecipeDataResponse(
    val id: Long,
    val title: String,
    val image: String,
    val imageType: String,
)
