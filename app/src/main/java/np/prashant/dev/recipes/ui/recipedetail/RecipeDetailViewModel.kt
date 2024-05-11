package np.prashant.dev.recipes.ui.recipedetail

import androidx.lifecycle.SavedStateHandle
import androidx.lifecycle.ViewModel
import dagger.hilt.android.lifecycle.HiltViewModel
import np.prashant.dev.recipes.ui.navigation.NavigationGraph.NavArguments
import np.prashant.dev.recipes.ui.navigation.navigator.Navigator
import javax.inject.Inject

@HiltViewModel
class RecipeDetailViewModel @Inject constructor(
    private val navigator: Navigator,
    savedStateHandle: SavedStateHandle,
) : ViewModel() {

    init {
        savedStateHandle.get<Long>(NavArguments.RECIPE_ID)?.let { recipeId ->
           println("RecipeDetailViewModel: $recipeId")
        }
    }

    fun navigateBack() = navigator.navigateBack()
}