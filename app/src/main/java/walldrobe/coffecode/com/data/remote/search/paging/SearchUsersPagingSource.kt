package walldrobe.coffecode.com.data.remote.search.paging

import android.util.Log
import androidx.paging.PagingSource
import androidx.paging.PagingState
import com.skydoves.sandwich.ApiResponse
import com.skydoves.sandwich.message
import walldrobe.coffecode.com.data.remote.photo.PhotoService
import walldrobe.coffecode.com.data.mapper.toPhoto
import walldrobe.coffecode.com.data.mapper.toUser
import walldrobe.coffecode.com.data.remote.search.SearchService
import walldrobe.coffecode.com.domain.model.Photo
import walldrobe.coffecode.com.domain.model.User

class SearchUsersPagingSource(
    private val searchService: SearchService,
    private val query: String
) : PagingSource<Int, User>() {
    override fun getRefreshKey(state: PagingState<Int, User>): Int? {
        return state.anchorPosition?.let { anchorPosition ->
            state.closestPageToPosition(anchorPosition)?.prevKey?.plus(1)
                ?: state.closestPageToPosition(anchorPosition)?.nextKey?.minus(1)
        }
    }

    override suspend fun load(params: LoadParams<Int>): LoadResult<Int, User> {
        val page = params.key ?: 1
        val response = searchService.searchUsers(
            query = query,
            page = page,
            perPage = 30,
        )

        return when (response) {
            is ApiResponse.Failure.Error -> {
                LoadResult.Error(Exception(response.message()))
            }

            is ApiResponse.Failure.Exception -> {
                Log.d("ApiResponse", response.exception.toString())
                LoadResult.Error(response.exception)
            }

            is ApiResponse.Success -> {
                val users = response.data.results.map { it.toUser() }
                LoadResult.Page(
                    data = users,
                    prevKey = if (page == 1) null else page.minus(1),
                    nextKey = if (users.isEmpty()) null else page.plus(1),
                )
            }
        }
    }
}