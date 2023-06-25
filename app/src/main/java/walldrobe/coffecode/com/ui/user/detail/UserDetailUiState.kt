package walldrobe.coffecode.com.ui.user.detail

import androidx.paging.PagingData
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.flow
import walldrobe.coffecode.com.domain.model.Collection
import walldrobe.coffecode.com.domain.model.Photo
import walldrobe.coffecode.com.domain.model.User

data class UserDetailUiState(
    val user: User?,
    val photos: List<Photo>,
    val likes: List<Photo>,
    val collections: List<Collection>,
    val photosError:String?,
    val likesError:String?,
    val collectionsError:String?,
    val isPhotosLoading:Boolean,
    val isLikesLoading:Boolean,
    val isCollectionsLoading: Boolean
) {
    companion object {
        val DEFAULT = UserDetailUiState(
            user = null,
            photos = emptyList(),
            likes = emptyList(),
            collections =emptyList(),
            photosError = null,
            likesError = null,
            collectionsError = null,
            isPhotosLoading = false,
            isLikesLoading = false,
            isCollectionsLoading = false
        )
    }
}
