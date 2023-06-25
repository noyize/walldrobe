package walldrobe.coffecode.com.domain.model

import android.os.Parcelable
import kotlinx.parcelize.Parcelize

@Parcelize
data class Topic(
    val id: String,
    val title: String,
    val description: String,
    val coverPhoto:String,
    val color: String
): Parcelable
