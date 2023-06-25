package walldrobe.coffecode.com.ui.dashboard

import android.widget.Toast
import androidx.compose.foundation.ExperimentalFoundationApi
import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.pager.HorizontalPager
import androidx.compose.foundation.pager.rememberPagerState
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
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
import androidx.compose.ui.platform.LocalConfiguration
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.platform.LocalDensity
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.unit.dp
import coil.compose.AsyncImage
import coil.request.CachePolicy
import coil.request.ImageRequest
import walldrobe.coffecode.com.R
import walldrobe.coffecode.com.app.util.shimmerEffect
import walldrobe.coffecode.com.domain.model.Photo

@OptIn(ExperimentalFoundationApi::class)
@Composable
fun Banners(
    isLoading: Boolean,
    error: String?,
    bannerPhotos: List<Photo>,
    onPhotoClick: (Photo) -> Unit,
    modifier: Modifier = Modifier
) {
    val configuration = LocalConfiguration.current
    val deviceHeight = configuration.screenHeightDp

    val density = LocalDensity.current
    val headerHeight = with(density) {
        (deviceHeight + 600).toDp()
    }


    val context = LocalContext.current
    LaunchedEffect(error) {
        if (error.isNullOrEmpty().not())
            Toast.makeText(context, error, Toast.LENGTH_SHORT).show()
    }

    if (isLoading) {
        BannersLoading(
            modifier = Modifier
                .fillMaxWidth()
                .height(headerHeight)
        )
    } else if (error.isNullOrBlank()) {
        val pageState = rememberPagerState(
            initialPage = 0,
            initialPageOffsetFraction = 0f,
            pageCount = { bannerPhotos.size }
        )
        var bannerPosition by remember {
            mutableStateOf(0)
        }

        LaunchedEffect(bannerPosition) {
            pageState.animateScrollToPage(bannerPosition)
        }



        Box(
            modifier = modifier
                .fillMaxWidth()
                .height(headerHeight)
        ) {
            HorizontalPager(
                state = pageState
            ) {
                BannerItem(
                    photo = bannerPhotos[it],
                    modifier = Modifier.clickable {
                        onPhotoClick(bannerPhotos[it])
                    }
                )
            }
            Row(
                modifier = Modifier
                    .fillMaxWidth()
                    .align(Alignment.BottomCenter),
                verticalAlignment = Alignment.CenterVertically,
                horizontalArrangement = Arrangement.SpaceAround
            ) {
                IconButton(onClick = {
                    val newBannerPosition = pageState.currentPage - 1
                    bannerPosition =
                        if (newBannerPosition < 0) pageState.currentPage else newBannerPosition
                }) {

                    Icon(
                        painter = painterResource(id = R.drawable.bx_chevron_left),
                        contentDescription = null,
                        tint = MaterialTheme.colorScheme.onSurface
                    )
                }
                Spacer(modifier = Modifier.width(16.dp))

                Row(

                    horizontalArrangement = Arrangement.spacedBy(16.dp)
                ) {
                    bannerPhotos.forEachIndexed { index, banner ->

                        Box(
                            modifier = Modifier
                                .width(40.dp)
                                .height(4.dp)
                                .clip(RoundedCornerShape(50.dp))
                                .background(
                                    if (index == pageState.currentPage) MaterialTheme.colorScheme.onSurface else MaterialTheme.colorScheme.onSurface.copy(
                                        alpha = 0.1f
                                    )
                                )
                        )
                    }
                }

                Spacer(modifier = Modifier.width(16.dp))

                IconButton(onClick = {
                    val newBannerPosition = pageState.currentPage + 1
                    bannerPosition =
                        if (newBannerPosition > bannerPhotos.size) pageState.currentPage else newBannerPosition
                }) {
                    Icon(
                        painter = painterResource(id = R.drawable.bx_chevron_right),
                        contentDescription = null,
                        tint = MaterialTheme.colorScheme.onSurface
                    )
                }


            }
        }
    }

}

@Composable
fun BannerItem(
    photo: Photo,
    modifier: Modifier = Modifier
) {

    Box(
        modifier = modifier
            .fillMaxSize()

    ) {
        AsyncImage(
            modifier = Modifier.fillMaxSize(),
            model = ImageRequest.Builder(LocalContext.current)
                .data(photo.regularUrl)
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
                            MaterialTheme.colorScheme.surface,
                        )
                    )
                )
        )

        Column(
            modifier = Modifier
                .padding(horizontal = 16.dp, vertical = 52.dp)
                .align(Alignment.BottomStart)
        ) {

            Text(
                text = photo.description,
                style = MaterialTheme.typography.displaySmall,
                color = MaterialTheme.colorScheme.onSurface
            )
            Text(
                text = "Photo by ${photo.user!!.name}",
                style = MaterialTheme.typography.labelMedium,
                color = MaterialTheme.colorScheme.onSurface.copy(alpha = 0.7f)
            )
        }


    }

}

@Composable
private fun BannersLoading(modifier: Modifier = Modifier) {
    Box(modifier = modifier.shimmerEffect())
}