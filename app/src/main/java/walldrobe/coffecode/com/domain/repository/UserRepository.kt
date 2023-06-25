package walldrobe.coffecode.com.domain.repository

import androidx.paging.PagingData
import kotlinx.coroutines.flow.Flow
import walldrobe.coffecode.com.app.util.Resource
import walldrobe.coffecode.com.domain.model.Collection
import walldrobe.coffecode.com.domain.model.Photo

interface UserRepository {

    fun getUserPhotos(username: String): Flow<Resource<List<Photo>>>
    fun getUserLikes(username: String): Flow<Resource<List<Photo>>>
    fun getUserCollections(username: String): Flow<Resource<List<Collection>>>
    fun getPagedUserPhotos(username: String): Flow<PagingData<Photo>>
    fun getPagedUserLikes(username: String): Flow<PagingData<Photo>>
    fun getPagedCollections(username: String): Flow<PagingData<Collection>>

}