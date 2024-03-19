package np.prashant.dev.recipes.ui.splash

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.async
import kotlinx.coroutines.delay
import kotlinx.coroutines.launch
import np.prashant.dev.recipes.ui.navigation.NavigationGraph
import np.prashant.dev.recipes.ui.navigation.NavigationGraph.Screen
import np.prashant.dev.recipes.ui.navigation.Navigator
import np.prashant.dev.recipes.ui.navigation.defaultTransition
import javax.inject.Inject
import kotlin.time.Duration.Companion.seconds

@HiltViewModel
class SplashViewModel @Inject constructor(
    private val navigator: Navigator,
) : ViewModel() {

    fun continueToNextScreen() {
        viewModelScope.launch {
            val delay = async { cosmeticDelay() }

            delay.await()

            navigateToNextScreen()
        }
    }

    private suspend fun cosmeticDelay() = delay(COSMETIC_DELAY)

    private fun navigateToNextScreen() {
        navigator.navigate { controller ->
            controller.navigate(Screen.RecipeSearch.route) {
                anim { defaultTransition() }
                popUpTo(NavigationGraph.GRAPH_ROUTE) {
                    inclusive = true
                }
            }
        }
    }

    companion object {
        val COSMETIC_DELAY = 2.5.seconds
    }
}