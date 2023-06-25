package walldrobe.coffecode.com.ui.collection

import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.LazyRow
import androidx.compose.foundation.lazy.items
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import walldrobe.coffecode.com.domain.model.Collection

@Composable
fun CollectionListSmall(
    collections: List<Collection>,
    modifier: Modifier = Modifier,
    title: String? = null,
    onCollectionClick: (Collection) -> Unit
) {
    Column(modifier = modifier) {
        if (title != null)
            Text(
                text = title,
                style = MaterialTheme.typography.titleMedium,
                modifier = Modifier.padding(horizontal = 16.dp)
            )
        if (collections.isNotEmpty())
            LazyRow(
                modifier = Modifier.fillMaxWidth(),
                contentPadding = PaddingValues(16.dp),
                horizontalArrangement = Arrangement.spacedBy(16.dp)
            ) {
                items(collections) { relatedCollection ->
                    CollectionItemSmall(
                        collection = relatedCollection,
                        modifier = Modifier.clickable { onCollectionClick(relatedCollection) })
                }
            }
    }
}