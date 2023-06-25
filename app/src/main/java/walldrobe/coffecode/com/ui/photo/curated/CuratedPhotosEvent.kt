package walldrobe.coffecode.com.ui.photo.curated

sealed class CuratedPhotosEvent {
    object OnBackPressed : CuratedPhotosEvent()
    data class OnPhotoClicked(
        val id: String,
        val imageUrl: String,
        val color:String,
        val width: Int,
        val height: Int
    ) : CuratedPhotosEvent()
}
