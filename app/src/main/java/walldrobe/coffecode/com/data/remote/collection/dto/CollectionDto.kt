package walldrobe.coffecode.com.data.remote.collection.dto


import com.squareup.moshi.Json
import com.squareup.moshi.JsonClass
import androidx.annotation.Keep


@Keep
@JsonClass(generateAdapter = true)
data class CollectionDto(
    @Json(name = "cover_photo")
    val coverPhoto: CoverPhoto?,
    @Json(name = "curated")
    val curated: Boolean?,
    @Json(name = "description")
    val description: String?,
    @Json(name = "featured")
    val featured: Boolean?,
    @Json(name = "id")
    val id: String,
    @Json(name = "last_collected_at")
    val lastCollectedAt: String?,
    @Json(name = "links")
    val links: Links?,
    @Json(name = "preview_photos")
    val previewPhotos: List<PreviewPhoto>?,
    @Json(name = "private")
    val `private`: Boolean?,
    @Json(name = "published_at")
    val publishedAt: String?,
    @Json(name = "share_key")
    val shareKey: String?,
    @Json(name = "tags")
    val tags: List<Tag>?,
    @Json(name = "title")
    val title: String,
    @Json(name = "total_photos")
    val totalPhotos: Int?,
    @Json(name = "updated_at")
    val updatedAt: String?,
    @Json(name = "user")
    val user: User?
) {
    @Keep
    @JsonClass(generateAdapter = true)
    data class CoverPhoto(
        @Json(name = "alt_description")
        val altDescription: String?,
        @Json(name = "blur_hash")
        val blurHash: String?,
        @Json(name = "color")
        val color: String?,
        @Json(name = "created_at")
        val createdAt: String?,
        @Json(name = "current_user_collections")
        val currentUserCollections: List<Any?>?,
        @Json(name = "description")
        val description: String?,
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
        val promotedAt: String?,
        @Json(name = "slug")
        val slug: String?,
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
            @Json(name = "architecture-interior")
            val architectureInterior: ArchitectureInterior?,
            @Json(name = "arts-culture")
            val artsCulture: ArtsCulture?,
            @Json(name = "business-work")
            val businessWork: BusinessWork?,
            @Json(name = "interiors")
            val interiors: Interiors?
        ) {
            @Keep
            @JsonClass(generateAdapter = true)
            data class ArchitectureInterior(
                @Json(name = "approved_on")
                val approvedOn: String?,
                @Json(name = "status")
                val status: String?
            )

            @Keep
            @JsonClass(generateAdapter = true)
            data class ArtsCulture(
                @Json(name = "approved_on")
                val approvedOn: String?,
                @Json(name = "status")
                val status: String?
            )

            @Keep
            @JsonClass(generateAdapter = true)
            data class BusinessWork(
                @Json(name = "approved_on")
                val approvedOn: String?,
                @Json(name = "status")
                val status: String?
            )

            @Keep
            @JsonClass(generateAdapter = true)
            data class Interiors(
                @Json(name = "approved_on")
                val approvedOn: String?,
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

    @Keep
    @JsonClass(generateAdapter = true)
    data class Links(
        @Json(name = "html")
        val html: String?,
        @Json(name = "photos")
        val photos: String?,
        @Json(name = "related")
        val related: String?,
        @Json(name = "self")
        val self: String?
    )

    @Keep
    @JsonClass(generateAdapter = true)
    data class PreviewPhoto(
        @Json(name = "blur_hash")
        val blurHash: String?,
        @Json(name = "created_at")
        val createdAt: String?,
        @Json(name = "id")
        val id: String,
        @Json(name = "slug")
        val slug: String?,
        @Json(name = "updated_at")
        val updatedAt: String?,
        @Json(name = "urls")
        val urls: Urls
    ) {
        @Keep
        @JsonClass(generateAdapter = true)
        data class Urls(
            @Json(name = "full")
            val full: String?,
            @Json(name = "raw")
            val raw: String?,
            @Json(name = "regular")
            val regular: String,
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
    data class Tag(
        @Json(name = "source")
        val source: Source?,
        @Json(name = "title")
        val title: String,
        @Json(name = "type")
        val type: String?
    ) {
        @Keep
        @JsonClass(generateAdapter = true)
        data class Source(
            @Json(name = "ancestry")
            val ancestry: Ancestry?,
            @Json(name = "cover_photo")
            val coverPhoto: CoverPhoto?,
            @Json(name = "description")
            val description: String?,
            @Json(name = "meta_description")
            val metaDescription: String?,
            @Json(name = "meta_title")
            val metaTitle: String?,
            @Json(name = "subtitle")
            val subtitle: String?,
            @Json(name = "title")
            val title: String?
        ) {
            @Keep
            @JsonClass(generateAdapter = true)
            data class Ancestry(
                @Json(name = "category")
                val category: Category?,
                @Json(name = "subcategory")
                val subcategory: Subcategory?,
                @Json(name = "type")
                val type: Type?
            ) {
                @Keep
                @JsonClass(generateAdapter = true)
                data class Category(
                    @Json(name = "pretty_slug")
                    val prettySlug: String?,
                    @Json(name = "slug")
                    val slug: String?
                )

                @Keep
                @JsonClass(generateAdapter = true)
                data class Subcategory(
                    @Json(name = "pretty_slug")
                    val prettySlug: String?,
                    @Json(name = "slug")
                    val slug: String?
                )

                @Keep
                @JsonClass(generateAdapter = true)
                data class Type(
                    @Json(name = "pretty_slug")
                    val prettySlug: String?,
                    @Json(name = "slug")
                    val slug: String?
                )
            }

            @Keep
            @JsonClass(generateAdapter = true)
            data class CoverPhoto(
                @Json(name = "alt_description")
                val altDescription: String?,
                @Json(name = "blur_hash")
                val blurHash: String?,
                @Json(name = "color")
                val color: String?,
                @Json(name = "created_at")
                val createdAt: String?,
                @Json(name = "current_user_collections")
                val currentUserCollections: List<Any?>?,
                @Json(name = "description")
                val description: String?,
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
                @Json(name = "plus")
                val plus: Boolean?,
                @Json(name = "premium")
                val premium: Boolean?,
                @Json(name = "promoted_at")
                val promotedAt: String?,
                @Json(name = "slug")
                val slug: String?,
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
                    @Json(name = "architecture-interior")
                    val architectureInterior: ArchitectureInterior?,
                    @Json(name = "arts-culture")
                    val artsCulture: ArtsCulture?,
                    @Json(name = "athletics")
                    val athletics: Athletics?,
                    @Json(name = "color-of-water")
                    val colorOfWater: ColorOfWater?,
                    @Json(name = "current-events")
                    val currentEvents: CurrentEvents?,
                    @Json(name = "health")
                    val health: Health?,
                    @Json(name = "nature")
                    val nature: Nature?,
                    @Json(name = "people")
                    val people: People?,
                    @Json(name = "spirituality")
                    val spirituality: Spirituality?,
                    @Json(name = "textures-patterns")
                    val texturesPatterns: TexturesPatterns?,
                    @Json(name = "wallpapers")
                    val wallpapers: Wallpapers?
                ) {
                    @Keep
                    @JsonClass(generateAdapter = true)
                    data class ArchitectureInterior(
                        @Json(name = "approved_on")
                        val approvedOn: String?,
                        @Json(name = "status")
                        val status: String?
                    )

                    @Keep
                    @JsonClass(generateAdapter = true)
                    data class ArtsCulture(
                        @Json(name = "approved_on")
                        val approvedOn: String?,
                        @Json(name = "status")
                        val status: String?
                    )

                    @Keep
                    @JsonClass(generateAdapter = true)
                    data class Athletics(
                        @Json(name = "approved_on")
                        val approvedOn: String?,
                        @Json(name = "status")
                        val status: String?
                    )

                    @Keep
                    @JsonClass(generateAdapter = true)
                    data class ColorOfWater(
                        @Json(name = "approved_on")
                        val approvedOn: String?,
                        @Json(name = "status")
                        val status: String?
                    )

                    @Keep
                    @JsonClass(generateAdapter = true)
                    data class CurrentEvents(
                        @Json(name = "approved_on")
                        val approvedOn: String?,
                        @Json(name = "status")
                        val status: String?
                    )

                    @Keep
                    @JsonClass(generateAdapter = true)
                    data class Health(
                        @Json(name = "approved_on")
                        val approvedOn: String?,
                        @Json(name = "status")
                        val status: String?
                    )

                    @Keep
                    @JsonClass(generateAdapter = true)
                    data class Nature(
                        @Json(name = "approved_on")
                        val approvedOn: String?,
                        @Json(name = "status")
                        val status: String?
                    )

                    @Keep
                    @JsonClass(generateAdapter = true)
                    data class People(
                        @Json(name = "approved_on")
                        val approvedOn: String?,
                        @Json(name = "status")
                        val status: String?
                    )

                    @Keep
                    @JsonClass(generateAdapter = true)
                    data class Spirituality(
                        @Json(name = "approved_on")
                        val approvedOn: String?,
                        @Json(name = "status")
                        val status: String?
                    )

                    @Keep
                    @JsonClass(generateAdapter = true)
                    data class TexturesPatterns(
                        @Json(name = "approved_on")
                        val approvedOn: String?,
                        @Json(name = "status")
                        val status: String?
                    )

                    @Keep
                    @JsonClass(generateAdapter = true)
                    data class Wallpapers(
                        @Json(name = "approved_on")
                        val approvedOn: String?,
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
        }
    }

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
