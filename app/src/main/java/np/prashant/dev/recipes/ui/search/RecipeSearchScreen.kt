package np.prashant.dev.recipes.ui.search

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.navigationBarsPadding
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.statusBarsPadding
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.hilt.navigation.compose.hiltViewModel
import np.prashant.dev.recipes.R
import np.prashant.dev.recipes.ui.components.SearchTextField
import np.prashant.dev.recipes.ui.search.components.RecipeListItem
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
    Column(
        modifier = modifier
            .background(MaterialTheme.colorScheme.background)
            .statusBarsPadding()
    ) {
        Column(
            modifier = Modifier
                .padding(horizontal = 16.dp)
                .padding(vertical = 8.dp),
            horizontalAlignment = Alignment.Start
        ) {
            Text(
                text = "Hello there!",
                fontWeight = FontWeight.Bold,
                style = MaterialTheme.typography.headlineSmall
            )
            Text(
                text = "What are you going to cook?",
                style = MaterialTheme.typography.labelLarge
            )
            Spacer(modifier = Modifier.height(16.dp))
            SearchTextField(
                modifier = Modifier
                    .fillMaxWidth()
                    .background(
                        color = MaterialTheme.colorScheme.surface,
                        shape = MaterialTheme.shapes.extraLarge
                    ),
                value = "",
                placeholder = "Search recipes",
                onValueChange = {}
            )
        }

        LazyColumn(
            modifier = Modifier
                .fillMaxSize()
                .padding(top = 16.dp)
                .navigationBarsPadding()
        ) {
            item {
                RecipeListItem(
                    modifier = Modifier
                        .fillMaxWidth()
                        .padding(top = 8.dp, start = 16.dp, bottom = 8.dp, end = 16.dp),
                    imageUrl = "https://spoonacular.com/recipeImages/654495-312x231.jpg",
                    title = "Pancakes",
                    isFavourite = true,
                )
            }
            item {
                RecipeListItem(
                    modifier = Modifier
                        .fillMaxWidth()
                        .padding(top = 8.dp, start = 16.dp, bottom = 8.dp, end = 16.dp),
                    imageUrl = "https://spoonacular.com/recipeImages/756817-312x231.jpg",
                    title = "Matcha Pancakes",
                    isFavourite = false,
                )
            }
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