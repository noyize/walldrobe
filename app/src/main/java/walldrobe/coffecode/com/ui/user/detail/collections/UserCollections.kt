package walldrobe.coffecode.com.ui.user.detail.collections

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
import androidx.compose.ui.res.stringResource
import androidx.hilt.navigation.compose.hiltViewModel
import androidx.paging.compose.collectAsLazyPagingItems
import com.ramcosta.composedestinations.annotation.Destination
import com.ramcosta.composedestinations.navigation.DestinationsNavigator
import walldrobe.coffecode.com.R
import walldrobe.coffecode.com.ui.collection.PagedCollectionList
import walldrobe.coffecode.com.ui.destinations.CollectionDetailDestination

@OptIn(ExperimentalMaterial3Api::class)
@Composable
@Destination
fun UserCollections(
    username: String,
    navigator: DestinationsNavigator,
    viewModel: UserCollectionsViewModel = hiltViewModel()
) {
    val scrollBehavior =
        TopAppBarDefaults.exitUntilCollapsedScrollBehavior(rememberTopAppBarState())

    val collections = viewModel.collections.collectAsLazyPagingItems()
    Scaffold(topBar = {
        LargeTopAppBar(
            scrollBehavior = scrollBehavior,
            title = { Text(text = stringResource(id = R.string.collections)) },
            navigationIcon = {
                IconButton(onClick = { navigator.navigateUp() }) {
                    Icon(imageVector = Icons.Outlined.ArrowBack, contentDescription = null)
                }
            })
    }, modifier = Modifier.nestedScroll(scrollBehavior.nestedScrollConnection)) {
        PagedCollectionList(
            collections = collections,
            onCollectionClicked = {
                navigator.navigate(CollectionDetailDestination(collection = it))
            },
            modifier = Modifier.padding(it)
        )
    }
}