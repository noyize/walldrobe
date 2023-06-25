package walldrobe.coffecode.com.ui.photo.detail

import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.width
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.outlined.Architecture
import androidx.compose.material.icons.outlined.Camera
import androidx.compose.material.icons.outlined.CameraAlt
import androidx.compose.material.icons.outlined.CameraRoll
import androidx.compose.material.icons.outlined.CenterFocusWeak
import androidx.compose.material.icons.outlined.InvertColors
import androidx.compose.material.icons.outlined.Lightbulb
import androidx.compose.material.icons.outlined.Timelapse
import androidx.compose.material3.Icon
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.vector.ImageVector
import androidx.compose.ui.text.style.TextOverflow
import androidx.compose.ui.unit.dp
import walldrobe.coffecode.com.domain.model.Photo

@Composable
 fun Exif(photo: Photo, modifier: Modifier = Modifier) {
    Column(modifier = modifier) {
        Text(
            text = "Exif",
            style = MaterialTheme.typography.titleMedium,
            modifier = Modifier.padding(horizontal = 16.dp)
        )
        Row(
            modifier = Modifier.fillMaxWidth(),
            verticalAlignment = Alignment.CenterVertically
        ) {
            ExifItem(
                title = "Camera make",
                value = photo.cameraMake,
                icon = Icons.Outlined.CameraAlt,
                modifier = Modifier.weight(1f)
            )
            ExifItem(
                title = "Camera model",
                value = photo.cameraModel,
                icon = Icons.Outlined.CameraRoll,
                modifier = Modifier.weight(1f)
            )
        }
        Row(
            modifier = Modifier.fillMaxWidth(),
            verticalAlignment = Alignment.CenterVertically
        ) {
            ExifItem(
                title = "Size",
                value = photo.size,
                icon = Icons.Outlined.Architecture,
                modifier = Modifier.weight(1f)
            )
            ExifItem(
                title = "Focal length",
                value = photo.focalLength,
                icon = Icons.Outlined.CenterFocusWeak,
                modifier = Modifier.weight(1f)
            )
        }
        Row(
            modifier = Modifier.fillMaxWidth(),
            verticalAlignment = Alignment.CenterVertically
        ) {
            ExifItem(
                title = "Aperture",
                value = photo.aperture,
                icon = Icons.Outlined.Camera,
                modifier = Modifier.weight(1f)
            )
            ExifItem(
                title = "Exposure time",
                value = photo.exposureTime,
                icon = Icons.Outlined.Timelapse,
                modifier = Modifier.weight(1f)
            )
        }
        Row(
            modifier = Modifier.fillMaxWidth(),
            verticalAlignment = Alignment.CenterVertically
        ) {
            ExifItem(
                title = "Iso",
                value = photo.iso,
                icon = Icons.Outlined.Lightbulb,
                modifier = Modifier.weight(1f)
            )
            ExifItem(
                title = "Color",
                value = photo.color,
                icon = Icons.Outlined.InvertColors,
                modifier = Modifier.weight(1f)
            )
        }
    }
}

@Composable
private fun ExifItem(
    title: String,
    value: String,
    icon: ImageVector,
    modifier: Modifier = Modifier
) {
    Row(
        modifier = modifier.padding(16.dp),
        verticalAlignment = Alignment.CenterVertically
    ) {
        Icon(
            imageVector = icon,
            contentDescription = null,
            tint = MaterialTheme.colorScheme.primary
        )
        Spacer(modifier = Modifier.width(16.dp))
        Column {
            Text(
                text = title,
                style = MaterialTheme.typography.labelSmall,
                color = MaterialTheme.colorScheme.onSurface.copy(alpha = 0.5f)
            )
            Text(
                text = value,
                style = MaterialTheme.typography.titleSmall,
                maxLines = 1,
                overflow = TextOverflow.Ellipsis
            )
        }
    }
}
