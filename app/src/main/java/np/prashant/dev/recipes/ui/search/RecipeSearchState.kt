package np.prashant.dev.recipes.ui.search

import np.prashant.dev.recipes.services.domain.recipes.model.RecipeElement
import np.prashant.dev.recipes.ui.common.viewmodel.ViewState

data class RecipeSearchState(
    val searchText: String? = null,
    val recipes: List<RecipeElement> = listOf()
) : ViewState