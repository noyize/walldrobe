package walldrobe.coffecode.com.data.repository

import androidx.paging.Pager
import androidx.paging.PagingConfig
import com.skydoves.sandwich.suspendOnError
import com.skydoves.sandwich.suspendOnException
import com.skydoves.sandwich.suspendOnSuccess
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.flow.flow
import kotlinx.coroutines.flow.flowOn
import walldrobe.coffecode.com.app.util.Resource
import walldrobe.coffecode.com.data.mapper.toPhoto
import walldrobe.coffecode.com.data.remote.photo.paging.CollectionPhotosPagingSource
import walldrobe.coffecode.com.data.remote.photo.paging.LatestPhotosPagingSource
import walldrobe.coffecode.com.data.remote.photo.PhotoService
import walldrobe.coffecode.com.data.remote.search.paging.SearchPhotosPagingSource
import walldrobe.coffecode.com.data.remote.photo.paging.TopicPhotosPagingSource
import walldrobe.coffecode.com.domain.repository.PhotoRepository
import javax.inject.Inject

class PhotoRepositoryImpl @Inject constructor(
    private val photoService: PhotoService
) : PhotoRepository {
    override suspend fun getLatestPhotos() = flow {
        emit(Resource.Loading)
        photoService.getPhotos(
            page = 0,
            perPage = 30,
            orderBy = null
        ).suspendOnSuccess {
            val photos = this.data
            val latestPhotos =
                photos.filter { it.sponsorship == null }.map { it.toPhoto() }
            emit(Resource.Success(latestPhotos))
        }.suspendOnError {
            emit(Resource.Error(this.response.message()))
        }.suspendOnException {
            emit(Resource.Error(this.message ?: "Error getting latest photos"))
        }

    }.flowOn(Dispatchers.IO)

    override suspend fun getCuratedPhotos() = flow {
        emit(Resource.Loading)
        photoService.getTopicPhotos(
            id = "wallpapers",
            page = 0,
            perPage = 30
        ).suspendOnSuccess {
            val photos = this.data
            val curatedPhotos = photos.map { it.toPhoto() }
            emit(Resource.Success(curatedPhotos))
        }.suspendOnError {
            emit(Resource.Error(this.response.message()))
        }.suspendOnException {
            emit(Resource.Error(this.message ?: "Error getting curated photos"))
        }
    }.flowOn(Dispatchers.IO)

    override suspend fun getBanners() = flow {
        emit(Resource.Loading)
        photoService.getCollectionPhotos(
            id = "jCv4GDTDPyU",
            page = 0,
            perPage = 3
        ).suspendOnSuccess {
            val photos = this.data
            val bannerPhotos = photos.map { it.toPhoto() }
            emit(Resource.Success(bannerPhotos))
        }.suspendOnError {
            emit(Resource.Error(this.response.message()))
        }.suspendOnException {
            emit(Resource.Error(this.message ?: "Error getting curated photos"))
        }
    }.flowOn(Dispatchers.IO)

    override fun getPhoto(id: String) = flow {
        emit(Resource.Loading)
        photoService.getPhoto(id).suspendOnSuccess {
            val photo = this.data.toPhoto()
            emit(Resource.Success(photo))
        }.suspendOnError {
            emit(Resource.Error(this.response.message()))
        }.suspendOnException {
            emit(Resource.Error(this.message ?: "Error occurred"))
        }
    }.flowOn(Dispatchers.IO)

    override fun getPaginatedLatestPhotos() = Pager(
        config = PagingConfig(
            pageSize = 30,
        ),
        pagingSourceFactory = {
            LatestPhotosPagingSource(photoService = photoService)
        }
    ).flow

    override fun getTopicPhotos(id: String) = Pager(
        config = PagingConfig(
            pageSize = 30,
        ),
        pagingSourceFactory = {
            TopicPhotosPagingSource(photoService = photoService, id = id)
        }
    ).flow

    override fun getCollectionPhotos(id: String) = Pager(
        config = PagingConfig(
            pageSize = 30,
        ),
        pagingSourceFactory = {
            CollectionPhotosPagingSource(photoService = photoService, id = id)
        }
    ).flow



}