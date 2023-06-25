package walldrobe.coffecode.com.data.remote.photo.paging

import androidx.paging.PagingSource
import androidx.paging.PagingState
import com.skydoves.sandwich.ApiResponse
import com.skydoves.sandwich.message
import walldrobe.coffecode.com.data.remote.photo.PhotoService
import walldrobe.coffecode.com.data.mapper.toPhoto
import walldrobe.coffecode.com.domain.model.Photo

class TopicPhotosPagingSource (
    private val photoService: PhotoService,
    private val id: String
) : PagingSource<Int, Photo>() {
    override fun getRefreshKey(state: PagingState<Int, Photo>): Int? {
        return state.anchorPosition?.let { anchorPosition ->
            state.closestPageToPosition(anchorPosition)?.prevKey?.plus(1)
                ?: state.closestPageToPosition(anchorPosition)?.nextKey?.minus(1)
        }
    }

    override suspend fun load(params: LoadParams<Int>): LoadResult<Int, Photo> {
        val page = params.key ?: 1
        val response = photoService.getTopicPhotos(
            id = id,
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
                val photos = response.data.map { it.toPhoto() }
                LoadResult.Page(
                    data = photos,
                    prevKey = if (page == 1) null else page.minus(1),
                    nextKey = if (photos.isEmpty()) null else page.plus(1),
                )
            }
        }
    }
}