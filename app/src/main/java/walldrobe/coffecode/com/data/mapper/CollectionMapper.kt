package walldrobe.coffecode.com.data.mapper

import walldrobe.coffecode.com.data.remote.collection.dto.CollectionDto
import walldrobe.coffecode.com.domain.model.Collection
import walldrobe.coffecode.com.app.util.toPrettyString

fun CollectionDto.toCollection() = Collection(
    id = id,
    title = title,
    description = description.orEmpty(),
    username = user?.name.orEmpty(),
    userImage = user?.profileImage?.medium.orEmpty(),
    coverPhoto = coverPhoto?.urls?.regular.orEmpty(),
    tags = tags?.map { it.title } ?: emptyList(),
    totalPhotos = totalPhotos?.toPrettyString() ?: "0",
    color = coverPhoto?.color ?: "#FFFFFF"
)