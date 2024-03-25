package np.prashant.dev.recipes.ui.search

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.Job
import kotlinx.coroutines.flow.launchIn
import kotlinx.coroutines.launch
import np.prashant.dev.recipes.services.domain.recipes.usecases.SearchRecipe
import np.prashant.dev.recipes.ui.navigation.NavigationGraph.Screen
import np.prashant.dev.recipes.ui.navigation.navigator.Navigator
import javax.inject.Inject


@HiltViewModel
class RecipeSearchViewModel @Inject constructor(
    private val navigator: Navigator,
    private val searchRecipe: SearchRecipe
) : ViewModel() {


    private var searchRecipeJob: Job? = null

    init {
//        performSearchRecipe("pancakes")
    }

    fun navigateBack() {
        viewModelScope.launch {
            navigator.navigate { controller ->
                controller.navigateUp()
            }
        }
    }

    fun navigateToRecipeDetail(recipeId: Long) {
        viewModelScope.launch {
            navigator.navigate { controller ->
                controller.navigate(Screen.RecipeDetail.route + "?id=$recipeId")
            }
        }
    }

    fun performSearchRecipe(query: String) {
        searchRecipeJob?.cancel()

        searchRecipeJob = searchRecipe(query).launchIn(viewModelScope)
    }
}