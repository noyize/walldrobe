package walldrobe.coffecode.com.ui.photo

import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.lazy.grid.GridCells
import androidx.compose.foundation.lazy.grid.GridItemSpan
import androidx.compose.foundation.lazy.grid.LazyHorizontalGrid
import androidx.compose.foundation.lazy.grid.items
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import walldrobe.coffecode.com.domain.model.Photo

@Composable
fun PhotoGrid(
    photos: List<Photo>,
    isLoading: Boolean,
    onPhotoClick: (Photo) -> Unit,
    modifier: Modifier = Modifier
) {
    if (isLoading) {
        PhotoGridLoading(
            modifier = modifier
                .fillMaxWidth()
                .padding(16.dp)
        )
    } else if (photos.isNotEmpty())
        LazyHorizontalGrid(
            modifier = modifier.fillMaxWidth().height(220.dp),
            rows = GridCells.Fixed(2),
            verticalArrangement = Arrangement.spacedBy(16.dp),
            horizontalArrangement = Arrangement.spacedBy(16.dp),
            contentPadding = PaddingValues(16.dp)
        ) {

            item(
                span = { GridItemSpan(maxLineSpan) }
            ) {
                PhotoGridItem(
                    modifier = Modifier
                        .size(180.dp)
                        .clickable {
                            onPhotoClick(photos[0])
                        },
                    photo = photos[0]
                )
            }
            items(photos.drop(1), key = { it.id }) { photo ->
                PhotoGridItem(
                    modifier = Modifier
                        .size(80.dp)
                        .clickable { onPhotoClick(photo) },
                    photo = photo
                )
            }
        }
}