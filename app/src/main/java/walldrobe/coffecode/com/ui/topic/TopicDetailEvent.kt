package walldrobe.coffecode.com.ui.topic

sealed class TopicDetailEvent{
    object OnBackPressed : TopicDetailEvent()
    data class OnPhotoClicked(
        val id: String,
        val imageUrl: String,
        val color:String,
        val width: Int,
        val height: Int
    ) : TopicDetailEvent()
}
