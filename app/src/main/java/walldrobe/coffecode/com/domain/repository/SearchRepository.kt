package walldrobe.coffecode.com.domain.repository

import androidx.paging.PagingData
import kotlinx.coroutines.flow.Flow
import walldrobe.coffecode.com.domain.model.Collection
import walldrobe.coffecode.com.domain.model.Photo
import walldrobe.coffecode.com.domain.model.User

interface SearchRepository {

    fun searchPhotos(query: String): Flow<PagingData<Photo>>
    fun searchCollections(query: String): Flow<PagingData<Collection>>
    fun searchUsers(query: String): Flow<PagingData<User>>
}