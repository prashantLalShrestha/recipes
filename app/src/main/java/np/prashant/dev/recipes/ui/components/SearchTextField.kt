package np.prashant.dev.recipes.ui.components

import androidx.compose.foundation.interaction.MutableInteractionSource
import androidx.compose.foundation.interaction.collectIsFocusedAsState
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Clear
import androidx.compose.material.icons.filled.Search
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.OutlinedTextField
import androidx.compose.material3.OutlinedTextFieldDefaults
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.remember
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.vector.ImageVector
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import np.prashant.dev.recipes.ui.theme.AppTheme

@Composable
fun SearchTextField(
    modifier: Modifier = Modifier,
    enabled: Boolean = true,
    value: String,
    leadingIcon: @Composable (() -> Unit)? = null,
    placeholder: String? = null,
    onValueChange: (String) -> Unit,
) {
    val source = remember { MutableInteractionSource() }
    val isFocused = source.collectIsFocusedAsState()

    OutlinedTextField(
        modifier = modifier,
        enabled = enabled,
        value = value,
        interactionSource = source,
        leadingIcon = leadingIcon ?: {
            Icon(
                modifier = Modifier.padding(start = 8.dp),
                imageVector = Icons.Default.Search,
                contentDescription = "Search Icon"
            )
        },
        trailingIcon = {
            if (isFocused.value) {
                IconButton(
                    modifier = Modifier.padding(end = 8.dp),
                    onClick = { /* Clear the search query */ },
                ) {
                    Icon(
                        imageVector = Icons.Default.Clear,
                        contentDescription = "Clear Icon"
                    )
                }
            }
        },
        onValueChange = onValueChange,
        placeholder = { Text(placeholder ?: "Search...") },
        singleLine = true,
        colors = OutlinedTextFieldDefaults.colors(
            focusedBorderColor = Color.Transparent,
            unfocusedBorderColor = Color.Transparent,
            disabledBorderColor = Color.Transparent,
            errorBorderColor = Color.Transparent,
        )
    )
}

@Preview
@Composable
internal fun SearchBarPreview() {
    AppTheme {
        SearchTextField(
            value = "",
            placeholder = "Search recipes",
            onValueChange = {}
        )
    }
}