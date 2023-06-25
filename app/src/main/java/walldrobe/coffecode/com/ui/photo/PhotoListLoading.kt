package walldrobe.coffecode.com.ui.photo

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.material3.MaterialTheme
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.unit.dp
import walldrobe.coffecode.com.app.util.shimmerEffect

@Composable
fun PhotoListLoading(
    modifier: Modifier = Modifier,
    showHeader: Boolean = true
) {
    Column(

        modifier = modifier.fillMaxWidth(),

        verticalArrangement = Arrangement.spacedBy(16.dp)
    ) {
        if (showHeader) {
            Box(
                modifier = Modifier
                    .width(240.dp)
                    .height(8.dp)
                    .clip(CircleShape)
                    .shimmerEffect()
            )

            Box(
                modifier = Modifier
                    .width(220.dp)
                    .height(8.dp)
                    .clip(CircleShape)
                    .shimmerEffect()
            )

            Box(
                modifier = Modifier
                    .width(200.dp)
                    .height(8.dp)
                    .clip(CircleShape)
                    .shimmerEffect()
            )
        }
        Spacer(modifier = Modifier.height(24.dp))

        Row {
            Box(
                modifier = Modifier
                    .size(40.dp)
                    .clip(CircleShape)
                    .shimmerEffect()
            )

            Spacer(modifier = Modifier.width(16.dp))

            Column {

                Box(
                    modifier = Modifier
                        .width(200.dp)
                        .height(8.dp)
                        .clip(CircleShape)
                        .shimmerEffect()
                )
                Spacer(modifier = Modifier.height(16.dp))
                Box(
                    modifier = Modifier
                        .width(80.dp)
                        .height(8.dp)
                        .clip(CircleShape)
                        .shimmerEffect()
                )
            }

        }

        Box(
            modifier = Modifier
                .fillMaxWidth()
                .height(340.dp)
                .clip(MaterialTheme.shapes.medium)
                .shimmerEffect()
        )

        Spacer(modifier = Modifier.height(24.dp))

        Row {
            Box(
                modifier = Modifier
                    .size(40.dp)
                    .clip(CircleShape)
                    .shimmerEffect()
            )

            Spacer(modifier = Modifier.width(16.dp))

            Column {

                Box(
                    modifier = Modifier
                        .width(200.dp)
                        .height(8.dp)
                        .clip(CircleShape)
                        .shimmerEffect()
                )
                Spacer(modifier = Modifier.height(16.dp))
                Box(
                    modifier = Modifier
                        .width(80.dp)
                        .height(8.dp)
                        .clip(CircleShape)
                        .shimmerEffect()
                )
            }

        }

        Box(
            modifier = Modifier
                .fillMaxWidth()
                .height(340.dp)
                .clip(MaterialTheme.shapes.medium)
                .shimmerEffect()
        )
    }
}