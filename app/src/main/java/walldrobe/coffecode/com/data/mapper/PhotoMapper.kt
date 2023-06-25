package walldrobe.coffecode.com.data.mapper

import walldrobe.coffecode.com.app.util.dateConvert
import walldrobe.coffecode.com.app.util.toPrettyString
import walldrobe.coffecode.com.data.remote.photo.dto.PhotoDto
import walldrobe.coffecode.com.domain.model.Photo

fun PhotoDto.toPhoto() = Photo(
    id = id,
    thumbUrl = urls?.thumb.orEmpty(),
    regularUrl = urls?.regular.orEmpty(),
    fullUrl = urls?.full.orEmpty(),
    blurHash = blurHash,
    color = color ?: "#FFFFFF",
    description = description.orEmpty(),
    downloads = downloads?.toPrettyString() ?: "0",
    publishedOn = dateConvert(createdAt.toString()),
    likes = likes?.toPrettyString() ?: "0",
    views = views?.toPrettyString() ?: "0",
    cameraMake = exif?.make ?: "Unknown",
    cameraModel = exif?.model ?: "Unknown",
    size = "$width x $height",
    focalLength = if (exif?.focalLength != null) exif.focalLength + "mm" else "Unknown",
    aperture = if (exif?.aperture != null) "f/" + exif.aperture else "Unknown",
    exposureTime = if (exif?.exposureTime != null) exif.exposureTime + "s" else "Unknown",
    iso = if (exif?.iso != null) exif.iso.toString() else "Unknown",
    tags = tags?.map { it.title } ?: emptyList(),
    likedByUser = likedByUser,
    location = location?.name.orEmpty(),
    relatedCollections = relatedCollections?.results?.map { it.toCollection()} ?: emptyList(),
    width = width,
    height = height,
    user = user?.toUser()
)


