package walldrobe.coffecode.com.ui.dashboard

import androidx.compose.animation.AnimatedVisibility
import androidx.compose.animation.Crossfade
import androidx.compose.animation.core.animateDpAsState
import androidx.compose.animation.fadeIn
import androidx.compose.animation.fadeOut
import androidx.compose.animation.slideInVertically
import androidx.compose.animation.slideOutVertically
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.calculateEndPadding
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.foundation.verticalScroll
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.AccountCircle
import androidx.compose.material.icons.outlined.Add
import androidx.compose.material.icons.outlined.Close
import androidx.compose.material.icons.outlined.FavoriteBorder
import androidx.compose.material.icons.outlined.RestartAlt
import androidx.compose.material.icons.outlined.Tune
import androidx.compose.material3.BottomAppBar
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.FloatingActionButton
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Scaffold
import androidx.compose.material3.SearchBarDefaults
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.derivedStateOf
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.draw.shadow
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.unit.LayoutDirection
import androidx.compose.ui.unit.dp
import androidx.hilt.navigation.compose.hiltViewModel
import coil.compose.AsyncImage
import com.ramcosta.composedestinations.annotation.Destination
import com.ramcosta.composedestinations.annotation.RootNavGraph
import com.ramcosta.composedestinations.navigation.DestinationsNavigator
import walldrobe.coffecode.com.R
import walldrobe.coffecode.com.ui.destinations.CuratedPhotosScreenDestination
import walldrobe.coffecode.com.ui.destinations.LatestPhotosScreenDestination
import walldrobe.coffecode.com.ui.destinations.PhotoDetailScreenDestination
import walldrobe.coffecode.com.ui.destinations.SearchScreenDestination
import walldrobe.coffecode.com.ui.destinations.TopicDetailScreenDestination
import walldrobe.coffecode.com.ui.photo.PhotoGridWithUser

@OptIn(ExperimentalMaterial3Api::class)
@Destination
@RootNavGraph(start = true)
@Composable
fun Dashboard(
    viewModel: DashboardViewModel = hiltViewModel(),
    navigator: DestinationsNavigator
) {

    val state by viewModel.uiState
    val scrollState = rememberScrollState()

    val topBarBackgroundAlpha by remember {
        derivedStateOf {
            if (scrollState.value != 0) {
                val alpha = (scrollState.value.toFloat() / scrollState.maxValue) * 10
                if (alpha <= 0) 0f
                else if (alpha > 1f) 1f
                else alpha
            } else 0f


        }
    }


    var isSearchActive by remember {
        mutableStateOf(false)
    }

    var query by remember {
        mutableStateOf("")
    }

    Scaffold(
        modifier = Modifier.fillMaxSize(),
        topBar = {
            Search(
                modifier = Modifier
                    .background(
                        MaterialTheme.colorScheme.surface.copy(
                            alpha = topBarBackgroundAlpha
                        )
                    )
                    .shadow(
                        topBarBackgroundAlpha.dp
                    ),
                query = query,
                profileImageUrl = null,
                isActive = isSearchActive,
                onQueryChange = { query = it },
                onActiveChange = {
                    isSearchActive = it
                },
                onSearch = {
                    navigator.navigate(SearchScreenDestination(query = it))
                },
                onClearClick = {
                    if (query.isNotEmpty()) query = "" else isSearchActive = false
                },
            )
        },
        bottomBar = {
            AnimatedVisibility(
                visible = !isSearchActive,
                enter = fadeIn() + slideInVertically(initialOffsetY = { fullHeight ->
                    -fullHeight / 2
                }),
                exit = slideOutVertically(targetOffsetY = { fullHeight ->
                    fullHeight / 2
                }) + fadeOut()
            ) {
                BottomBar()
            }
        },
        content = { paddingValues ->
            DashboardContent(
                modifier = Modifier
                    .padding(
                        start = paddingValues.calculateLeftPadding(LayoutDirection.Ltr),
                        end = paddingValues.calculateEndPadding(LayoutDirection.Ltr),
                        bottom = paddingValues.calculateBottomPadding()
                    )
                    .verticalScroll(scrollState),
                state = state,
                onEvent = { event ->
                    when (event) {
                        is DashboardEvent.NavigateToCuratedPhotos -> {
                            navigator.navigate(CuratedPhotosScreenDestination())
                        }

                        is DashboardEvent.NavigateToLatestPhotos -> {
                            navigator.navigate(LatestPhotosScreenDestination)
                        }

                        is DashboardEvent.OnPhotoClicked -> {
                            navigator.navigate(PhotoDetailScreenDestination(photo = event.photo))
                        }

                        is DashboardEvent.OnTopicClick -> {
                            navigator.navigate(TopicDetailScreenDestination(topic = event.topic))
                        }
                    }
                }
            )
        }
    )
}


