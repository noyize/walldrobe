package walldrobe.coffecode.com.data.remote.search.dto

import com.squareup.moshi.Json
import com.squareup.moshi.JsonClass
import walldrobe.coffecode.com.data.remote.photo.dto.PhotoDto

@JsonClass(generateAdapter = true)
data class SearchPhotosResultDto(
    @Json(name = "total")
    val total: Int,
    @Json(name = "total_pages")
    val totalPages: Int,
    @Json(name = "results")
    val results: List<PhotoDto>
)