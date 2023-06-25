package walldrobe.coffecode.com.ui.dashboard

import android.widget.Toast
import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
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
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.lazy.LazyRow
import androidx.compose.foundation.lazy.items
import androidx.compose.foundation.lazy.rememberLazyListState
import androidx.compose.foundation.shape.CornerSize
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.runtime.derivedStateOf
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Brush
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.style.TextOverflow
import androidx.compose.ui.unit.dp
import coil.compose.AsyncImage
import coil.request.CachePolicy
import coil.request.ImageRequest
import walldrobe.coffecode.com.R
import walldrobe.coffecode.com.ui.common.components.TitleHeader
import walldrobe.coffecode.com.app.util.isDark
import walldrobe.coffecode.com.app.util.shimmerEffect
import walldrobe.coffecode.com.domain.model.Topic

@Composable
fun Topics(
    isLoading: Boolean,
    error: String?,
    topics: List<Topic>,
    onTopicClocked:(Topic) -> Unit,
    modifier: Modifier = Modifier
) {
    val context = LocalContext.current
    LaunchedEffect(error) {
        if (error.isNullOrEmpty().not())
            Toast.makeText(context, error, Toast.LENGTH_SHORT).show()
    }

    if (isLoading) {
        TopicsLoading(
            modifier = Modifier
                .fillMaxWidth()
                .padding(top = 16.dp, bottom = 16.dp, start = 16.dp)
        )
    } else if (error.isNullOrBlank()) {

        val scrollState = rememberLazyListState()
        var scrollToEnd by remember {
            mutableStateOf(false)
        }
        LaunchedEffect(scrollToEnd){
            if (scrollToEnd) {
                scrollState.animateScrollToItem(topics.size)
                scrollToEnd = false
            }

        }

        Column(modifier = modifier.fillMaxWidth()) {
            TitleHeader(
                title = stringResource(id = R.string.topics),
                subtitle = stringResource(id = R.string.topics_description),
                onMoreClick = {
                   scrollToEnd = true
                },
                isMoreIconOnly = true
            )

            LazyRow(
                state = scrollState,
                modifier = Modifier.fillMaxWidth(),
                contentPadding = PaddingValues(16.dp),
                horizontalArrangement = Arrangement.spacedBy(16.dp)
            ) {
                items(topics) { topic ->
                    TopicItem(topic = topic, modifier = Modifier.clickable {
                        onTopicClocked(topic)
                    })
                }
            }
        }
    }
}

@Composable
fun TopicItem(
    topic: Topic,
    modifier: Modifier = Modifier
) {

    val coverPhotoColor = remember {
        android.graphics.Color.parseColor(topic.color)
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
            .width(240.dp)
            .height(320.dp)
            .clip(MaterialTheme.shapes.small)
    ) {

        AsyncImage(
            modifier = Modifier.fillMaxSize(),
            model = ImageRequest.Builder(LocalContext.current)
                .data(topic.coverPhoto)
                .crossfade(true)
                .diskCachePolicy(CachePolicy.ENABLED)
                .memoryCachePolicy(CachePolicy.ENABLED)
                .allowHardware(true)
                .build(),
            contentDescription = null,
            contentScale = ContentScale.Crop
        )
        Box(
            modifier = Modifier
                .fillMaxSize()
                .background(
                    brush = Brush.verticalGradient(
                        colors = listOf(
                            Color.Transparent,
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
                text = topic.title,
                style = MaterialTheme.typography.headlineSmall,
                color = if (isDarkBackground) Color.White else Color.Black
            )
            Text(
                text = topic.description,
                style = MaterialTheme.typography.bodySmall,
                maxLines = 3,
                overflow = TextOverflow.Ellipsis,
                color = if (isDarkBackground) Color.White else Color.Black
            )
        }
    }
}

@Composable
private fun TopicsLoading(modifier: Modifier = Modifier) {
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
        Row(modifier = Modifier.fillMaxWidth()) {
            Box(
                modifier = Modifier
                    .width(240.dp)
                    .height(320.dp)
                    .clip(MaterialTheme.shapes.small)
                    .shimmerEffect()
            )
            Spacer(modifier = Modifier.width(16.dp))
            Box(
                modifier = Modifier
                    .weight(1f)
                    .height(320.dp)
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
    }
}