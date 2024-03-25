package np.prashant.dev.recipes.ui.favourites

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.launch
import np.prashant.dev.recipes.ui.navigation.NavigationGraph
import np.prashant.dev.recipes.ui.navigation.navigator.Navigator
import np.prashant.dev.recipes.ui.navigation.utils.defaultTransition
import javax.inject.Inject

@HiltViewModel
class FavouritesListViewModel @Inject constructor(
    private val navigator: Navigator,
) : ViewModel() {

    fun navigateToSearchScreen() {
        viewModelScope.launch {
            navigator.navigate { controller ->
                controller.navigate(NavigationGraph.Screen.RecipeSearch.route) {
                    anim { defaultTransition() }
                }
            }
        }
    }

    fun navigateToRecipeDetail(recipeId: Long) {
        viewModelScope.launch {
            navigator.navigate { controller ->
                controller.navigate(NavigationGraph.Screen.RecipeDetail.route + "?id=$recipeId")
            }
        }
    }
}