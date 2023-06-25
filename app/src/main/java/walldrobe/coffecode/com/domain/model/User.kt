package walldrobe.coffecode.com.domain.model

import android.os.Parcelable
import kotlinx.parcelize.Parcelize

@Parcelize
data class User(
    val name: String,
    val username: String,
    val userId: String,
    val profileImageRegular: String,
    val profileImageLarge: String,
    val bio: String,
    val twitterUrl: String,
    val instagramUrl: String,
    val portfolioUrl:String,
    val totalLikes: Int,
    val totalCollections: Int,
    val totalPhotos: Int
) : Parcelable
