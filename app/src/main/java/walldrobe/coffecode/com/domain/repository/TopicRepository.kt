package walldrobe.coffecode.com.domain.repository

import kotlinx.coroutines.flow.Flow
import walldrobe.coffecode.com.app.util.Resource
import walldrobe.coffecode.com.domain.model.Topic

interface TopicRepository {

    suspend fun getTopics() : Flow<Resource<List<Topic>>>
}