package np.prashant.dev.recipes.services.domain.recipes.model

data class RecipeElement(
    val id: Long,
    val title: String,
    val image: String,
    val isFavourite: Boolean,
)