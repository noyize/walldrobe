package walldrobe.coffecode.com.ui.photo.detail

import walldrobe.coffecode.com.domain.model.Collection
import walldrobe.coffecode.com.domain.model.User

sealed class PhotoDetailEvent {
    object OnBackPressed : PhotoDetailEvent()
    data class OnRelatedCollectionClicked(val relatedCollection: Collection) :
        PhotoDetailEvent()

    data class OnTagClicked(val query: String) : PhotoDetailEvent()

    data class OnUserClicked(val user: User):PhotoDetailEvent()
}
