package np.prashant.dev.recipes

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Scaffold
import androidx.compose.material3.SnackbarHost
import androidx.compose.ui.Modifier
import androidx.core.view.WindowCompat
import androidx.navigation.compose.rememberNavController
import dagger.hilt.android.AndroidEntryPoint
import np.prashant.dev.recipes.ui.common.locals.SnackbarHostStateProvider
import np.prashant.dev.recipes.ui.navigation.MainNavHost
import np.prashant.dev.recipes.ui.navigation.compose.NavigationEffect
import np.prashant.dev.recipes.ui.navigation.navigator.AppNavigator
import np.prashant.dev.recipes.ui.theme.AppTheme
import javax.inject.Inject

@AndroidEntryPoint
class MainActivity : ComponentActivity() {

    @Inject
    internal lateinit var navigator: AppNavigator

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        // Make layout content draw underneath the status bar and navigation bar. Use
        // Accompanist Insets (Compose) or Insetter (Views) to offset your layout when needed.
        WindowCompat.setDecorFitsSystemWindows(window, false)

        setContent {
            val navController = rememberNavController()
            AppTheme {
                SnackbarHostStateProvider { snackbarHostState ->
                    NavigationEffect(navController, navigator.navigationChannel)

                    Scaffold(
                        snackbarHost = { SnackbarHost(hostState = snackbarHostState) }
                    ) {
                        MainNavHost(navController, Modifier.padding(it))
                    }
                }
            }
        }
    }
}