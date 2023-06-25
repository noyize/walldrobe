package walldrobe.coffecode.com.data.remote.user.dto


import com.squareup.moshi.Json
import com.squareup.moshi.JsonClass
import androidx.annotation.Keep

@Keep
@JsonClass(generateAdapter = true)
data class UserDto(
    @Json(name = "badge")
    val badge: Badge?,
    @Json(name = "bio")
    val bio: String?,
    @Json(name = "downloads")
    val downloads: Int?,
    @Json(name = "first_name")
    val firstName: String?,
    @Json(name = "followed_by_user")
    val followedByUser: Boolean?,
    @Json(name = "followers_count")
    val followersCount: Int?,
    @Json(name = "following_count")
    val followingCount: Int?,
    @Json(name = "id")
    val id: String?,
    @Json(name = "instagram_username")
    val instagramUsername: String?,
    @Json(name = "last_name")
    val lastName: String?,
    @Json(name = "links")
    val links: Links?,
    @Json(name = "location")
    val location: String?,
    @Json(name = "name")
    val name: String?,
    @Json(name = "portfolio_url")
    val portfolioUrl: String?,
    @Json(name = "profile_image")
    val profileImage: ProfileImage?,
    @Json(name = "social")
    val social: Social?,
    @Json(name = "total_collections")
    val totalCollections: Int?,
    @Json(name = "total_likes")
    val totalLikes: Int?,
    @Json(name = "total_photos")
    val totalPhotos: Int?,
    @Json(name = "twitter_username")
    val twitterUsername: String?,
    @Json(name = "updated_at")
    val updatedAt: String?,
    @Json(name = "username")
    val username: String?
) {
    @Keep
    @JsonClass(generateAdapter = true)
    data class Badge(
        @Json(name = "link")
        val link: String?,
        @Json(name = "primary")
        val primary: Boolean?,
        @Json(name = "slug")
        val slug: String?,
        @Json(name = "title")
        val title: String?
    )

    @Keep
    @JsonClass(generateAdapter = true)
    data class Links(
        @Json(name = "html")
        val html: String?,
        @Json(name = "likes")
        val likes: String?,
        @Json(name = "photos")
        val photos: String?,
        @Json(name = "portfolio")
        val portfolio: String?,
        @Json(name = "self")
        val self: String?
    )

    @Keep
    @JsonClass(generateAdapter = true)
    data class ProfileImage(
        @Json(name = "large")
        val large: String?,
        @Json(name = "medium")
        val medium: String?,
        @Json(name = "small")
        val small: String?
    )

    @Keep
    @JsonClass(generateAdapter = true)
    data class Social(
        @Json(name = "instagram_username")
        val instagramUsername: String?,
        @Json(name = "portfolio_url")
        val portfolioUrl: String?,
        @Json(name = "twitter_username")
        val twitterUsername: String?
    )
}