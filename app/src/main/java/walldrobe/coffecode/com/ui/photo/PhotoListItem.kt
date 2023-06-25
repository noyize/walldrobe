package walldrobe.coffecode.com.ui.photo

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.aspectRatio
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.remember
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.text.style.TextOverflow
import androidx.compose.ui.unit.dp
import coil.compose.AsyncImage
import coil.request.CachePolicy
import coil.request.ImageRequest
import coil.size.Size
import walldrobe.coffecode.com.domain.model.Photo

@Composable
fun PhotoListItem(
    photo: Photo,
    modifier: Modifier = Modifier
) {
    val color = remember {
        Color(
            android.graphics.Color.parseColor(photo.color)
        )
    }
    val aspectRatio = remember {
        photo.width.toFloat()/photo.height.toFloat()
    }
    Column(modifier = modifier.fillMaxWidth()) {
        Row(
            verticalAlignment = Alignment.CenterVertically
        ) {
            AsyncImage(
                model = photo.user?.profileImageRegular,
                contentDescription = null,
                modifier = Modifier
                    .size(40.dp)
                    .clip(
                        CircleShape
                    ),
                contentScale = ContentScale.Crop
            )
            Spacer(modifier = Modifier.width(16.dp))
            Column {

                Text(
                    text = photo.user!!.name,
                    style = MaterialTheme.typography.titleSmall,
                    maxLines = 1,

                    overflow = TextOverflow.Ellipsis
                )
                Text(
                    text = photo.publishedOn,

                    style = MaterialTheme.typography.labelMedium
                )
            }
        }
        Spacer(modifier = Modifier.height(16.dp))


        AsyncImage(
            model = ImageRequest.Builder(LocalContext.current)
                .size(Size.ORIGINAL)
                .data(photo.regularUrl)
                .crossfade(true)
                .diskCachePolicy(CachePolicy.ENABLED)
                .memoryCachePolicy(CachePolicy.ENABLED)
                .allowHardware(true)
                .build(),
            contentDescription = null,
            modifier = Modifier
                .fillMaxWidth()
                .aspectRatio(aspectRatio)
                .clip(MaterialTheme.shapes.small)
                .background(color)
        )
    }

}