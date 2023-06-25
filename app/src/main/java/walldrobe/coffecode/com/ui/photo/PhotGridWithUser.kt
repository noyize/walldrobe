package walldrobe.coffecode.com.ui.photo


import android.widget.Toast
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.lazy.grid.GridCells
import androidx.compose.foundation.lazy.grid.LazyHorizontalGrid
import androidx.compose.foundation.lazy.grid.items
import androidx.compose.foundation.shape.CornerSize
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.MaterialTheme
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.unit.dp
import walldrobe.coffecode.com.R
import walldrobe.coffecode.com.ui.common.components.TitleHeader
import walldrobe.coffecode.com.app.util.shimmerEffect
import walldrobe.coffecode.com.domain.model.Photo

@Composable
fun PhotoGridWithUser(
    isLoading: Boolean,
    photos: List<Photo>,
    onPhotoClick: (Photo) -> Unit,
    modifier: Modifier = Modifier
) {

    if (isLoading) {
        PhotoGridWithUserLoading(
            modifier = Modifier
                .fillMaxWidth()
                .padding(top = 16.dp, bottom = 16.dp, start = 16.dp)
        )
    } else {
        Column(
            modifier = modifier
                .fillMaxWidth()
        ) {
            LazyHorizontalGrid(
                modifier = Modifier
                    .fillMaxWidth()
                    .height(352.dp),
                contentPadding = PaddingValues(16.dp),
                rows = GridCells.Fixed(2),
                verticalArrangement = Arrangement.spacedBy(16.dp),
                horizontalArrangement = Arrangement.spacedBy(16.dp)
            ) {
                items(photos, key = { it.id }) { photo ->
                    PhotoGridItemWithUser(photo = photo,
                        modifier = Modifier.clickable { onPhotoClick(photo) })
                }
            }
        }

    }

}



@Composable
private fun PhotoGridWithUserLoading(modifier: Modifier = Modifier) {
    Column(modifier = modifier) {
        Box(
            modifier = Modifier
                .width(120.dp)
                .height(20.dp)
                .clip(MaterialTheme.shapes.extraLarge)
                .shimmerEffect()
        )
        Spacer(modifier = Modifier.height(16.dp))
        Box(
            modifier = Modifier
                .width(320.dp)
                .height(12.dp)
                .clip(MaterialTheme.shapes.extraLarge)
                .shimmerEffect()
        )
        Spacer(modifier = Modifier.height(24.dp))
        Row(horizontalArrangement = Arrangement.spacedBy(16.dp)) {
            Box(
                modifier = Modifier
                    .size(120.dp)
                    .clip(MaterialTheme.shapes.small)
                    .shimmerEffect()
            )
            Box(
                modifier = Modifier
                    .size(120.dp)
                    .clip(MaterialTheme.shapes.small)
                    .shimmerEffect()
            )
            Box(
                modifier = Modifier
                    .size(120.dp)
                    .clip(
                        RoundedCornerShape(
                            topStart = MaterialTheme.shapes.small.topStart,
                            bottomStart = MaterialTheme.shapes.small.bottomStart,
                            topEnd = CornerSize(0),
                            bottomEnd = CornerSize(0)
                        )
                    )
                    .shimmerEffect()
            )
        }
        Spacer(modifier = Modifier.height(16.dp))
        Row(horizontalArrangement = Arrangement.spacedBy(16.dp)) {
            Box(
                modifier = Modifier
                    .size(120.dp)
                    .clip(MaterialTheme.shapes.small)
                    .shimmerEffect()
            )
            Box(
                modifier = Modifier
                    .size(120.dp)
                    .clip(MaterialTheme.shapes.small)
                    .shimmerEffect()
            )
            Box(
                modifier = Modifier
                    .size(120.dp)
                    .clip(
                        RoundedCornerShape(
                            topStart = MaterialTheme.shapes.small.topStart,
                            bottomStart = MaterialTheme.shapes.small.bottomStart,
                            topEnd = MaterialTheme.shapes.extraSmall.topEnd,
                            bottomEnd = MaterialTheme.shapes.extraSmall.bottomEnd
                        )
                    )
                    .shimmerEffect()
            )
        }
    }
}