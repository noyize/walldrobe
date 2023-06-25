package walldrobe.coffecode.com.ui.user

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.material3.MaterialTheme
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.unit.dp
import walldrobe.coffecode.com.app.util.shimmerEffect

@Composable
fun UserListLoading(modifier: Modifier = Modifier) {

    Column(modifier = modifier) {
        for (i in 1..6) {
            UserItemLoading()
        }
    }
}

@Composable
fun UserItemLoading(modifier: Modifier = Modifier) {
    Row(
        modifier = modifier.fillMaxWidth(),
        verticalAlignment = Alignment.CenterVertically
    ) {

        Box(
            modifier = Modifier
                .size(88.dp)
                .padding(16.dp)
                .clip(CircleShape)
                .shimmerEffect()
        )

        Column {
            Box(
                modifier = Modifier
                    .width(220.dp)
                    .height(16.dp)
                    .clip(MaterialTheme.shapes.large)
                    .shimmerEffect()
            )
            Spacer(modifier = Modifier.height(16.dp))
            Box(
                modifier = Modifier
                    .width(180.dp)
                    .height(12.dp)
                    .clip(MaterialTheme.shapes.large)
                    .shimmerEffect()
            )
        }

    }
}