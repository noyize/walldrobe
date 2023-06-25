package walldrobe.coffecode.com.domain.repository

interface CachePreference {


    suspend fun updateLatestPhotosSync()

    suspend fun getLatestPhotosSync(): Long

    suspend fun updateCuratedPhotosSync()

    suspend fun getCuratedPhotosSync(): Long

    suspend fun updateBannerPhotosSync()

    suspend fun getBannerPhotosSync(): Long

    suspend fun updateTopicsSync()

    suspend fun getTopicSync(): Long

}