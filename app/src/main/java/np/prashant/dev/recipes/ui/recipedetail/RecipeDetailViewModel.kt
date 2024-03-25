package np.prashant.dev.recipes.ui.recipedetail

import androidx.lifecycle.SavedStateHandle
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.launch
import np.prashant.dev.recipes.ui.navigation.navigator.Navigator
import javax.inject.Inject

@HiltViewModel
class RecipeDetailViewModel @Inject constructor(
    private val navigator: Navigator,
    savedStateHandle: SavedStateHandle,
) : ViewModel() {

    init {
        savedStateHandle.get<Long>("id")?.let { recipeId ->
           println("RecipeDetailViewModel: $recipeId")
        }
    }

    fun navigateBack() {
        viewModelScope.launch {
            navigator.navigate { controller ->
                controller.navigateUp()
            }
        }
    }
}