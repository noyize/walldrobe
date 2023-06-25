package walldrobe.coffecode.com.ui.search

import androidx.compose.animation.core.animateDpAsState
import androidx.compose.foundation.ExperimentalFoundationApi
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.pager.HorizontalPager
import androidx.compose.foundation.pager.rememberPagerState
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.outlined.ArrowBack
import androidx.compose.material.icons.outlined.Close
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.SearchBarDefaults
import androidx.compose.material3.Tab
import androidx.compose.material3.TabRow
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.rememberCoroutineScope
import androidx.compose.runtime.setValue
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.unit.dp
import androidx.hilt.navigation.compose.hiltViewModel
import androidx.paging.compose.collectAsLazyPagingItems
import com.ramcosta.composedestinations.annotation.Destination
import com.ramcosta.composedestinations.navigation.DestinationsNavigator
import kotlinx.coroutines.launch
import walldrobe.coffecode.com.R
import walldrobe.coffecode.com.ui.collection.PagedCollectionList
import walldrobe.coffecode.com.ui.destinations.CollectionDetailDestination
import walldrobe.coffecode.com.ui.destinations.PhotoDetailScreenDestination
import walldrobe.coffecode.com.ui.destinations.UserDetailDestination
import walldrobe.coffecode.com.ui.photo.PagedPhotosList
import walldrobe.coffecode.com.ui.user.PagedUserList


@OptIn(ExperimentalMaterial3Api::class, ExperimentalFoundationApi::class)
@Destination
@Composable
fun SearchScreen(
    viewModel: SearchViewModel = hiltViewModel(),
    navigator: DestinationsNavigator,
    query: String
) {
    val state = viewModel.uiState

    val tabs = listOf("Photos", "Collections", "Users")
    val pagerState = rememberPagerState {
        tabs.size
    }
    val tabIndex = pagerState.currentPage
    val coroutineScope = rememberCoroutineScope()


    var isActive by remember {
        mutableStateOf(false)
    }

    val animatedPadding by animateDpAsState(
        targetValue = if (isActive) 0.dp else 16.dp,
        label = "searchPadding"
    )


    val photos = state.photos.collectAsLazyPagingItems()
    val collections = state.collections.collectAsLazyPagingItems()
    val users = state.users.collectAsLazyPagingItems()

    Column {
        androidx.compose.material3.SearchBar(
            modifier = Modifier
                .fillMaxWidth()
                .padding(animatedPadding),
            colors = SearchBarDefaults.colors(
                dividerColor = Color.Transparent
            ),
            query = state.query,
            onQueryChange = {
                viewModel.updateQuery(it)
            },
            placeholder = {
                Text(text = stringResource(id = R.string.search_bar_hint))
            },
            onSearch = {
                isActive = false
                viewModel.search()
            },
            active = isActive,
            onActiveChange = {
                isActive = !isActive
            },
            leadingIcon = {
                IconButton(onClick = { navigator.navigateUp() }) {
                    Icon(imageVector = Icons.Outlined.ArrowBack, contentDescription = null)
                }
            },
            trailingIcon = {
                IconButton(onClick = {
                    if (state.query.isNotEmpty()) viewModel.updateQuery("") else isActive = false
                }) {
                    Icon(imageVector = Icons.Outlined.Close, contentDescription = null)
                }
            }
        ) {

        }
        Column(modifier = Modifier.fillMaxWidth()) {

            TabRow(selectedTabIndex = tabIndex) {
                tabs.forEachIndexed { index, title ->
                    Tab(text = { Text(title) },
                        selected = tabIndex == index,
                        onClick = {
                            coroutineScope.launch {
                                pagerState.animateScrollToPage(index)
                            }
                        }
                    )
                }
            }
            HorizontalPager(
                state = pagerState,
                modifier = Modifier.background(MaterialTheme.colorScheme.surface)
            ) { page ->
                when (page) {
                    0 -> {
                        PagedPhotosList(
                            photos = photos,
                            showHeaderLoading = false,
                            onPhotoClicked = {
                                navigator.navigate(PhotoDetailScreenDestination(photo = it))
                            })
                    }

                    1 -> {
                        PagedCollectionList(collections = collections, onCollectionClicked = {
                            navigator.navigate(CollectionDetailDestination(collection = it))
                        })
                    }

                    2 -> {
                        PagedUserList(users = users, onUserClicked = {
                            navigator.navigate(UserDetailDestination(user = it))
                        })
                    }
                }
            }
        }
    }

}