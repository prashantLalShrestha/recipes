package np.prashant.dev.recipes.ui.common.locals

import androidx.compose.material3.SnackbarHostState
import androidx.compose.runtime.Composable
import androidx.compose.runtime.CompositionLocalProvider
import androidx.compose.runtime.compositionLocalOf

val LocalSnackbarHostState = compositionLocalOf {
    SnackbarHostState()
}

@Composable
fun SnackbarHostStateProvider(content: @Composable (snackbarHostState: SnackbarHostState) -> Unit) {
    val snackbarHostState = LocalSnackbarHostState.current

    CompositionLocalProvider(LocalSnackbarHostState provides snackbarHostState) {
        content(snackbarHostState)
    }
}