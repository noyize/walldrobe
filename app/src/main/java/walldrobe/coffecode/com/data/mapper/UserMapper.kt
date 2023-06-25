package walldrobe.coffecode.com.data.mapper

import walldrobe.coffecode.com.data.remote.user.dto.UserDto
import walldrobe.coffecode.com.domain.model.User

fun UserDto.toUser() = User(
    name = name.orEmpty(),
    username = username.orEmpty(),
    userId = id.orEmpty(),
    profileImageRegular = profileImage?.medium.orEmpty(),
    profileImageLarge = profileImage?.large.orEmpty(),
    twitterUrl = "https://www.twitter.com/${social?.twitterUsername}",
    instagramUrl = "https://www.instagram.com/${social?.instagramUsername}",
    portfolioUrl = "https://www.instagram.com/$portfolioUrl",
    bio = bio.orEmpty(),
    totalPhotos = totalPhotos ?: 0,
    totalCollections = totalCollections ?: 0,
    totalLikes = totalLikes ?: 0
)