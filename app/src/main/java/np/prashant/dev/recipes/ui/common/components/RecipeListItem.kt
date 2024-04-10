package np.prashant.dev.recipes.ui.common.components

import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Favorite
import androidx.compose.material.icons.filled.FavoriteBorder
import androidx.compose.material3.Card
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.shadow
import androidx.compose.ui.graphics.Brush
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import coil.compose.AsyncImage
import np.prashant.dev.recipes.ui.theme.AppTheme

@Composable
fun RecipeListItem(
    modifier: Modifier = Modifier,
    imageUrl: String,
    title: String,
    isFavourite: Boolean,
    onClick: () -> Unit
) {
    Card(
        modifier = modifier
            .shadow(
                elevation = 8.dp,
                shape = MaterialTheme.shapes.medium,
                spotColor = MaterialTheme.colorScheme.primaryContainer,
                ambientColor = MaterialTheme.colorScheme.primaryContainer,
            )
            .clickable(onClick = onClick),
        shape = MaterialTheme.shapes.medium,
    ) {
        Box(
            modifier = Modifier
                .fillMaxWidth()
                .height(80.dp),
        ) {
            AsyncImage(
                model = imageUrl,
                contentScale = ContentScale.FillWidth,
                modifier = Modifier
                    .fillMaxSize()
                    .background(MaterialTheme.colorScheme.surface),
                contentDescription = "recipe_image_$imageUrl"
            )

            Box(
                Modifier
                    .background(
                        Brush.horizontalGradient(
                            colors = listOf(
                                Color.Transparent,
                                MaterialTheme.colorScheme.primaryContainer,
                            ),
                            startX = 700f,
                            endX = 0f,
                        )
                    )
                    .fillMaxSize(),
            )

            Row(
                modifier = Modifier
                    .padding(start = 32.dp, end = 16.dp)
                    .fillMaxSize(),
                verticalAlignment = Alignment.CenterVertically,
                horizontalArrangement = Arrangement.Absolute.SpaceBetween
            ) {
                Text(
                    text = title,
                    style = MaterialTheme.typography.titleMedium,
                    color = MaterialTheme.colorScheme.primary,
                )

                IconButton(
                    modifier = Modifier
                        .background(
                            color = MaterialTheme.colorScheme.primaryContainer.copy(alpha = 0.375f),
                            shape = MaterialTheme.shapes.extraLarge,
                        ),
                    onClick = {},
                ) {
                    Icon(
                        modifier = Modifier,
                        imageVector = if (isFavourite) Icons.Default.Favorite else Icons.Default.FavoriteBorder,
                        tint = MaterialTheme.colorScheme.onPrimaryContainer,
                        contentDescription = "Favourite Icon"
                    )
                }
            }
        }
    }
}


@Preview
@Composable
fun RecipeListItemPreview() {
    AppTheme {
        RecipeListItem(
            imageUrl = "https://spoonacular.com/recipeImages/756817-312x231.jpg",
            title = "Matcha Pancakes",
            isFavourite = true,
            onClick = {}
        )
    }
}