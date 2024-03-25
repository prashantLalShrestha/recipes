package np.prashant.dev.recipes.ui.search

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.navigationBarsPadding
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.statusBarsPadding
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.automirrored.filled.ArrowBack
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material3.MaterialTheme
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.hilt.navigation.compose.hiltViewModel
import np.prashant.dev.recipes.ui.components.RecipeListItem
import np.prashant.dev.recipes.ui.components.SearchTextField
import np.prashant.dev.recipes.ui.theme.AppTheme

@Composable
internal fun RecipeSearchScreen(
    modifier: Modifier = Modifier,
    viewModel: RecipeSearchViewModel = hiltViewModel(),
) {
    RecipeSearchView(
        modifier = modifier.fillMaxSize(),
        onBackPress = viewModel::navigateBack,
        onRecipeClick = viewModel::navigateToRecipeDetail,
    )
}

@Composable
private fun RecipeSearchView(
    modifier: Modifier = Modifier,
    onBackPress: () -> Unit,
    onRecipeClick: (id: Long) -> Unit
) {
    Column(
        modifier = modifier
            .background(MaterialTheme.colorScheme.background)
            .statusBarsPadding()
    ) {
        SearchTextField(
            modifier = Modifier
                .fillMaxWidth()
                .padding(16.dp)
                .background(
                    color = MaterialTheme.colorScheme.surface,
                    shape = MaterialTheme.shapes.medium
                ),
            value = "",
            placeholder = "Search recipes",
            leadingIcon = {
                IconButton(
                    onClick = onBackPress,
                ) {
                    Icon(
                        imageVector = Icons.AutoMirrored.Filled.ArrowBack,
                        contentDescription = "Back Icon"
                    )
                }
            },
            onValueChange = {}
        )

        LazyColumn(
            modifier = Modifier
                .fillMaxSize()
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
                    onClick = {
                        onRecipeClick(654495)
                    }
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
                    onClick = {
                        onRecipeClick(756817)
                    }
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
            onBackPress = {},
            onRecipeClick = {},
        )
    }
}