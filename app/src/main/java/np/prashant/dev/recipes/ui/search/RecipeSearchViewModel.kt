package np.prashant.dev.recipes.ui.search

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.Job
import kotlinx.coroutines.flow.launchIn
import np.prashant.dev.recipes.services.domain.recipes.usecases.SearchRecipe
import javax.inject.Inject


@HiltViewModel
class RecipeSearchViewModel @Inject constructor(
    private val searchRecipe: SearchRecipe
) : ViewModel() {


    private var searchRecipeJob: Job? = null

    init {
        performSearchRecipe("pancakes")
    }

    fun performSearchRecipe(query: String) {
        searchRecipeJob?.cancel()

        searchRecipeJob = searchRecipe(query).launchIn(viewModelScope)
    }
}