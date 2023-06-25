package walldrobe.coffecode.com.data.remote.search.dto

import com.squareup.moshi.Json
import com.squareup.moshi.JsonClass
import walldrobe.coffecode.com.data.remote.collection.dto.CollectionDto

@JsonClass(generateAdapter = true)
data class SearchCollectionsResultDto(
    @Json(name = "total")
    val total: Int,
    @Json(name = "total_pages")
    val totalPages: Int,
    @Json(name = "results")
    val results: List<CollectionDto>
)