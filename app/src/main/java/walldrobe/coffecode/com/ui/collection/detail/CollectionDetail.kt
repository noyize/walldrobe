package walldrobe.coffecode.com.ui.collection.detail

import androidx.compose.foundation.layout.padding
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.outlined.ArrowBack
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material3.LargeTopAppBar
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.material3.TopAppBarDefaults
import androidx.compose.material3.rememberTopAppBarState
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.input.nestedscroll.nestedScroll
import androidx.hilt.navigation.compose.hiltViewModel
import androidx.paging.compose.collectAsLazyPagingItems
import com.ramcosta.composedestinations.annotation.Destination
import com.ramcosta.composedestinations.navigation.DestinationsNavigator
import walldrobe.coffecode.com.domain.model.Collection
import walldrobe.coffecode.com.ui.destinations.PhotoDetailScreenDestination
import walldrobe.coffecode.com.ui.destinations.SearchScreenDestination
import walldrobe.coffecode.com.ui.photo.PagedPhotosList

@OptIn(ExperimentalMaterial3Api::class)
@Destination
@Composable
fun CollectionDetail(
    viewModel: CollectionDetailViewModel = hiltViewModel(),
    navigator: DestinationsNavigator,
    collection: Collection
) {
    val photos = viewModel.photos.collectAsLazyPagingItems()
    val scrollBehavior =
        TopAppBarDefaults.exitUntilCollapsedScrollBehavior(rememberTopAppBarState())


    Scaffold(
        topBar = {
            LargeTopAppBar(scrollBehavior = scrollBehavior,
                title = { Text(text = collection.title) },
                navigationIcon = {
                    IconButton(onClick = {
                        navigator.navigateUp()
                    }) {
                        Icon(
                            imageVector = Icons.Outlined.ArrowBack, contentDescription = null
                        )
                    }
                })
        },
        modifier = Modifier.nestedScroll(scrollBehavior.nestedScrollConnection)
    ) { padding ->
        PagedPhotosList(
            photos = photos,
            showHeaderLoading = false,
            onPhotoClicked = { photo ->
                navigator.navigate(PhotoDetailScreenDestination(photo = photo))
            },
            header = {
                CollectionHeader(collection = collection, onTagClick = {
                    navigator.navigate(SearchScreenDestination(query = it))
                })
            },
            modifier = Modifier.padding(padding)
        )
    }
}