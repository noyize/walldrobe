package walldrobe.coffecode.com.ui.dashboard

import walldrobe.coffecode.com.domain.model.Photo
import walldrobe.coffecode.com.domain.model.Topic

data class DashboardUiState(
    val latestPhotos: List<Photo>,
    val bannerPhotos: List<Photo>,
    val curatedPhotos: List<Photo>,
    val topics: List<Topic>,
    val isLatestPhotosLoading: Boolean,
    val isCuratedPhotosLoading: Boolean,
    val isBannerPhotosLoading: Boolean,
    val isTopicsLoading: Boolean,
    val latestPhotosError: String?,
    val bannerPhotosError: String?,
    val curatedPhotosError: String?,
    val topicsError: String?,
) {
    companion object {
        val DEFAULT = DashboardUiState(
            latestPhotos = emptyList(),
            bannerPhotos = emptyList(),
            curatedPhotos = emptyList(),
            topics = emptyList(),
            isLatestPhotosLoading = false,
            isCuratedPhotosLoading = false,
            isBannerPhotosLoading = false,
            isTopicsLoading = false,
            latestPhotosError = null,
            bannerPhotosError = null,
            curatedPhotosError = null,
            topicsError = null
        )
    }
}
