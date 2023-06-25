package walldrobe.coffecode.com.data.mapper

import walldrobe.coffecode.com.data.remote.topic.dto.TopicDto
import walldrobe.coffecode.com.domain.model.Topic

fun TopicDto.toTopics() = Topic(
    id = id,
    title = title.orEmpty(),
    description = description.orEmpty(),
    coverPhoto = coverPhoto?.urls?.regular.orEmpty(),
    color = coverPhoto?.color ?: "#FFFFFF"
)