package walldrobe.coffecode.com.ui.search

import androidx.paging.PagingData
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.flow
import walldrobe.coffecode.com.domain.model.Collection
import walldrobe.coffecode.com.domain.model.Photo
import walldrobe.coffecode.com.domain.model.User

data class SearchUiState(
    val isPhotosLoading: Boolean,
    val query: String,
    val photos: Flow<PagingData<Photo>>,
    val collections: Flow<PagingData<Collection>>,
    val users: Flow<PagingData<User>>,
    val photoError: String?
) {
    companion object {
        val DEFAULT = SearchUiState(
            query = "",
            isPhotosLoading = false,
            photos = flow { },
            collections = flow { },
            users = flow { },
            photoError = null
        )
    }
}
