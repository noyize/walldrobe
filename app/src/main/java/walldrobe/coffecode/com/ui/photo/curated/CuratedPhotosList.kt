package walldrobe.coffecode.com.ui.photo.curated

import androidx.compose.foundation.layout.padding
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.outlined.ArrowBack
import androidx.compose.material.icons.outlined.Sort
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
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.font.FontStyle
import androidx.hilt.navigation.compose.hiltViewModel
import androidx.paging.compose.collectAsLazyPagingItems
import com.ramcosta.composedestinations.annotation.Destination
import com.ramcosta.composedestinations.navigation.DestinationsNavigator
import walldrobe.coffecode.com.R
import walldrobe.coffecode.com.ui.destinations.PhotoDetailScreenDestination
import walldrobe.coffecode.com.ui.photo.PagedPhotosList

@OptIn(ExperimentalMaterial3Api::class)
@Destination
@Composable
fun CuratedPhotosScreen(
    viewModel: CuratedPhotosViewModel = hiltViewModel(),
    navigator: DestinationsNavigator
) {

    val photos = viewModel.curatedPhotosPaging.collectAsLazyPagingItems()

    val scrollBehavior =
        TopAppBarDefaults.exitUntilCollapsedScrollBehavior(rememberTopAppBarState())

    Scaffold(
        topBar = {
            TopBar(scrollBehavior = scrollBehavior, onBackPressed = {
                navigator.navigateUp()
            })

        },
        modifier = Modifier.nestedScroll(scrollBehavior.nestedScrollConnection)
    ) {
        PagedPhotosList(
            photos = photos,
            onPhotoClicked = { photo ->
                navigator.navigate(PhotoDetailScreenDestination(photo = photo))
            },
            modifier = Modifier.padding(it),
            header = {
                Text(
                    text = stringResource(id = R.string.curated_photos_description),
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
    scrollBehavior: TopAppBarScrollBehavior,
    onBackPressed: () -> Unit,
    modifier: Modifier = Modifier
) {
    LargeTopAppBar(
        title = {
            Text(text = stringResource(id = R.string.curated))
        },
        scrollBehavior = scrollBehavior,
        navigationIcon = {
            IconButton(onClick = { onBackPressed() }) {
                Icon(imageVector = Icons.Outlined.ArrowBack, contentDescription = null)
            }
        },
        actions = {
            IconButton(onClick = { /*TODO*/ }) {
                Icon(imageVector = Icons.Outlined.Sort, contentDescription = null)
            }
        },
        modifier = modifier
    )
}
