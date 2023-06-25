package walldrobe.coffecode.com.data.remote.search.paging

import androidx.paging.PagingSource
import androidx.paging.PagingState
import com.skydoves.sandwich.ApiResponse
import com.skydoves.sandwich.message
import walldrobe.coffecode.com.data.mapper.toCollection
import walldrobe.coffecode.com.data.remote.collection.CollectionService
import walldrobe.coffecode.com.data.remote.search.SearchService
import walldrobe.coffecode.com.domain.model.Collection

class SearchCollectionPagingSource(
    private val searchService: SearchService,
    private val query: String
) : PagingSource<Int, Collection>() {
    override fun getRefreshKey(state: PagingState<Int, Collection>): Int? {
        return state.anchorPosition?.let { anchorPosition ->
            state.closestPageToPosition(anchorPosition)?.prevKey?.plus(1)
                ?: state.closestPageToPosition(anchorPosition)?.nextKey?.minus(1)
        }
    }

    override suspend fun load(params: LoadParams<Int>): LoadResult<Int, Collection> {
        val page = params.key ?: 1
        val response = searchService.searchCollections(
            query = query,
            page = page,
            perPage = 30,
        )

        return when (response) {
            is ApiResponse.Failure.Error -> {
                LoadResult.Error(Exception(response.message()))

            }

            is ApiResponse.Failure.Exception -> {
                LoadResult.Error(response.exception)
            }

            is ApiResponse.Success -> {
                val collections = response.data.results.map { it.toCollection() }
                LoadResult.Page(
                    data = collections,
                    prevKey = if (page == 1) null else page.minus(1),
                    nextKey = if (collections.isEmpty()) null else page.plus(1),
                )
            }
        }
    }
}