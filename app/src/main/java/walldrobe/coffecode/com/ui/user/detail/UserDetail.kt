package walldrobe.coffecode.com.ui.user.detail

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.foundation.verticalScroll
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Public
import androidx.compose.material.icons.outlined.ArrowBack
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.MediumTopAppBar
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.material3.TopAppBar
import androidx.compose.material3.TopAppBarDefaults
import androidx.compose.material3.rememberTopAppBarState
import androidx.compose.runtime.Composable
import androidx.compose.runtime.remember
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.input.nestedscroll.nestedScroll
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.font.FontStyle
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.dp
import androidx.hilt.navigation.compose.hiltViewModel
import coil.compose.AsyncImage
import com.ramcosta.composedestinations.annotation.Destination
import com.ramcosta.composedestinations.navigation.DestinationsNavigator
import walldrobe.coffecode.com.R
import walldrobe.coffecode.com.domain.model.User
import walldrobe.coffecode.com.ui.collection.CollectionListSmall
import walldrobe.coffecode.com.ui.common.components.TitleHeader
import walldrobe.coffecode.com.ui.destinations.CollectionDetailDestination
import walldrobe.coffecode.com.ui.destinations.PhotoDetailScreenDestination
import walldrobe.coffecode.com.ui.destinations.UserCollectionsDestination
import walldrobe.coffecode.com.ui.destinations.UserLikesDestination
import walldrobe.coffecode.com.ui.destinations.UserPhotosDestination
import walldrobe.coffecode.com.ui.photo.PhotoGrid
import walldrobe.coffecode.com.ui.photo.PhotoGridWithUser

@OptIn(ExperimentalMaterial3Api::class)
@Composable
@Destination
fun UserDetail(
    user: User,
    navigator: DestinationsNavigator,
    viewModel: UserDetailViewModel = hiltViewModel()
) {

    val scrollState = rememberScrollState()

    val scrollBehavior =
        TopAppBarDefaults.pinnedScrollBehavior(rememberTopAppBarState())

    Scaffold(
        topBar = {
            TopAppBar(
                scrollBehavior=scrollBehavior,
                title = {
                    Text(
                        text = user.username,
                        style = MaterialTheme.typography.titleMedium
                    )
                },
                navigationIcon = {
                    IconButton(onClick = { navigator.navigateUp() }) {
                        Icon(imageVector = Icons.Outlined.ArrowBack, contentDescription = null)
                    }
                }
            )
        },
        modifier = Modifier.nestedScroll(scrollBehavior.nestedScrollConnection)
    ) {
        UserContent(
            state = viewModel.uiState,
            event = { event ->
                when (event) {
                    is UserDetailEvent.LoadMoreCollections -> {
                        navigator.navigate(UserCollectionsDestination(username = user.username))
                    }

                    is UserDetailEvent.LoadMoreLikes -> {
                        navigator.navigate(UserLikesDestination(username = user.username))
                    }

                    is UserDetailEvent.LoadMorePhotos -> {
                        navigator.navigate(UserPhotosDestination(username = user.username))
                    }

                    is UserDetailEvent.OnCollectionClicked -> {
                        navigator.navigate(CollectionDetailDestination(collection = event.collection))
                    }

                    is UserDetailEvent.OnPhotoClicked -> {
                        navigator.navigate(PhotoDetailScreenDestination(photo = event.photo))
                    }
                }
            },
            modifier = Modifier
                .padding(
                    it
                )
                .verticalScroll(scrollState)
        )
    }
}

