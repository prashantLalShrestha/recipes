package np.prashant.dev.recipes.services.store.recipe.mapper

import np.prashant.dev.recipes.services.domain.recipes.model.RecipeElement
import np.prashant.dev.recipes.services.store.recipe.model.RecipeEntity


internal fun RecipeElement.toEntity(): RecipeEntity =
    RecipeEntity(
        id = id,
        title = title,
        image = image,
        isFavourite = isFavourite,
    )

internal fun RecipeEntity.toDomain(): RecipeElement =
    RecipeElement(
        id = id,
        title = title,
        image = image,
        isFavourite = isFavourite,
    )