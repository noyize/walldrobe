package walldrobe.coffecode.com.data.remote.topic

import com.skydoves.sandwich.ApiResponse
import retrofit2.http.GET
import retrofit2.http.Path
import retrofit2.http.Query
import walldrobe.coffecode.com.data.remote.topic.dto.TopicDto

interface TopicService {

    @GET("topics")
    suspend fun getTopics(
        @Query("page") page: Int?,
        @Query("per_page") perPage: Int?,
        @Query("order_by") orderBy: String?
    ): ApiResponse<List<TopicDto>>


    @GET("topics/{id}")
    suspend fun getTopic(
        @Path("id") id: String
    ): ApiResponse<TopicDto>

}