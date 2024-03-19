package np.prashant.dev.recipes.ui.search

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.hilt.navigation.compose.hiltViewModel
import np.prashant.dev.recipes.R
import np.prashant.dev.recipes.ui.theme.AppTheme

@Composable
internal fun RecipeSearchScreen(
    modifier: Modifier = Modifier,
    viewModel: RecipeSearchViewModel = hiltViewModel(),
) {
    RecipeSearchView(modifier.fillMaxSize())
}

@Composable
private fun RecipeSearchView(
    modifier: Modifier = Modifier,
) {
    Surface(
        modifier = modifier,
    ) {
        Column(
            modifier = Modifier.padding(horizontal = 32.dp),
            horizontalAlignment = Alignment.CenterHorizontally,
            verticalArrangement = Arrangement.Center,
        ) {

            Text(
                text = stringResource(id = R.string.splash_content_text),
                style = MaterialTheme.typography.titleLarge,
            )
        }
    }
}

@Preview
@Composable
internal fun RecipeSearchScreenPreview() {
    AppTheme {
        RecipeSearchView(
            modifier = Modifier.fillMaxSize(),
        )
    }
}