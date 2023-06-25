package walldrobe.coffecode.com.data.remote.photo.dto


import com.squareup.moshi.Json
import com.squareup.moshi.JsonClass
import androidx.annotation.Keep
import walldrobe.coffecode.com.data.remote.collection.dto.CollectionDto
import walldrobe.coffecode.com.data.remote.user.dto.UserDto

@Keep
@JsonClass(generateAdapter = true)
data class PhotoDto(
    @Json(name = "alt_description")
    val altDescription: String?,
    @Json(name = "blur_hash")
    val blurHash: String,
    @Json(name = "color")
    val color: String?,
    @Json(name = "created_at")
    val createdAt: String?,
    @Json(name = "current_user_collections")
    val currentUserCollections: List<Any?>?,
    @Json(name = "description")
    val description: String?,
    @Json(name = "downloads")
    val downloads: Int?,
    @Json(name = "exif")
    val exif: Exif?,
    @Json(name = "height")
    val height: Int,
    @Json(name = "id")
    val id: String,
    @Json(name = "liked_by_user")
    val likedByUser: Boolean,
    @Json(name = "likes")
    val likes: Int?,
    @Json(name = "links")
    val links: Links?,
    @Json(name = "location")
    val location: Location?,
    @Json(name = "meta")
    val meta: Meta?,
    @Json(name = "promoted_at")
    val promotedAt: String?,
    @Json(name = "public_domain")
    val publicDomain: Boolean?,
    @Json(name = "related_collections")
    val relatedCollections: RelatedCollections?,
    @Json(name = "sponsorship")
    val sponsorship: Sponsorship?,
    @Json(name = "tags")
    val tags: List<Tag>?,
    @Json(name = "tags_preview")
    val tagsPreview: List<TagsPreview?>?,
    @Json(name = "topic_submissions")
    val topicSubmissions: TopicSubmissions?,
    @Json(name = "topics")
    val topics: List<Any?>?,
    @Json(name = "updated_at")
    val updatedAt: String?,
    @Json(name = "urls")
    val urls: Urls?,
    @Json(name = "user")
    val user: UserDto?,
    @Json(name = "views")
    val views: Int?,
    @Json(name = "width")
    val width: Int,
) {

    @Keep
    @JsonClass(generateAdapter = true)
    data class Sponsorship(
        @Json(name = "sponsor")
        val sponsor: User?
    )
    @Keep
    @JsonClass(generateAdapter = true)
    data class Exif(
        @Json(name = "aperture")
        val aperture: String?,
        @Json(name = "exposure_time")
        val exposureTime: String?,
        @Json(name = "focal_length")
        val focalLength: String?,
        @Json(name = "iso")
        val iso: Int?,
        @Json(name = "make")
        val make: String?,
        @Json(name = "model")
        val model: String?,
        @Json(name = "name")
        val name: String?
    )

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
    data class Location(
        @Json(name = "city")
        val city: Any?,
        @Json(name = "country")
        val country: Any?,
        @Json(name = "name")
        val name: String?,
        @Json(name = "position")
        val position: Position?
    ) {
        @Keep
        @JsonClass(generateAdapter = true)
        data class Position(
            @Json(name = "latitude")
            val latitude: Double?,
            @Json(name = "longitude")
            val longitude: Double?
        )
    }

    @Keep
    @JsonClass(generateAdapter = true)
    data class Meta(
        @Json(name = "index")
        val index: Boolean?
    )

    @Keep
    @JsonClass(generateAdapter = true)
    data class RelatedCollections(
        @Json(name = "results")
        val results: List<CollectionDto>?,
        @Json(name = "total")
        val total: Int?,
        @Json(name = "type")
        val type: String?
    ) {
        @Keep
        @JsonClass(generateAdapter = true)
        data class Result(
            @Json(name = "cover_photo")
            val coverPhoto: CoverPhoto,
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
            val previewPhotos: List<PreviewPhoto?>?,
            @Json(name = "private")
            val `private`: Boolean?,
            @Json(name = "published_at")
            val publishedAt: String?,
            @Json(name = "share_key")
            val shareKey: String?,
            @Json(name = "tags")
            val tags: List<Tag?>?,
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
                val color: String,
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
                @Json(name = "sponsorship")
                val sponsorship: Any?,
                @Json(name = "topic_submissions")
                val topicSubmissions: TopicSubmissions?,
                @Json(name = "updated_at")
                val updatedAt: String?,
                @Json(name = "urls")
                val urls: Urls,
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
                    @Json(name = "food-drink")
                    val foodDrink: FoodDrink?,
                    @Json(name = "health")
                    val health: Health?
                ) {
                    @Keep
                    @JsonClass(generateAdapter = true)
                    data class FoodDrink(
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
                }

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

                @Keep
                @JsonClass(generateAdapter = true)
                data class User(
                    @Json(name = "accepted_tos")
                    val acceptedTos: Boolean?,
                    @Json(name = "bio")
                    val bio: Any?,
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
                    val location: Any?,
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
            data class Tag(
                @Json(name = "source")
                val source: Source?,
                @Json(name = "title")
                val title: String?,
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
                            @Json(name = "health")
                            val health: Health?,
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
                            data class Health(
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
                val bio: Any?,
                @Json(name = "first_name")
                val firstName: String?,
                @Json(name = "for_hire")
                val forHire: Boolean?,
                @Json(name = "id")
                val id: String,
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
                    @Json(name = "current-events")
                    val currentEvents: CurrentEvents?,
                    @Json(name = "health")
                    val health: Health?,
                    @Json(name = "nature")
                    val nature: Nature?,
                    @Json(name = "people")
                    val people: People?
                ) {
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
    data class TagsPreview(
        @Json(name = "source")
        val source: Source?,
        @Json(name = "title")
        val title: String?,
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
                @Json(name = "plus")
                val plus: Boolean?,
                @Json(name = "premium")
                val premium: Boolean?,
                @Json(name = "promoted_at")
                val promotedAt: String?,
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
                class TopicSubmissions

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
                    val bio: Any?,
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
                        val instagramUsername: String?,
                        @Json(name = "paypal_email")
                        val paypalEmail: Any?,
                        @Json(name = "portfolio_url")
                        val portfolioUrl: Any?,
                        @Json(name = "twitter_username")
                        val twitterUsername: Any?
                    )
                }
            }
        }
    }

    @Keep
    @JsonClass(generateAdapter = true)
    class TopicSubmissions

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
        val id: String,
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