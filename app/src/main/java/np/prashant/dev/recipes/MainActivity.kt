package np.prashant.dev.recipes

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.runtime.rememberCoroutineScope
import androidx.lifecycle.lifecycleScope
import androidx.navigation.NavHostController
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import dagger.hilt.android.AndroidEntryPoint
import kotlinx.coroutines.launch
import np.prashant.dev.recipes.ui.navigation.navigator.AppNavigator
import np.prashant.dev.recipes.ui.navigation.MainNavHost
import np.prashant.dev.recipes.ui.navigation.NavigationGraph
import np.prashant.dev.recipes.ui.navigation.NavigationGraph.Screen
import np.prashant.dev.recipes.ui.splash.SplashScreen
import np.prashant.dev.recipes.ui.theme.AppTheme
import javax.inject.Inject

@AndroidEntryPoint
class MainActivity : ComponentActivity() {

    @Inject
    internal lateinit var navigator: AppNavigator

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            AppTheme {
                val navController = rememberNavController()

                LaunchedEffect(true) {
                    handleNavigation(navController)
                }

                MainNavHost(navController)
            }
        }
    }

    private fun handleNavigation(navController: NavHostController) {
        lifecycleScope.launch {
            // Collect navigation and delegate navigation implementation to Jetpack Navigation.
            navigator.navigations.collect { navigation ->
                navigation(navController)
            }
        }
    }
}