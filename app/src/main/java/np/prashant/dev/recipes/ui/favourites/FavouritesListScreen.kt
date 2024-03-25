package np.prashant.dev.recipes.ui.favourites

import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.interaction.MutableInteractionSource
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
import androidx.compose.runtime.remember
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.semantics.Role
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.hilt.navigation.compose.hiltViewModel
import np.prashant.dev.recipes.ui.components.RecipeListItem
import np.prashant.dev.recipes.ui.components.SearchTextField
import np.prashant.dev.recipes.ui.theme.AppTheme

@Composable
internal fun FavouritesListScreen(
    modifier: Modifier = Modifier,
    viewModel: FavouritesListViewModel = hiltViewModel(),
) {
    FavouritesListView(
        modifier = modifier.fillMaxSize(),
        onSearchClick = viewModel::navigateToSearchScreen,
        onRecipeClick = viewModel::navigateToRecipeDetail,
    )
}

@Composable
private fun FavouritesListView(
    modifier: Modifier = Modifier,
    onSearchClick: () -> Unit,
    onRecipeClick: (id: Long) -> Unit
) {
    val searchInteractionSource = remember { MutableInteractionSource() }

    Column(
        modifier = modifier
            .background(MaterialTheme.colorScheme.background)
            .statusBarsPadding()
    ) {
        Column(
            modifier = Modifier
                .padding(16.dp),
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
                        shape = MaterialTheme.shapes.medium
                    )
                    .clickable(
                        interactionSource = searchInteractionSource,
                        indication = null,
                        role = Role.Button,
                        onClick = onSearchClick
                    ),
                enabled = false,
                value = "",
                placeholder = "Search recipes",
                onValueChange = {}
            )
        }

        Text(
            modifier = Modifier
                .padding(bottom = 8.dp)
                .padding(horizontal = 16.dp),
            text = "My favourites",
            style = MaterialTheme.typography.titleLarge
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
internal fun FavouritesListScreenPreview() {
    AppTheme {
        FavouritesListView(
            modifier = Modifier.fillMaxSize(),
            onSearchClick = {},
            onRecipeClick = {},
        )
    }
}

