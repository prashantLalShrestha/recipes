package np.prashant.dev.recipes.ui.theme

import android.app.Activity
import androidx.compose.foundation.isSystemInDarkTheme
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.darkColorScheme
import androidx.compose.material3.lightColorScheme
import androidx.compose.runtime.Composable
import androidx.compose.runtime.SideEffect
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.toArgb
import androidx.compose.ui.platform.LocalView
import androidx.core.view.WindowCompat

private val DarkColorScheme = darkColorScheme(
    primary = Color.Black,
    primaryContainer = AntiFlashWhite,
    tertiary = Camel,
    secondary = LightFrenchBeige,
    tertiaryContainer = Color.Black,
    background = Color.Black,
    surface = DarkJungleGreen,
    error = PalePink,
    errorContainer = PalePink,
    onPrimary = LightFrenchBeige,
    onPrimaryContainer = Color.Black,
    onSecondary = DarkJungleGreen,
    onTertiary = AntiFlashWhite,
    onTertiaryContainer = LightFrenchBeige,
    onBackground = LightFrenchBeige,
    onSurface = AntiFlashWhite,
    onError = Flame,
    onErrorContainer = LightFrenchBeige,
)

private val LightColorScheme = lightColorScheme(
    primary = Color.White,
    primaryContainer = DarkJungleGreen,
    tertiary = Camel,
    secondary = LightFrenchBeige,
    tertiaryContainer = Color.White,
    background = Color.White,
    surface = AntiFlashWhite,
    error = PalePink,
    errorContainer = DarkJungleGreen,
    onPrimary = LightFrenchBeige,
    onPrimaryContainer = Color.White,
    onSecondary = AntiFlashWhite,
    onTertiary = DarkJungleGreen,
    onTertiaryContainer = LightFrenchBeige,
    onBackground = LightFrenchBeige,
    onSurface = DarkJungleGreen,
    onError = Flame,
    onErrorContainer = LightFrenchBeige,
)


@Composable
fun AppTheme(
    darkTheme: Boolean = isSystemInDarkTheme(),
    content: @Composable () -> Unit
) {
    val colorScheme = when {
        darkTheme -> DarkColorScheme
        else -> LightColorScheme
    }
    val view = LocalView.current
    if (!view.isInEditMode) {
        SideEffect {
            val window = (view.context as Activity).window
            window.statusBarColor = Color.Transparent.toArgb()
            WindowCompat.getInsetsController(window, view).isAppearanceLightStatusBars = !darkTheme
        }
    }

    MaterialTheme(
        colorScheme = colorScheme,
        shapes = Shapes,
        typography = Typography,
        content = content
    )
}