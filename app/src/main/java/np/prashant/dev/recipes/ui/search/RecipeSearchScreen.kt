package np.prashant.dev.recipes.ui.search

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.navigationBarsPadding
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.statusBarsPadding
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.automirrored.filled.ArrowBack
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material3.MaterialTheme
import androidx.compose.runtime.Composable
import androidx.compose.runtime.collectAsState
import androidx.compose.runtime.getValue
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.tooling.preview.PreviewParameter
import androidx.compose.ui.unit.dp
import androidx.hilt.navigation.compose.hiltViewModel
import np.prashant.dev.recipes.ui.common.components.RecipeListItem
import np.prashant.dev.recipes.ui.common.components.SearchTextField
import np.prashant.dev.recipes.ui.search.RecipeSearchAction.Navigation
import np.prashant.dev.recipes.ui.search.RecipeSearchAction.Search
import np.prashant.dev.recipes.ui.theme.AppTheme

@Composable
internal fun RecipeSearchScreen(
    modifier: Modifier = Modifier,
    viewModel: RecipeSearchViewModel = hiltViewModel(),
) {
    val state by viewModel.state.collectAsState()

    RecipeSearchView(
        modifier = modifier.fillMaxSize(),
        state = state,
        onAction = viewModel::trigger,
    )
}

@Composable
private fun RecipeSearchView(
    modifier: Modifier = Modifier,
    state: RecipeSearchState,
    onAction: (RecipeSearchAction) -> Unit,
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
            value = state.searchText ?: "",
            placeholder = "Search recipes",
            leadingIcon = {
                IconButton(
                    onClick = { onAction(Navigation.Back) },
                ) {
                    Icon(
                        imageVector = Icons.AutoMirrored.Filled.ArrowBack,
                        contentDescription = "Back Icon"
                    )
                }
            },
            onValueChange = { onAction(Search(it)) }
        )

        LazyColumn(
            modifier = Modifier
                .fillMaxSize()
                .navigationBarsPadding()
        ) {
            items(state.recipes) { recipe ->
                RecipeListItem(
                    modifier = Modifier
                        .fillMaxWidth()
                        .padding(top = 8.dp, start = 16.dp, bottom = 8.dp, end = 16.dp),
                    imageUrl = recipe.image,
                    title = recipe.title,
                    isFavourite = recipe.isFavourite,
                    onClick = { onAction(Navigation.RecipeDetail(recipe.id)) }
                )
            }
        }
    }
}

@Preview
@Composable
internal fun RecipeSearchScreenPreview(
    @PreviewParameter(RecipeSearchPreviewProvider::class) state: RecipeSearchState,
) {
    AppTheme {
        RecipeSearchView(
            modifier = Modifier.fillMaxSize(),
            state = state,
            onAction = {},
        )
    }
}