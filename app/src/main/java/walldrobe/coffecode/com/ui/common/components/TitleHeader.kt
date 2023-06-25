package walldrobe.coffecode.com.ui.common.components

import androidx.compose.foundation.border
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.outlined.ArrowForward
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.unit.dp
import walldrobe.coffecode.com.R

@Composable
fun TitleHeader(
    title: String,
    subtitle: String,
    onMoreClick: () -> Unit,
    modifier: Modifier = Modifier,
    isMoreIconOnly: Boolean = false,
    showMore: Boolean = true
) {
    Row(
        modifier = modifier
            .fillMaxWidth()
            .padding(start = 16.dp, top = 32.dp, end = 16.dp),
        verticalAlignment = Alignment.CenterVertically,
        horizontalArrangement = Arrangement.SpaceBetween
    ) {

        Column(
            modifier = Modifier
                .weight(1f)
                .padding(end = 32.dp)
        ) {
            Text(
                text = title,
                style = if (subtitle.isNotEmpty()) MaterialTheme.typography.titleMedium else MaterialTheme.typography.titleLarge,
                color = MaterialTheme.colorScheme.onSurface,
            )
            if (subtitle.isNotEmpty())
                Text(
                    text = subtitle,
                    style = MaterialTheme.typography.bodySmall,
                    color = MaterialTheme.colorScheme.onSurface.copy(alpha = 0.5f),
                )
        }
        if (showMore) {
            if (isMoreIconOnly) {
                IconButton(onClick = onMoreClick) {
                    Icon(imageVector = Icons.Outlined.ArrowForward, contentDescription = null)
                }
            } else {
                Box(modifier = Modifier
                    .border(
                        color = MaterialTheme.colorScheme.onSurface.copy(alpha = 0.2f),
                        width = 1.dp,
                        shape = RoundedCornerShape(50)
                    )
                    .clip(RoundedCornerShape(50))
                    .clickable { onMoreClick() }

                ) {
                    Text(
                        modifier = Modifier.padding(vertical = 2.dp, horizontal = 8.dp),
                        text = stringResource(id = R.string.more),
                        style = MaterialTheme.typography.bodySmall,
                        color = MaterialTheme.colorScheme.onSurface
                    )
                }
            }
        }
    }
}