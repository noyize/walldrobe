package walldrobe.coffecode.com.ui.photo.detail

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.lazy.LazyRow
import androidx.compose.foundation.lazy.items
import androidx.compose.material3.SuggestionChip
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import walldrobe.coffecode.com.domain.model.Photo

@Composable
fun Tags(photo: Photo, modifier: Modifier = Modifier, onTagClicked: (String) -> Unit) {
    LazyRow(
        modifier.fillMaxWidth(),
        horizontalArrangement = Arrangement.spacedBy(16.dp),
        contentPadding = PaddingValues(horizontal = 16.dp)
    ) {
        items(photo.tags) {
            SuggestionChip(
                onClick = { onTagClicked(it) },
                label = {
                    Text(text = it)
                },
            )
        }
    }
}