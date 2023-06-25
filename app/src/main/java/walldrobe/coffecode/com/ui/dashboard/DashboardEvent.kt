package walldrobe.coffecode.com.ui.dashboard

import walldrobe.coffecode.com.domain.model.Photo
import walldrobe.coffecode.com.domain.model.Topic

sealed class DashboardEvent {
    data class OnPhotoClicked(val photo: Photo) : DashboardEvent()
    data class OnTopicClick(val topic: Topic) : DashboardEvent()

    object NavigateToLatestPhotos : DashboardEvent()
    object NavigateToCuratedPhotos : DashboardEvent()
}
