package np.prashant.dev.recipes.services.remote.recipe.mapper

import np.prashant.dev.recipes.services.domain.recipes.model.RecipeElement
import np.prashant.dev.recipes.services.remote.recipe.model.RecipeDataResponse

internal fun RecipeDataResponse.toDomain(): RecipeElement =
    RecipeElement(
        id = id,
        title = title,
        image = image,
        isFavourite = false
    )