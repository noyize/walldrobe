package walldrobe.coffecode.com.ui.user

import androidx.compose.foundation.clickable
import androidx.compose.foundation.interaction.MutableInteractionSource
import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.runtime.Composable
import androidx.compose.runtime.remember
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import androidx.paging.LoadState
import androidx.paging.compose.LazyPagingItems
import androidx.paging.compose.itemContentType
import walldrobe.coffecode.com.domain.model.User

@Composable
fun PagedUserList(
    users: LazyPagingItems<User>,
    onUserClicked: (User) -> Unit,
    modifier: Modifier = Modifier,
) {
    val interactionSource = remember { MutableInteractionSource() }
    LazyColumn(
        modifier = modifier.fillMaxSize(),
        contentPadding = PaddingValues(
            horizontal = 16.dp,
            vertical = 24.dp
        )
    ) {

        items(
            count = users.itemCount,
            contentType = users.itemContentType()
        ) { index ->
            val item = users[index]
            if (item != null) {
                UserItem(
                    name = item.name,
                    username = item.username,
                    avatar = item.profileImageRegular,
                    modifier = Modifier.clickable(
                        indication = null,
                        interactionSource = interactionSource
                    ) {
                        onUserClicked(item)
                    })
            }

        }
        when (users.loadState.refresh) { //FIRST LOAD
            is LoadState.Error -> {
                //TODO Error Item
                //state.error to get error message
            }

            is LoadState.Loading -> { // Loading UI
                item {
                    UserListLoading()
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