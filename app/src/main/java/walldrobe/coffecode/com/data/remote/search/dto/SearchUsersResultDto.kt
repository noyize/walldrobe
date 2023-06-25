package walldrobe.coffecode.com.data.remote.search.dto

import com.squareup.moshi.Json
import com.squareup.moshi.JsonClass
import walldrobe.coffecode.com.data.remote.user.dto.UserDto

@JsonClass(generateAdapter = true)
data class SearchUsersResultDto(
    @Json(name = "total")
    val total: Int,
    @Json(name = "total_pages")
    val totalPages: Int,
    @Json(name = "results")
    val results: List<UserDto>
)