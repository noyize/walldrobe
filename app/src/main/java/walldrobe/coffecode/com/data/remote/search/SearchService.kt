package walldrobe.coffecode.com.data.remote.search

import com.skydoves.sandwich.ApiResponse
import retrofit2.http.GET
import retrofit2.http.Query
import walldrobe.coffecode.com.data.remote.search.dto.SearchCollectionsResultDto
import walldrobe.coffecode.com.data.remote.search.dto.SearchPhotosResultDto
import walldrobe.coffecode.com.data.remote.search.dto.SearchUsersResultDto

interface SearchService {

    @GET("search/photos")
    suspend fun searchPhotos(
        @Query("query") query: String,
        @Query("page") page: Int?,
        @Query("per_page") perPage: Int?
    ): ApiResponse<SearchPhotosResultDto>

    @GET("search/collections")
    suspend fun searchCollections(
        @Query("query") query: String,
        @Query("page") page: Int?,
        @Query("per_page") perPage: Int?
    ): ApiResponse<SearchCollectionsResultDto>

    @GET("search/users")
    suspend fun searchUsers(
        @Query("query") query: String,
        @Query("page") page: Int?,
        @Query("per_page") perPage: Int?
    ): ApiResponse<SearchUsersResultDto>
}