package walldrobe.coffecode.com.domain.model

import android.os.Parcelable
import kotlinx.parcelize.Parcelize

@Parcelize
data class Collection(
    val id: String,
    val title: String,
    val description: String,
    val username: String,
    val userImage: String,
    val tags: List<String>,
    val coverPhoto: String,
    val color: String,
    val totalPhotos: String
): Parcelable