package walldrobe.coffecode.com.ui.photo.latest

sealed class LatestPhotosEvent {
    object OnBackPressed : LatestPhotosEvent()
    data class OnPhotoClicked(
        val id: String,
        val imageUrl: String,
        val color:String,
        val width: Int,
        val height: Int
    ) : LatestPhotosEvent()
}
