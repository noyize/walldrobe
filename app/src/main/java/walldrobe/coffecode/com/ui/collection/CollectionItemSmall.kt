package walldrobe.coffecode.com.ui.collection

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.width
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.derivedStateOf
import androidx.compose.runtime.getValue
import androidx.compose.runtime.remember
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Brush
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.text.style.TextOverflow
import androidx.compose.ui.unit.dp
import coil.compose.AsyncImage
import walldrobe.coffecode.com.app.util.isDark
import walldrobe.coffecode.com.domain.model.Collection


@Composable
fun CollectionItemSmall(
    collection: Collection,
    modifier: Modifier = Modifier
) {

    val coverPhotoColor = remember {
        android.graphics.Color.parseColor(collection.color)
    }
    val backgroundColor by remember {
        derivedStateOf {
            Color(coverPhotoColor)
        }
    }
    val isDarkBackground by remember {
        derivedStateOf {
            isDark(coverPhotoColor)
        }
    }

    Box(
        modifier = modifier
            .width(180.dp)
            .height(220.dp)
            .clip(MaterialTheme.shapes.small)
    ) {

        AsyncImage(
            modifier = Modifier.fillMaxSize(),
            model = collection.coverPhoto,
            contentDescription = null,
            contentScale = ContentScale.Crop
        )
        Box(
            modifier = Modifier
                .fillMaxSize()
                .background(
                    brush = Brush.verticalGradient(
                        colors = listOf(
                            androidx.compose.ui.graphics.Color.Transparent,
                            backgroundColor,
                        )
                    )
                )
        )

        Column(
            modifier = Modifier
                .padding(16.dp)
                .align(Alignment.BottomCenter)
        ) {
            Text(
                modifier = Modifier.fillMaxWidth(),
                text = collection.title,
                style = MaterialTheme.typography.headlineSmall,
                color = if (isDarkBackground) Color.White else Color.Black,
                maxLines = 3,
                overflow = TextOverflow.Ellipsis,
            )
            Text(
                text = "${collection.totalPhotos} Photos",
                style = MaterialTheme.typography.bodySmall,
                color = if (isDarkBackground) Color.White else Color.Black
            )
        }
    }
}