package walldrobe.coffecode.com.ui.photo.detail

import walldrobe.coffecode.com.domain.model.Photo

data class PhotoDetailState(
    val isPhotoLoading: Boolean,
    val error: String?,
    val photo: Photo?
) {
    companion object {
        val DEFAULT = PhotoDetailState(
            photo = null,
            isPhotoLoading = false,
            error = null,
        )
    }
}
