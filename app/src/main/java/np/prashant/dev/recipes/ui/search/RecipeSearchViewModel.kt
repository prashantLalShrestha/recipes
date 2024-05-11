package np.prashant.dev.recipes.ui.search

import androidx.lifecycle.viewModelScope
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.ExperimentalCoroutinesApi
import kotlinx.coroutines.FlowPreview
import kotlinx.coroutines.Job
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.debounce
import kotlinx.coroutines.flow.distinctUntilChanged
import kotlinx.coroutines.flow.emitAll
import kotlinx.coroutines.flow.launchIn
import kotlinx.coroutines.flow.map
import kotlinx.coroutines.flow.onEach
import kotlinx.coroutines.flow.transformLatest
import np.prashant.dev.recipes.services.domain.recipes.usecases.SearchRecipe
import np.prashant.dev.recipes.ui.common.viewmodel.ViewModel
import np.prashant.dev.recipes.ui.navigation.NavigationGraph.Screen
import np.prashant.dev.recipes.ui.navigation.navigator.Navigator
import javax.inject.Inject


@HiltViewModel
class RecipeSearchViewModel @Inject constructor(
    private val navigator: Navigator,
    searchRecipe: SearchRecipe,
) : ViewModel<RecipeSearchAction, RecipeSearchState>(initialState = RecipeSearchState()) {

    private val searchRecipeJob: Job = state
        .searchRecipes(searchRecipe)
        .onEach { setState { copy(recipes = it) } }
        .launchIn(viewModelScope)

    init {
        searchRecipeJob.start()
    }

    override fun onCleared() {
        searchRecipeJob.cancel()
        super.onCleared()
    }

    override suspend fun handleAction(action: RecipeSearchAction) {
        when (action) {
            is RecipeSearchAction.Search -> setState { copy(searchText = action.text) }
            is RecipeSearchAction.Navigation -> action.handleNavigation(navigator)
        }
    }
}

@OptIn(FlowPreview::class, ExperimentalCoroutinesApi::class)
private fun Flow<RecipeSearchState>.searchRecipes(searchRecipe: SearchRecipe) =
    map { it.searchText }
        .debounce(500L)
        .distinctUntilChanged()
        .transformLatest { searchText ->
            if (searchText.isNullOrBlank()) {
                emit(listOf())
            } else {
                emitAll(searchRecipe(searchText))
            }
        }


private fun RecipeSearchAction.Navigation.handleNavigation(navigator: Navigator) {
    when (this) {
        RecipeSearchAction.Navigation.Back -> navigator.navigateBack()
        is RecipeSearchAction.Navigation.RecipeDetail -> navigator.navigateTo(Screen.RecipeDetail(id))
    }
}