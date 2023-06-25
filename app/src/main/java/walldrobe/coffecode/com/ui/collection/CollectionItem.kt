package walldrobe.coffecode.com.ui.collection

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.lazy.LazyRow
import androidx.compose.foundation.lazy.items
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.outlined.Tag
import androidx.compose.material3.AssistChip
import androidx.compose.material3.Card
import androidx.compose.material3.CardDefaults
import androidx.compose.material3.Icon
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.SuggestionChip
import androidx.compose.material3.SuggestionChipDefaults
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
import walldrobe.coffecode.com.ui.common.components.UserBadge

@Composable
fun CollectionItem(
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
            .fillMaxWidth()
            .height(280.dp)
            .clip(MaterialTheme.shapes.small)
    ) {

        val textColor = remember {
            if (isDarkBackground) Color.White else Color.Black
        }

        AsyncImage(
            model = collection.coverPhoto,
            contentDescription = null,
            modifier = Modifier
                .fillMaxSize()
                .background(backgroundColor),
            contentScale = ContentScale.Crop
        )

        Box(
            modifier = Modifier
                .fillMaxSize()
                .background(
                    brush = Brush.linearGradient(
                        colors = listOf(
                            Color.Transparent,
                            backgroundColor
                        )
                    )
                )
        )

        UserBadge(
            username = collection.username,
            avatar = collection.userImage,
            color = backgroundColor,
            textColor = textColor,
            modifier = Modifier
                .padding(16.dp)
                .align(Alignment.TopStart)
        )

        Details(
            title = collection.title,
            totalPhotos = collection.totalPhotos,
            description = collection.description,
            tags = collection.tags,
            textColor = textColor,
            modifier = Modifier
                .align(Alignment.BottomCenter)
        )
    }
}



@Composable
private fun Details(
    title: String,
    totalPhotos: String,
    description: String,
    tags: List<String>,
    textColor: Color,
    modifier: Modifier = Modifier
) {

    Column(modifier = modifier.fillMaxWidth()) {

        Column(modifier = Modifier.padding(horizontal = 16.dp)) {
            Text(
                text = title,
                style = MaterialTheme.typography.headlineSmall,
                color = textColor
            )
            Text(
                text = "$totalPhotos Photos",
                style = MaterialTheme.typography.labelMedium,
                color = textColor
            )
            if (description.isNotEmpty())
                Text(
                    text = description,
                    style = MaterialTheme.typography.bodyMedium,
                    maxLines = 3,
                    overflow = TextOverflow.Ellipsis,
                    color = textColor
                )
        }


        LazyRow(
            modifier = Modifier.fillMaxWidth(),
            horizontalArrangement = Arrangement.spacedBy(8.dp),
            contentPadding = PaddingValues(16.dp)
        ) {
            item {
                Icon(
                    imageVector = Icons.Outlined.Tag,
                    contentDescription = null,
                    tint = textColor.copy(alpha = 0.6f),
                    modifier = Modifier.size(16.dp)
                )
            }
            items(tags) {
                Text(
                    text = it,
                    color = textColor.copy(alpha = 0.6f),
                    style = MaterialTheme.typography.labelSmall
                )
            }
        }
    }
}