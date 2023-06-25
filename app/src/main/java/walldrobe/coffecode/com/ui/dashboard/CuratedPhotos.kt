package walldrobe.coffecode.com.ui.dashboard

import android.widget.Toast
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.ui.Modifier
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.res.stringResource
import walldrobe.coffecode.com.R
import walldrobe.coffecode.com.domain.model.Photo
import walldrobe.coffecode.com.ui.common.components.TitleHeader
import walldrobe.coffecode.com.ui.photo.PhotoGridWithUser

@Composable
fun CuratedPhotos(
    isLoading: Boolean,
    error: String?,
    photos: List<Photo>,
    onPhotoClick: (Photo) -> Unit,
    onMoreClick: () -> Unit,
    modifier: Modifier = Modifier
) {
    val context = LocalContext.current
    LaunchedEffect(error) {
        if (error.isNullOrEmpty().not())
            Toast.makeText(context, error, Toast.LENGTH_SHORT).show()
    }

    if (error.isNullOrEmpty()) {
        Column(
            modifier = modifier
                .fillMaxWidth()
        ) {
            if (isLoading.not())
                TitleHeader(
                    title = stringResource(id = R.string.curated),
                    subtitle = stringResource(id = R.string.curated_photos_description),
                    onMoreClick = onMoreClick
                )
            PhotoGridWithUser(photos = photos, isLoading = isLoading, onPhotoClick = onPhotoClick)

        }
    }
}