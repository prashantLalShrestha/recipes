package np.prashant.dev.recipes.ui.search

import androidx.compose.ui.tooling.preview.PreviewParameterProvider
import np.prashant.dev.recipes.services.domain.recipes.model.RecipeElement


internal open class RecipeSearchPreviewProvider : PreviewParameterProvider<RecipeSearchState> {

    override val values: Sequence<RecipeSearchState> =
        sequenceOf(
            RecipeSearchState(
                searchText = "Pancakes",
                recipes = listOf(
                    RecipeElement(
                        id = 654495,
                        title = "Pancakes",
                        image = "https://spoonacular.com/recipeImages/654495-312x231.jpg",
                        isFavourite = true,
                    ),
                    RecipeElement(
                        id = 756817,
                        title = "Matcha Pancakes",
                        image = "https://spoonacular.com/recipeImages/756817-312x231.jpg",
                        isFavourite = false,
                    )
                )
            ),
            RecipeSearchState(),
        )
}