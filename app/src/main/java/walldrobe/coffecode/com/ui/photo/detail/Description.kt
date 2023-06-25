package walldrobe.coffecode.com.ui.photo.detail

import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.text.font.FontStyle
import walldrobe.coffecode.com.domain.model.Photo

@Composable
fun Description(photo: Photo, modifier: Modifier = Modifier) {
    Text(
        text = photo.description,
        style = MaterialTheme.typography.bodyLarge,
        modifier = modifier,
        fontStyle = FontStyle.Italic,
        color = MaterialTheme.colorScheme.onSurface.copy(0.7f)
    )
}