@Composable
private fun DashboardContent(
    state: DashboardUiState,
    onEvent: (DashboardEvent) -> Unit,
    modifier: Modifier = Modifier
) {

    Column(modifier = modifier) {
        Banners(
            isLoading = state.isBannerPhotosLoading,
            error = state.bannerPhotosError,
            bannerPhotos = state.bannerPhotos,
            onPhotoClick = { photo ->
                onEvent(
                    DashboardEvent.OnPhotoClicked(photo)
                )
            },
        )
        LatestPhotos(
            isLoading = state.isLatestPhotosLoading,
            error = state.latestPhotosError,
            latestPhotos = state.latestPhotos,
            onPhotoClick = { photo ->
                onEvent(
                    DashboardEvent.OnPhotoClicked(photo)
                )
            },
            onMoreClick = {
                onEvent(DashboardEvent.NavigateToLatestPhotos)
            }
        )
        Topics(
            isLoading = state.isTopicsLoading,
            error = state.topicsError,
            topics = state.topics,
            onTopicClocked = { topic ->
                onEvent(
                    DashboardEvent.OnTopicClick(
                        topic = topic
                    )
                )
            }
        )
        CuratedPhotos(
            isLoading = state.isCuratedPhotosLoading,
            error = state.curatedPhotosError,
            photos = state.curatedPhotos,
            onPhotoClick = { photo ->
                onEvent(
                    DashboardEvent.OnPhotoClicked(photo)
                )
            },
            onMoreClick = {
                onEvent(DashboardEvent.NavigateToCuratedPhotos)
            }
        )
    }
}

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun Search(
    query: String,
    profileImageUrl: String?,
    onQueryChange: (String) -> Unit,
    isActive: Boolean,
    onActiveChange: (Boolean) -> Unit,
    onSearch: (String) -> Unit,
    onClearClick: () -> Unit,
    modifier: Modifier = Modifier
) {


    val animatedPadding by animateDpAsState(
        targetValue = if (isActive) 0.dp else 16.dp,
        label = "searchPadding"
    )

    Box(modifier = modifier) {

        androidx.compose.material3.SearchBar(
            modifier = Modifier
                .fillMaxWidth()
                .padding(
                    start = animatedPadding,
                    end = animatedPadding,
                    bottom = animatedPadding
                ),
            colors = SearchBarDefaults.colors(
                dividerColor = MaterialTheme.colorScheme.primary
            ),
            query = query,
            onQueryChange = onQueryChange,
            onSearch = onSearch,
            active = isActive,
            onActiveChange = onActiveChange,
            placeholder = {
                Text(text = stringResource(id = R.string.search_bar_hint))
            },
            leadingIcon = {
                Icon(
                    painter = painterResource(id = R.drawable.bx_search),
                    contentDescription = null
                )

            },
            trailingIcon = {
                Crossfade(targetState = isActive, label = "searchTrailingIcon") { active ->
                    if (!active) {
                        if (profileImageUrl != null) {
                            IconButton(onClick = { /*TODO*/ }) {
                                AsyncImage(
                                    modifier = Modifier
                                        .size(28.dp)
                                        .clip(CircleShape),
                                    model = profileImageUrl,
                                    contentDescription = null,
                                    contentScale = ContentScale.Crop
                                )
                            }
                        } else {
                            IconButton(onClick = onClearClick) {
                                Icon(
                                    modifier = Modifier.size(28.dp),
                                    imageVector = Icons.Default.AccountCircle,
                                    contentDescription = null
                                )
                            }
                        }
                    } else {
                        IconButton(onClick = onClearClick) {
                            Icon(imageVector = Icons.Outlined.Close, contentDescription = null)
                        }
                    }
                }

            }
        ) {

        }

    }
}

@Composable
fun BottomBar(modifier: Modifier = Modifier) {
    BottomAppBar(
        modifier = modifier,
        floatingActionButton = {
            FloatingActionButton(onClick = { /*TODO*/ }) {
                Icon(
                    imageVector = Icons.Outlined.Add,
                    contentDescription = null
                )
            }
        },
        actions = {
            IconButton(onClick = { /*TODO*/ }) {
                Icon(imageVector = Icons.Outlined.Tune, contentDescription = null)
            }
            IconButton(onClick = { /*TODO*/ }) {
                Icon(imageVector = Icons.Outlined.RestartAlt, contentDescription = null)
            }
            IconButton(onClick = { /*TODO*/ }) {
                Icon(imageVector = Icons.Outlined.FavoriteBorder, contentDescription = null)
            }
        }
    )
}

