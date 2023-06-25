package walldrobe.coffecode.com.ui.user.detail

import walldrobe.coffecode.com.domain.model.Collection
import walldrobe.coffecode.com.domain.model.Photo

sealed class UserDetailEvent {
    data class OnPhotoClicked(val photo: Photo) : UserDetailEvent()
    data class OnCollectionClicked(val collection: Collection) : UserDetailEvent()
    object LoadMorePhotos : UserDetailEvent()
    object LoadMoreLikes : UserDetailEvent()
    object LoadMoreCollections : UserDetailEvent()
}