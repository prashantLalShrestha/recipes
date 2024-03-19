package np.prashant.dev.recipes.ui.splash

import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.ColorFilter
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.hilt.navigation.compose.hiltViewModel
import np.prashant.dev.recipes.R
import np.prashant.dev.recipes.ui.theme.AppTheme

@Composable
internal fun SplashScreen(
    modifier: Modifier = Modifier,
    viewModel: SplashViewModel = hiltViewModel(),
) {
    LaunchedEffect(true) {
        viewModel.continueToNextScreen()
    }

    SplashView(
        modifier = modifier.fillMaxSize()
    )
}

@Composable
private fun SplashView(
    modifier: Modifier = Modifier,
) {
    Surface(modifier = modifier) {
        Column(
            modifier = Modifier.padding(horizontal = 32.dp),
            horizontalAlignment = Alignment.CenterHorizontally,
            verticalArrangement = Arrangement.Center,
        ) {
            Image(
                painter = painterResource(id = R.drawable.ic_launcher_foreground),
                contentDescription = stringResource(id = R.string.acc_splash_icon),
                colorFilter = ColorFilter.tint(MaterialTheme.colorScheme.onSurface)
            )

            Text(
                text = stringResource(id = R.string.splash_content_text),
                style = MaterialTheme.typography.headlineLarge,
            )
        }
    }
}

@Preview
@Composable
internal fun SplashScreenPreview() {
    AppTheme {
        SplashView(
            modifier = Modifier.fillMaxSize(),
        )
    }
}