@Composable
private fun UserContent(
    state: UserDetailUiState,
    event: (UserDetailEvent) -> Unit,
    modifier: Modifier = Modifier
) {

    Column(modifier = modifier.fillMaxSize()) {
        if (state.user != null) {
            UserHeader(user = state.user)

            if (state.photosError.isNullOrEmpty() && state.user.totalPhotos != 0 && state.photos.isNotEmpty()) {
                val photos = remember {
                    "${state.user.totalPhotos} ${if (state.user.totalPhotos == 1) "photo" else "photos"}"
                }
                TitleHeader(
                    title = stringResource(id = R.string.photos),
                    subtitle = photos,
                    showMore = state.user.totalPhotos > 30,
                    onMoreClick = {
                        event(UserDetailEvent.LoadMorePhotos)
                    }
                )
                PhotoGrid(
                    photos = state.photos,
                    isLoading = state.isPhotosLoading,
                    onPhotoClick = {
                        event(UserDetailEvent.OnPhotoClicked(photo = it))
                    })

            }
            if (state.collectionsError.isNullOrEmpty() && state.user.totalCollections != 0 && state.collections.isNotEmpty()) {
                val collections = remember {
                    "${state.user.totalCollections} ${if (state.user.totalCollections == 1) "collection" else "collections"}"
                }
                TitleHeader(
                    title = stringResource(id = R.string.collections),
                    subtitle = collections,
                    showMore = state.user.totalCollections > 10,
                    onMoreClick = {
                        event(UserDetailEvent.LoadMoreCollections)
                    }
                )
                CollectionListSmall(
                    collections = state.collections,
                    onCollectionClick = {
                        event(UserDetailEvent.OnCollectionClicked(collection = it))
                    }
                )
            }
            if (state.likesError.isNullOrEmpty() && state.user.totalLikes != 0 && state.likes.isNotEmpty()) {

                val likes = remember {
                    "${state.user.totalLikes} ${if (state.user.totalLikes == 1) "like" else "likes"}"
                }

                TitleHeader(
                    title = stringResource(id = R.string.likes),
                    subtitle = likes,
                    showMore = state.user.totalLikes > 30,
                    onMoreClick = {
                        event(UserDetailEvent.LoadMoreLikes)
                    }
                )
                PhotoGridWithUser(
                    photos = state.likes,
                    isLoading = state.isPhotosLoading,
                    onPhotoClick = {
                        event(UserDetailEvent.OnPhotoClicked(photo = it))
                    }
                )

            }

        }
    }
}

@Composable
fun UserHeader(
    user: User,
    modifier: Modifier = Modifier
) {


    Column(
        modifier = modifier
            .fillMaxWidth()
            .padding(16.dp),
        horizontalAlignment = Alignment.CenterHorizontally
    ) {
        AsyncImage(
            model = user.profileImageLarge,
            contentDescription = null,
            modifier = Modifier
                .size(108.dp)
                .clip(CircleShape),
            contentScale = ContentScale.Crop
        )
        Spacer(modifier = Modifier.height(16.dp))


        Text(
            text = user.name,
            style = MaterialTheme.typography.headlineSmall,
            color = MaterialTheme.colorScheme.primary
        )
        Row(
            modifier = Modifier.fillMaxWidth(),
            horizontalArrangement = Arrangement.Center
        ) {

            if (user.twitterUrl.isNotEmpty()) {
                IconButton(onClick = { /*TODO*/ }) {
                    Icon(
                        painter = painterResource(id = R.drawable.bxl_twitter),
                        contentDescription = null,
                        tint = MaterialTheme.colorScheme.secondary
                    )
                }
            }
            if (user.instagramUrl.isNotEmpty()) {
                IconButton(onClick = { /*TODO*/ }) {
                    Icon(
                        painter = painterResource(id = R.drawable.bxl_instagram_alt),
                        contentDescription = null,
                        tint = MaterialTheme.colorScheme.secondary
                    )
                }
            }
            if (user.portfolioUrl.isNotEmpty()) {
                IconButton(onClick = { /*TODO*/ }) {
                    Icon(
                        imageVector = Icons.Default.Public,
                        contentDescription = null,
                        tint = MaterialTheme.colorScheme.secondary
                    )
                }
            }
        }
        if (user.bio.isNotEmpty())
            Text(
                text = user.bio,
                style = MaterialTheme.typography.bodyMedium,
                textAlign = TextAlign.Center,
                fontStyle = FontStyle.Italic
            )
    }
}