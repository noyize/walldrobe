package walldrobe.coffecode.com.data.repository

import androidx.paging.Pager
import androidx.paging.PagingConfig
import walldrobe.coffecode.com.data.remote.search.SearchService
import walldrobe.coffecode.com.data.remote.search.paging.SearchCollectionPagingSource
import walldrobe.coffecode.com.data.remote.search.paging.SearchPhotosPagingSource
import walldrobe.coffecode.com.data.remote.search.paging.SearchUsersPagingSource
import walldrobe.coffecode.com.domain.repository.SearchRepository
import javax.inject.Inject

class SearchRepositoryImpl @Inject constructor(
    private val searchService: SearchService
) : SearchRepository {
    override fun searchPhotos(query: String) = Pager(
        config = PagingConfig(
            pageSize = 30,
        ),
        pagingSourceFactory = {
            SearchPhotosPagingSource(query = query, searchService = searchService)
        }
    ).flow

    override fun searchCollections(query: String) = Pager(
        config = PagingConfig(
            pageSize = 30,
        ),
        pagingSourceFactory = {
            SearchCollectionPagingSource(query = query, searchService = searchService)
        }
    ).flow

    override fun searchUsers(query: String) = Pager(
        config = PagingConfig(
            pageSize = 30,
        ),
        pagingSourceFactory = {
            SearchUsersPagingSource(query = query, searchService = searchService)
        }
    ).flow
}