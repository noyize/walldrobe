package walldrobe.coffecode.com.data.repository

import com.skydoves.sandwich.suspendOnError
import com.skydoves.sandwich.suspendOnException
import com.skydoves.sandwich.suspendOnSuccess
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.flow.flow
import kotlinx.coroutines.flow.flowOn
import walldrobe.coffecode.com.app.util.Resource
import walldrobe.coffecode.com.data.mapper.toTopics
import walldrobe.coffecode.com.data.remote.topic.TopicService
import walldrobe.coffecode.com.domain.repository.TopicRepository
import javax.inject.Inject

class TopicRepositoryImpl @Inject constructor(
    private val topicService: TopicService
) : TopicRepository {
    override suspend fun getTopics() = flow {
        emit(Resource.Loading)
        topicService.getTopics(
            page = 0,
            perPage = 30,
            orderBy = null
        ).suspendOnSuccess {
            val topics = this.data.map { it.toTopics() }.filterNot { it.title == "Wallpapers" }
            emit(Resource.Success(topics))
        }.suspendOnError {
            emit(Resource.Error(this.response.message()))
        }.suspendOnException {
            emit(Resource.Error(this.message ?: "Error occurred"))
        }
    }.flowOn(Dispatchers.IO)

}