package np.prashant.dev.recipes.ui.search

import np.prashant.dev.recipes.ui.common.viewmodel.ViewAction

sealed interface RecipeSearchAction : ViewAction {
    data class Search(val text: String) : RecipeSearchAction

    sealed interface Navigation : RecipeSearchAction {
        data object Back : Navigation

        data class RecipeDetail(val id: Long) : Navigation
    }
}