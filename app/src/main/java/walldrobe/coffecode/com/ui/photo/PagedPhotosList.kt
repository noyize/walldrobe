package walldrobe.coffecode.com.ui.photo

import androidx.compose.foundation.clickable
import androidx.compose.foundation.interaction.MutableInteractionSource
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.staggeredgrid.LazyVerticalStaggeredGrid
import androidx.compose.foundation.lazy.staggeredgrid.StaggeredGridCells
import androidx.compose.foundation.lazy.staggeredgrid.StaggeredGridItemSpan
import androidx.compose.runtime.Composable
import androidx.compose.runtime.remember
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import androidx.paging.LoadState
import androidx.paging.compose.LazyPagingItems
import androidx.paging.compose.itemContentType
import androidx.paging.compose.itemKey
import walldrobe.coffecode.com.domain.model.Photo

@Composable
fun PagedPhotosList(

    photos: LazyPagingItems<Photo>,
    onPhotoClicked: (Photo) -> Unit,
    modifier: Modifier = Modifier,
    showHeaderLoading:Boolean = true,
    header: @Composable () -> Unit = {},
) {
    val interactionSource = remember { MutableInteractionSource() }
    LazyVerticalStaggeredGrid(
        modifier = modifier.fillMaxSize(),
        columns = StaggeredGridCells.Adaptive(240.dp),
        verticalItemSpacing = 32.dp,
        horizontalArrangement = Arrangement.spacedBy(32.dp),
        contentPadding = PaddingValues(horizontal = 16.dp)
    ) {
        if (photos.itemCount != 0) {
            item(span = StaggeredGridItemSpan.FullLine) {
                header()
            }
        }
        items(
            count = photos.itemCount,
            key = photos.itemKey(key = { item -> item.regularUrl }),
            contentType = photos.itemContentType(
            )
        ) { index ->
            val item = photos[index]
            if (item != null) {
                PhotoListItem(
                    photo = item,
                    modifier = Modifier.clickable(
                        indication = null,
                        interactionSource = interactionSource
                    ) {
                        onPhotoClicked(item)
                    })
            }
        }
        when (photos.loadState.refresh) { //FIRST LOAD
            is LoadState.Error -> {
                //TODO Error Item
                //state.error to get error message
            }

            is LoadState.Loading -> { // Loading UI
                item {
                    PhotoListLoading(
                        showHeader = showHeaderLoading,
                        modifier = Modifier.padding(vertical = 16.dp)
                    )
                }
            }

            else -> {}
        }
////
//        when (photos.loadState.append) { // Pagination
//            is LoadState.Error -> {
//                //TODO Pagination Error Item
//                //state.error to get error message
//            }
//
//            is LoadState.Loading -> { // Pagination Loading UI
//                item {
//                    Column(
//                        modifier = Modifier
//                            .fillMaxWidth(),
//                        horizontalAlignment = Alignment.CenterHorizontally,
//                        verticalArrangement = Arrangement.Center,
//                    ) {
//                        Text(text = "Pagination Loading")
//
//                        CircularProgressIndicator(color = Color.Black)
//                    }
//                }
//            }
//
//            else -> {}
//        }
    }

}