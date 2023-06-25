package walldrobe.coffecode.com.ui.topic

import android.text.Html
import androidx.compose.foundation.layout.padding
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.outlined.ArrowBack
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material3.LargeTopAppBar
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.material3.TopAppBarDefaults
import androidx.compose.material3.TopAppBarScrollBehavior
import androidx.compose.material3.rememberTopAppBarState
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.input.nestedscroll.nestedScroll
import androidx.compose.ui.text.font.FontStyle
import androidx.hilt.navigation.compose.hiltViewModel
import androidx.paging.compose.collectAsLazyPagingItems
import com.ramcosta.composedestinations.annotation.Destination
import com.ramcosta.composedestinations.navigation.DestinationsNavigator
import walldrobe.coffecode.com.domain.model.Topic
import walldrobe.coffecode.com.ui.destinations.PhotoDetailScreenDestination
import walldrobe.coffecode.com.ui.photo.PagedPhotosList

@OptIn(ExperimentalMaterial3Api::class)
@Destination
@Composable
fun TopicDetailScreen(
    topic: Topic,
    viewModel: TopicDetailViewModel = hiltViewModel(),
    navigator: DestinationsNavigator
) {

    val photos = viewModel.topicPhotosPaging.collectAsLazyPagingItems()

    val scrollBehavior =
        TopAppBarDefaults.exitUntilCollapsedScrollBehavior(rememberTopAppBarState())



    Scaffold(topBar = {
        TopBar(title = topic.title, onBackPressed = {
            navigator.navigateUp()
        }, scrollBehavior = scrollBehavior)
    }, modifier = Modifier.nestedScroll(scrollBehavior.nestedScrollConnection)) {
        PagedPhotosList(
            photos = photos,
            onPhotoClicked = { photo ->
                navigator.navigate(PhotoDetailScreenDestination(photo = photo))
            },
            modifier = Modifier.padding(it),
            header = {
                Text(
                    text = Html.fromHtml(topic.description,Html.FROM_HTML_MODE_COMPACT).toString(),
                    style = MaterialTheme.typography.bodyLarge,
                    fontStyle = FontStyle.Italic,
                    color = MaterialTheme.colorScheme.onSurface.copy(alpha = 0.8f)
                )
            }
        )
    }
}

@OptIn(ExperimentalMaterial3Api::class)
@Composable
private fun TopBar(
    title: String,
    onBackPressed: () -> Unit,
    modifier: Modifier = Modifier,
    scrollBehavior: TopAppBarScrollBehavior
) {
    LargeTopAppBar(
        scrollBehavior = scrollBehavior,
        title = {
            Text(text = title)
        },
        navigationIcon = {
            IconButton(onClick = { onBackPressed() }) {
                Icon(imageVector = Icons.Outlined.ArrowBack, contentDescription = null)
            }
        },
        modifier = modifier
    )
}



