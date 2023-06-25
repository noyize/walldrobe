package walldrobe.coffecode.com.domain.repository

import androidx.paging.PagingData
import kotlinx.coroutines.flow.Flow
import walldrobe.coffecode.com.app.util.Resource
import walldrobe.coffecode.com.domain.model.Photo

interface PhotoRepository {

    suspend fun getLatestPhotos(): Flow<Resource<List<Photo>>>
    suspend fun getCuratedPhotos(): Flow<Resource<List<Photo>>>
    suspend fun getBanners(): Flow<Resource<List<Photo>>>
    fun getPhoto(id: String): Flow<Resource<Photo>>
    fun getPaginatedLatestPhotos(): Flow<PagingData<Photo>>
    fun getTopicPhotos(id:String): Flow<PagingData<Photo>>
    fun getCollectionPhotos(id:String): Flow<PagingData<Photo>>
}