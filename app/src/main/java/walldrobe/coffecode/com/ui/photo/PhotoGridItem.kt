package walldrobe.coffecode.com.ui.photo

import androidx.compose.foundation.background
import androidx.compose.material3.MaterialTheme
import androidx.compose.runtime.Composable
import androidx.compose.runtime.remember
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.platform.LocalContext
import coil.compose.AsyncImage
import coil.request.CachePolicy
import coil.request.ImageRequest
import walldrobe.coffecode.com.domain.model.Photo

@Composable
fun PhotoGridItem(
    photo: Photo,
    modifier: Modifier = Modifier
) {
    val color = remember {
        Color(
            android.graphics.Color.parseColor(photo.color)
        )
    }

    AsyncImage(
        modifier = modifier
            .clip(MaterialTheme.shapes.small)
            .background(color),
        model = ImageRequest.Builder(LocalContext.current)
            .data(photo.regularUrl)
            .crossfade(true)
            .diskCachePolicy(CachePolicy.ENABLED)
            .memoryCachePolicy(CachePolicy.ENABLED)
            .allowHardware(true)
            .build(),
        contentDescription = null,
        contentScale = ContentScale.Crop,
    )
}