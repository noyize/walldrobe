package walldrobe.coffecode.com.ui.collection

import androidx.compose.foundation.clickable
import androidx.compose.foundation.interaction.MutableInteractionSource
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.grid.GridCells
import androidx.compose.foundation.lazy.grid.LazyVerticalGrid
import androidx.compose.runtime.Composable
import androidx.compose.runtime.remember
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import androidx.paging.LoadState
import androidx.paging.compose.LazyPagingItems
import androidx.paging.compose.itemContentType
import androidx.paging.compose.itemKey
import walldrobe.coffecode.com.domain.model.Collection

@Composable
fun PagedCollectionList(
    collections: LazyPagingItems<Collection>,
    onCollectionClicked: (Collection) -> Unit,
    modifier: Modifier = Modifier,
) {
    val interactionSource = remember { MutableInteractionSource() }
    LazyVerticalGrid(
        modifier = modifier.fillMaxSize(),
        columns = GridCells.Adaptive(280.dp),
        verticalArrangement = Arrangement.spacedBy(32.dp),
        horizontalArrangement = Arrangement.spacedBy(32.dp),
        contentPadding = PaddingValues(
            horizontal = 16.dp,
            vertical = 24.dp
        )
    ) {

        items(
            count = collections.itemCount,
            contentType = collections.itemContentType()
        ) { index ->
            val item = collections[index]
            if (item != null) {
                CollectionItem(
                    collection = item,
                    modifier = Modifier.clickable(
                        indication = null,
                        interactionSource = interactionSource
                    ) {
                        onCollectionClicked(item)
                    })
            }

        }
        when (collections.loadState.refresh) { //FIRST LOAD
            is LoadState.Error -> {
                //TODO Error Item
                //state.error to get error message
            }

            is LoadState.Loading -> { // Loading UI
                item {
                    CollectionListLoading(
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