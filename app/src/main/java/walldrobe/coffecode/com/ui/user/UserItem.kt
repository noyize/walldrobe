package walldrobe.coffecode.com.ui.user

import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.unit.dp
import coil.compose.AsyncImage

@Composable
fun UserItem(
    name: String,
    avatar: String,
    username: String,
    modifier: Modifier = Modifier
) {
    Row(
        modifier = modifier.fillMaxWidth(),
        verticalAlignment = Alignment.CenterVertically
    ) {

        AsyncImage(
            model = avatar,
            contentDescription = null,
            modifier = Modifier
                .size(88.dp)
                .padding(16.dp)
                .clip(CircleShape),
            contentScale = ContentScale.Crop
        )

        Column {
            Text(text = name, style = MaterialTheme.typography.titleMedium)
            Text(text = "@$username", style = MaterialTheme.typography.bodySmall)
        }

    }
}