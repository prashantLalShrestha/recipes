package np.prashant.dev.recipes.ui.favourites

import androidx.lifecycle.ViewModel
import dagger.hilt.android.lifecycle.HiltViewModel
import np.prashant.dev.recipes.ui.navigation.NavigationGraph.Screen
import np.prashant.dev.recipes.ui.navigation.navigator.Navigator
import javax.inject.Inject

@HiltViewModel
class FavouritesListViewModel @Inject constructor(
    private val navigator: Navigator,
) : ViewModel() {

    fun navigateToSearchScreen() {
        navigator.navigateTo(Screen.RecipeSearch())
    }

    fun navigateToRecipeDetail(recipeId: Long) {
        navigator.navigateTo(Screen.RecipeDetail(recipeId))
    }
}