package walldrobe.coffecode.com.ui.collection

import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.material3.MaterialTheme
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.unit.dp
import walldrobe.coffecode.com.app.util.shimmerEffect


@Composable
fun CollectionListLoading(modifier: Modifier = Modifier) {
    Column(
        modifier = modifier
            .fillMaxSize()
    ) {
        for (i in 0..3) {
            Box(modifier = Modifier
                .fillMaxWidth()
                .clip(MaterialTheme.shapes.small)
                .shimmerEffect())
            Spacer(modifier = Modifier.height(24.dp))
        }
    }
}