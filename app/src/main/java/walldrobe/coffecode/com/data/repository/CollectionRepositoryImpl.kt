package walldrobe.coffecode.com.data.repository

import androidx.paging.Pager
import androidx.paging.PagingConfig
import walldrobe.coffecode.com.data.remote.collection.CollectionService
import walldrobe.coffecode.com.data.remote.search.paging.SearchCollectionPagingSource
import walldrobe.coffecode.com.domain.repository.CollectionRepository
import javax.inject.Inject

class CollectionRepositoryImpl @Inject constructor(
    private val collectionService: CollectionService
) : CollectionRepository {

}