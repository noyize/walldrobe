package walldrobe.coffecode.com.data.remote.topic.dto


import com.squareup.moshi.Json
import com.squareup.moshi.JsonClass
import androidx.annotation.Keep

@Keep
@JsonClass(generateAdapter = true)
data class TopicDto(
    @Json(name = "cover_photo")
    val coverPhoto: CoverPhoto?,
    @Json(name = "current_user_contributions")
    val currentUserContributions: List<Any?>?,
    @Json(name = "description")
    val description: String?,
    @Json(name = "ends_at")
    val endsAt: String?,
    @Json(name = "featured")
    val featured: Boolean?,
    @Json(name = "id")
    val id: String,
    @Json(name = "links")
    val links: Links?,
    @Json(name = "only_submissions_after")
    val onlySubmissionsAfter: Any?,
    @Json(name = "owners")
    val owners: List<Owner?>?,
    @Json(name = "preview_photos")
    val previewPhotos: List<PreviewPhoto?>?,
    @Json(name = "published_at")
    val publishedAt: String?,
    @Json(name = "slug")
    val slug: String?,
    @Json(name = "starts_at")
    val startsAt: String?,
    @Json(name = "status")
    val status: String?,
    @Json(name = "title")
    val title: String?,
    @Json(name = "top_contributors")
    val topContributors: List<TopContributor?>?,
    @Json(name = "total_current_user_submissions")
    val totalCurrentUserSubmissions: Any?,
    @Json(name = "total_photos")
    val totalPhotos: Int?,
    @Json(name = "updated_at")
    val updatedAt: String?,
    @Json(name = "visibility")
    val visibility: String?
) {
    @Keep
    @JsonClass(generateAdapter = true)
    data class CoverPhoto(
        @Json(name = "alt_description")
        val altDescription: Any?,
        @Json(name = "blur_hash")
        val blurHash: String?,
        @Json(name = "color")
        val color: String?,
        @Json(name = "created_at")
        val createdAt: String?,
        @Json(name = "current_user_collections")
        val currentUserCollections: List<Any?>?,
        @Json(name = "description")
        val description: Any?,
        @Json(name = "height")
        val height: Int?,
        @Json(name = "id")
        val id: String?,
        @Json(name = "liked_by_user")
        val likedByUser: Boolean?,
        @Json(name = "likes")
        val likes: Int?,
        @Json(name = "links")
        val links: Links?,
        @Json(name = "promoted_at")
        val promotedAt: Any?,
        @Json(name = "sponsorship")
        val sponsorship: Any?,
        @Json(name = "topic_submissions")
        val topicSubmissions: TopicSubmissions?,
        @Json(name = "updated_at")
        val updatedAt: String?,
        @Json(name = "urls")
        val urls: Urls?,
        @Json(name = "user")
        val user: User?,
        @Json(name = "width")
        val width: Int?
    ) {
        @Keep
        @JsonClass(generateAdapter = true)
        data class Links(
            @Json(name = "download")
            val download: String?,
            @Json(name = "download_location")
            val downloadLocation: String?,
            @Json(name = "html")
            val html: String?,
            @Json(name = "self")
            val self: String?
        )

        @Keep
        @JsonClass(generateAdapter = true)
        data class TopicSubmissions(
            @Json(name = "greener-cities")
            val greenerCities: GreenerCities?,
            @Json(name = "street-photography")
            val streetPhotography: StreetPhotography?
        ) {
            @Keep
            @JsonClass(generateAdapter = true)
            data class GreenerCities(
                @Json(name = "approved_on")
                val approvedOn: String?,
                @Json(name = "status")
                val status: String?
            )

            @Keep
            @JsonClass(generateAdapter = true)
            data class StreetPhotography(
                @Json(name = "status")
                val status: String?
            )
        }

        @Keep
        @JsonClass(generateAdapter = true)
        data class Urls(
            @Json(name = "full")
            val full: String?,
            @Json(name = "raw")
            val raw: String?,
            @Json(name = "regular")
            val regular: String?,
            @Json(name = "small")
            val small: String?,
            @Json(name = "small_s3")
            val smallS3: String?,
            @Json(name = "thumb")
            val thumb: String?
        )

        @Keep
        @JsonClass(generateAdapter = true)
        data class User(
            @Json(name = "accepted_tos")
            val acceptedTos: Boolean?,
            @Json(name = "bio")
            val bio: String?,
            @Json(name = "first_name")
            val firstName: String?,
            @Json(name = "for_hire")
            val forHire: Boolean?,
            @Json(name = "id")
            val id: String?,
            @Json(name = "instagram_username")
            val instagramUsername: Any?,
            @Json(name = "last_name")
            val lastName: String?,
            @Json(name = "links")
            val links: Links?,
            @Json(name = "location")
            val location: String?,
            @Json(name = "name")
            val name: String?,
            @Json(name = "portfolio_url")
            val portfolioUrl: Any?,
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
            val twitterUsername: Any?,
            @Json(name = "updated_at")
            val updatedAt: String?,
            @Json(name = "username")
            val username: String?
        ) {
            @Keep
            @JsonClass(generateAdapter = true)
            data class Links(
                @Json(name = "followers")
                val followers: String?,
                @Json(name = "following")
                val following: String?,
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
                val instagramUsername: Any?,
                @Json(name = "paypal_email")
                val paypalEmail: Any?,
                @Json(name = "portfolio_url")
                val portfolioUrl: Any?,
                @Json(name = "twitter_username")
                val twitterUsername: Any?
            )
        }
    }

    @Keep
    @JsonClass(generateAdapter = true)
    data class Links(
        @Json(name = "html")
        val html: String?,
        @Json(name = "photos")
        val photos: String?,
        @Json(name = "self")
        val self: String?
    )

    @Keep
    @JsonClass(generateAdapter = true)
    data class Owner(
        @Json(name = "accepted_tos")
        val acceptedTos: Boolean?,
        @Json(name = "bio")
        val bio: String?,
        @Json(name = "first_name")
        val firstName: String?,
        @Json(name = "for_hire")
        val forHire: Boolean?,
        @Json(name = "id")
        val id: String?,
        @Json(name = "instagram_username")
        val instagramUsername: String?,
        @Json(name = "last_name")
        val lastName: Any?,
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
        data class Links(
            @Json(name = "followers")
            val followers: String?,
            @Json(name = "following")
            val following: String?,
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
            @Json(name = "paypal_email")
            val paypalEmail: Any?,
            @Json(name = "portfolio_url")
            val portfolioUrl: String?,
            @Json(name = "twitter_username")
            val twitterUsername: String?
        )
    }

    @Keep
    @JsonClass(generateAdapter = true)
    data class PreviewPhoto(
        @Json(name = "blur_hash")
        val blurHash: String?,
        @Json(name = "created_at")
        val createdAt: String?,
        @Json(name = "id")
        val id: String?,
        @Json(name = "updated_at")
        val updatedAt: String?,
        @Json(name = "urls")
        val urls: Urls?
    ) {
        @Keep
        @JsonClass(generateAdapter = true)
        data class Urls(
            @Json(name = "full")
            val full: String?,
            @Json(name = "raw")
            val raw: String?,
            @Json(name = "regular")
            val regular: String?,
            @Json(name = "small")
            val small: String?,
            @Json(name = "small_s3")
            val smallS3: String?,
            @Json(name = "thumb")
            val thumb: String?
        )
    }

    @Keep
    @JsonClass(generateAdapter = true)
    data class TopContributor(
        @Json(name = "accepted_tos")
        val acceptedTos: Boolean?,
        @Json(name = "bio")
        val bio: String?,
        @Json(name = "first_name")
        val firstName: String?,
        @Json(name = "for_hire")
        val forHire: Boolean?,
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
        data class Links(
            @Json(name = "followers")
            val followers: String?,
            @Json(name = "following")
            val following: String?,
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
            @Json(name = "paypal_email")
            val paypalEmail: Any?,
            @Json(name = "portfolio_url")
            val portfolioUrl: String?,
            @Json(name = "twitter_username")
            val twitterUsername: String?
        )
    }
}