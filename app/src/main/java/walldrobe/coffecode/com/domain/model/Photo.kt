package walldrobe.coffecode.com.domain.model

import android.os.Parcelable
import androidx.annotation.Keep
import kotlinx.parcelize.Parcelize

@Parcelize
@Keep
data class Photo(
    val id: String,
    val thumbUrl: String,
    val regularUrl: String,
    val fullUrl: String,
    val blurHash: String,
    val color: String,
    val description: String,
    val downloads: String,
    val views: String,
    val publishedOn: String,
    val likes: String,
    val cameraMake: String,
    val cameraModel: String,
    val size: String,
    val focalLength: String,
    val aperture: String,
    val exposureTime: String,
    val iso: String,
    val tags: List<String>,
    val likedByUser: Boolean,
    val location: String,
    val relatedCollections: List<Collection>,
    val width: Int,
    val height: Int,
    val user: User?
) : Parcelable
