package walldrobe.coffecode.com.data.local

import androidx.datastore.core.DataStore
import androidx.datastore.preferences.core.Preferences
import androidx.datastore.preferences.core.edit
import androidx.datastore.preferences.core.longPreferencesKey
import kotlinx.coroutines.flow.first
import kotlinx.coroutines.flow.map
import walldrobe.coffecode.com.domain.repository.CachePreference
import javax.inject.Inject

class CachePreferenceImpl @Inject constructor(
    private val appDataStore: DataStore<Preferences>
) : CachePreference {
    override suspend fun updateLatestPhotosSync() {
        val newValue = System.currentTimeMillis()
        appDataStore.edit {
            it[LATEST_PHOTOS_CACHE_KEY] = newValue
        }
    }

    override suspend fun getLatestPhotosSync(): Long {
        return appDataStore.data.map {
            it[LATEST_PHOTOS_CACHE_KEY] ?: 0L
        }.first()
    }

    override suspend fun updateCuratedPhotosSync() {
        val newValue = System.currentTimeMillis()
        appDataStore.edit {
            it[CURATED_PHOTOS_CACHE_KEY] = newValue
        }
    }

    override suspend fun getCuratedPhotosSync(): Long {
        return appDataStore.data.map {
            it[CURATED_PHOTOS_CACHE_KEY] ?: 0L
        }.first()
    }

    override suspend fun updateBannerPhotosSync() {
        val newValue = System.currentTimeMillis()
        appDataStore.edit {
            it[BANNER_PHOTOS_CACHE_KEY] = newValue
        }
    }

    override suspend fun getBannerPhotosSync(): Long {
        return appDataStore.data.map {
            it[BANNER_PHOTOS_CACHE_KEY] ?: 0L
        }.first()
    }

    override suspend fun updateTopicsSync() {
        val newValue = System.currentTimeMillis()
        appDataStore.edit {
            it[TOPICS_CACHE_KEY] = newValue
        }
    }

    override suspend fun getTopicSync(): Long {
        return appDataStore.data.map {
            it[TOPICS_CACHE_KEY] ?: 0L
        }.first()
    }

    companion object {
        val LATEST_PHOTOS_CACHE_KEY = longPreferencesKey("latest_photos_cache_key")
        val CURATED_PHOTOS_CACHE_KEY = longPreferencesKey("curated_photos_cache_key")
        val BANNER_PHOTOS_CACHE_KEY = longPreferencesKey("banner_photos_cache_key")
        val TOPICS_CACHE_KEY = longPreferencesKey("topics_cache_key")
    }

}