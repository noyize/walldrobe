package walldrobe.coffecode.com.ui.photo.detail

import androidx.compose.animation.AnimatedVisibility
import androidx.compose.animation.core.LinearOutSlowInEasing
import androidx.compose.animation.core.animateFloatAsState
import androidx.compose.animation.core.tween
import androidx.compose.animation.expandVertically
import androidx.compose.animation.fadeIn
import androidx.compose.animation.fadeOut
import androidx.compose.animation.shrinkVertically
import androidx.compose.foundation.ExperimentalFoundationApi
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.aspectRatio
import androidx.compose.foundation.layout.calculateEndPadding
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.navigationBarsPadding
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.verticalScroll
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.outlined.ArrowBack
import androidx.compose.material.icons.outlined.MoreVert
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material3.LinearProgressIndicator
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Scaffold
import androidx.compose.material3.TopAppBar
import androidx.compose.material3.TopAppBarDefaults
import androidx.compose.material3.TopAppBarScrollBehavior
import androidx.compose.material3.rememberTopAppBarState
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.remember
import androidx.compose.ui.Alignment.Companion.CenterHorizontally
import androidx.compose.ui.Modifier
import androidx.compose.ui.input.nestedscroll.nestedScroll
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.unit.LayoutDirection
import androidx.compose.ui.unit.dp
import androidx.hilt.navigation.compose.hiltViewModel
import coil.compose.AsyncImage
import coil.request.CachePolicy
import coil.request.ImageRequest
import coil.size.Size
import com.ramcosta.composedestinations.annotation.Destination
import com.ramcosta.composedestinations.navigation.DestinationsNavigator
import walldrobe.coffecode.com.domain.model.Photo
import walldrobe.coffecode.com.ui.collection.CollectionListSmall
import walldrobe.coffecode.com.ui.destinations.CollectionDetailDestination
import walldrobe.coffecode.com.ui.destinations.SearchScreenDestination
import walldrobe.coffecode.com.ui.destinations.UserDetailDestination


@OptIn(ExperimentalMaterial3Api::class, ExperimentalFoundationApi::class)
@Destination
@Composable
fun PhotoDetailScreen(
    photo: Photo,
    viewModel: PhotoDetailViewModel = hiltViewModel(),
    navigator: DestinationsNavigator
) {

    val state = viewModel.uiState

    if (state.error.isNullOrEmpty()) {

        val scrollBehavior =
            TopAppBarDefaults.exitUntilCollapsedScrollBehavior(rememberTopAppBarState())

        Scaffold(modifier = Modifier
            .fillMaxSize()
            .nestedScroll(scrollBehavior.nestedScrollConnection),
            topBar = {
                TopBar(scrollBehavior = scrollBehavior, onBackPressed = {
                    navigator.navigateUp()
                })
            }) {
            PhotoDetailContent(
                state = state,
                photo = photo,
                event = { event ->
                    when (event) {
                        is PhotoDetailEvent.OnBackPressed -> {
                            navigator.navigateUp()
                        }

                        is PhotoDetailEvent.OnRelatedCollectionClicked -> {
                            navigator.navigate(
                                CollectionDetailDestination(
                                    collection = event.relatedCollection
                                )
                            )
                        }

                        is PhotoDetailEvent.OnTagClicked -> {
                            navigator.navigate(SearchScreenDestination(query = event.query))
                        }

                        is PhotoDetailEvent.OnUserClicked -> {
                            navigator.navigate(UserDetailDestination(user = event.user))
                        }
                    }
                },
                modifier = Modifier
                    .fillMaxSize()
                    .padding(
                        start = it.calculateRightPadding(LayoutDirection.Ltr),
                        end = it.calculateEndPadding(LayoutDirection.Ltr),
                        bottom = it.calculateBottomPadding()
                    )
                    .verticalScroll(rememberScrollState())
            )

        }

    }


}

@Composable
fun PhotoDetailContent(
    state: PhotoDetailState,
    photo: Photo,
    event: (PhotoDetailEvent) -> Unit,
    modifier: Modifier = Modifier
) {

    val aspectRatio = remember {
        photo.width.toFloat() / photo.height.toFloat()
    }
    Column(
        modifier = modifier
    ) {
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
                .align(CenterHorizontally)
                .aspectRatio(aspectRatio)


        )
        AnimatedVisibility(state.isPhotoLoading) {
            LinearProgressIndicator(
                color = MaterialTheme.colorScheme.primary,
                modifier = Modifier
                    .fillMaxWidth()
                    .align(CenterHorizontally)
            )
        }
        AnimatedVisibility(
            visible = !state.isPhotoLoading && state.photo != null,
            enter = expandVertically(
                animationSpec = tween(
                    500,
                    easing = LinearOutSlowInEasing
                )
            ) + fadeIn(),
            exit = fadeOut() + shrinkVertically(),
        ) {
            if (state.photo != null) {
                Details(
                    photo = state.photo,
                    modifier = Modifier
                        .fillMaxWidth()
                        .navigationBarsPadding(),
                    event = event
                )
            }
        }
    }

}

@Composable
private fun Details(
    photo: Photo,
    modifier: Modifier = Modifier,
    event: (PhotoDetailEvent) -> Unit
) {
    Column(
        modifier = modifier,
        verticalArrangement = Arrangement.spacedBy(32.dp)
    ) {
        Spacer(modifier = Modifier.height(4.dp))
        UserLayout(
            photo = photo,
            onUserClicked = {
                event(PhotoDetailEvent.OnUserClicked(it))
            },
            modifier = Modifier.padding(horizontal = 16.dp)
        )
        if (photo.description.isNotEmpty())
            Description(photo = photo, modifier = Modifier.padding(horizontal = 16.dp))
        if (photo.location.isNotEmpty())
            Location(photo = photo, modifier = Modifier.padding(horizontal = 16.dp))
        Stats(photo = photo, modifier = Modifier.padding(horizontal = 24.dp))
        if (photo.tags.isNotEmpty())
            Tags(photo = photo, onTagClicked = {
                event(PhotoDetailEvent.OnTagClicked(query = it))
            })
        if (photo.relatedCollections.isNotEmpty())
            CollectionListSmall(
                collections = photo.relatedCollections,
                title = "Related Collections",
                onCollectionClick = {
                    event(PhotoDetailEvent.OnRelatedCollectionClicked(it))
                })
        Exif(photo = photo)
    }
}


@OptIn(ExperimentalMaterial3Api::class)
@Composable
private fun TopBar(scrollBehavior: TopAppBarScrollBehavior, onBackPressed: () -> Unit) {


    val topBarAlpha by animateFloatAsState(
        targetValue = scrollBehavior.state.collapsedFraction,
        label = "topBarAlpha",

        )
    TopAppBar(
        scrollBehavior = scrollBehavior,
        title = { /*TODO*/ },
        navigationIcon = {
            IconButton(onClick = { onBackPressed() }) {
                Icon(
                    imageVector = Icons.Outlined.ArrowBack,
                    contentDescription = null,

                    )
            }
        },
        actions = {
            IconButton(onClick = { /*TODO*/ }) {
                Icon(
                    imageVector = Icons.Outlined.MoreVert,
                    contentDescription = null,

                    )
            }
        },
        modifier = Modifier,
        colors = TopAppBarDefaults.smallTopAppBarColors(
            containerColor =
            MaterialTheme.colorScheme.surface.copy(alpha = topBarAlpha)

        )
    )
}


