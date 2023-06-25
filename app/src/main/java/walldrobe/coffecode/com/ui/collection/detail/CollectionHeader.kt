package walldrobe.coffecode.com.ui.collection.detail

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.lazy.LazyRow
import androidx.compose.foundation.lazy.items
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.SuggestionChip
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.text.font.FontStyle
import androidx.compose.ui.unit.dp
import walldrobe.coffecode.com.domain.model.Collection
import walldrobe.coffecode.com.ui.common.components.UserBadge

@Composable
fun CollectionHeader(
    collection: Collection,
    onTagClick: (String) -> Unit,
    modifier: Modifier = Modifier
) {
    Column(
        modifier = modifier.fillMaxWidth()
    ) {
        Text(text = "${collection.totalPhotos} Photos", style = MaterialTheme.typography.labelLarge)

            Text(
                text = "Curated by ${collection.username}",
                style = MaterialTheme.typography.labelLarge
            )

        if (collection.description.isNotEmpty())
            Text(
                text = collection.description,
                style = MaterialTheme.typography.bodyLarge,
                fontStyle = FontStyle.Italic,
                color = MaterialTheme.colorScheme.onSurface.copy(alpha = 0.8f)
            )

        LazyRow(
            modifier = Modifier.fillMaxWidth(),
            horizontalArrangement = Arrangement.spacedBy(16.dp)
        ) {
            items(collection.tags) {
                SuggestionChip(
                    onClick = { onTagClick(it) },
                    label = {
                        Text(text = it)
                    },
                )
            }
        }
    }
}