package walldrobe.coffecode.com.data.remote.photo

import com.skydoves.sandwich.ApiResponse
import okhttp3.ResponseBody
import retrofit2.Response
import retrofit2.http.DELETE
import retrofit2.http.GET
import retrofit2.http.POST
import retrofit2.http.Path
import retrofit2.http.Query
import walldrobe.coffecode.com.data.remote.photo.dto.PhotoDto
import walldrobe.coffecode.com.data.remote.search.dto.SearchPhotosResultDto

interface PhotoService {

    @GET("photos")
    suspend fun getPhotos(
        @Query("page") page: Int?,
        @Query("per_page") perPage: Int?,
        @Query("order_by") orderBy: String?
    ): ApiResponse<List<PhotoDto>>

    @GET("collections/{id}/photos")
    suspend fun getCollectionPhotos(
        @Path("id") id: String,
        @Query("page") page: Int?,
        @Query("per_page") perPage: Int?
    ): ApiResponse<List<PhotoDto>>

    @GET("topics/{id_or_slug}/photos")
    suspend fun getTopicPhotos(
        @Path("id_or_slug") id: String,
        @Query("page") page: Int?,
        @Query("per_page") perPage: Int?
    ): ApiResponse<List<PhotoDto>>

    @GET("photos/{id}")
    suspend fun getPhoto(
        @Path("id") id: String
    ): ApiResponse<PhotoDto>

    @GET("photos/random")
    suspend fun getRandomPhotos(
        @Query("collections") collectionsId: String?,
        @Query("featured") featured: Boolean?,
        @Query("username") username: String?,
        @Query("query") query: String?,
        @Query("orientation") orientation: String?,
        @Query("content_filter") contentFilter: String?,
        @Query("count") count: Int?
    ): List<PhotoDto>




    @POST("photos/{id}/like")
    suspend fun likeAPhoto(
        @Path("id") id: String
    ): ResponseBody

    @DELETE("photos/{id}/like")
    suspend fun unlikeAPhoto(
        @Path("id") id: String
    ): Response<Unit>
}