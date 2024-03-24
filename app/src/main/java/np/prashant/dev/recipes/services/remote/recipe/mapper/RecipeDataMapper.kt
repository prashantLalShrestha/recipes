package np.prashant.dev.recipes.services.remote.recipe.mapper

import np.prashant.dev.recipes.services.domain.recipes.model.RecipeElement
import np.prashant.dev.recipes.services.remote.recipe.model.RecipeDataResponse
import np.prashant.dev.recipes.services.remote.recipe.model.RecipeSearchResponse


internal fun RecipeSearchResponse.toDomain(): List<RecipeElement> =
    results.map { it.toDomain() }

internal fun RecipeDataResponse.toDomain(): RecipeElement =
    RecipeElement(
        id = id,
        title = title,
        image = image,
        isFavourite = false
    )