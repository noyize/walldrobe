package walldrobe.coffecode.com.data.repository

import androidx.paging.Pager
import androidx.paging.PagingConfig
import androidx.paging.PagingData
import com.skydoves.sandwich.suspendOnError
import com.skydoves.sandwich.suspendOnException
import com.skydoves.sandwich.suspendOnSuccess
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.flow
import kotlinx.coroutines.flow.flowOn
import walldrobe.coffecode.com.app.util.Resource
import walldrobe.coffecode.com.data.mapper.toCollection
import walldrobe.coffecode.com.data.mapper.toPhoto
import walldrobe.coffecode.com.data.remote.user.UserService
import walldrobe.coffecode.com.data.remote.user.paging.UserCollectionsPagingSource
import walldrobe.coffecode.com.data.remote.user.paging.UserLikesPagingSource
import walldrobe.coffecode.com.data.remote.user.paging.UserPhotosPagingSource
import walldrobe.coffecode.com.domain.model.Photo
import walldrobe.coffecode.com.domain.repository.UserRepository
import javax.inject.Inject

class UserRepositoryImpl @Inject constructor(
    private val userService: UserService
) : UserRepository {
    override fun getUserPhotos(username: String) = flow {
        emit(Resource.Loading)
        userService.getUserPhotos(
            username = username,
            page = 0,
            perPage = 30,
            orderBy = null,
            stats = null,
            resolution = null,
            quantity = null,
            orientation = null
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

    override fun getUserLikes(username: String) = flow {
        emit(Resource.Loading)
        userService.getUserLikes(
            username = username,
            page = 0,
            perPage = 30,
            orderBy = null,
            orientation = null
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

    override fun getUserCollections(username: String) = flow {
        emit(Resource.Loading)
        userService.getUserCollections(
            username = username,
            page = 0,
            perPage = 10,
        ).suspendOnSuccess {
            val collections = this.data.map { it.toCollection() }
            emit(Resource.Success(collections))
        }.suspendOnError {
            emit(Resource.Error(this.response.message()))
        }.suspendOnException {
            emit(Resource.Error(this.message ?: "Error getting latest photos"))
        }

    }.flowOn(Dispatchers.IO)


    override fun getPagedUserPhotos(username: String) = Pager(
        config = PagingConfig(
            pageSize = 30,
        ),
        pagingSourceFactory = {
            UserPhotosPagingSource(username = username, userService = userService)
        }
    ).flow

    override fun getPagedUserLikes(username: String): Flow<PagingData<Photo>> = Pager(
        config = PagingConfig(
            pageSize = 30,
        ),
        pagingSourceFactory = {
            UserLikesPagingSource(username = username, userService = userService)
        }
    ).flow

    override fun getPagedCollections(username: String) = Pager(
        config = PagingConfig(
            pageSize = 30,
        ),
        pagingSourceFactory = {
            UserCollectionsPagingSource(username = username, userService = userService)
        }
    ).flow
}