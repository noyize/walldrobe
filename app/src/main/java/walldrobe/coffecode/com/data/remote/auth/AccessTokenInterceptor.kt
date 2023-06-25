package walldrobe.coffecode.com.data.remote.auth

import okhttp3.Interceptor
import okhttp3.Response
import walldrobe.coffecode.com.BuildConfig

class AccessTokenInterceptor(private val accessTokenProvider: AccessTokenProvider) : Interceptor {

    override fun intercept(chain: Interceptor.Chain): Response {
//        return
//        if (accessTokenProvider.isAuthorized) {
//            val token = accessTokenProvider.accessToken
//            val authenticatedRequest = chain.request()
//                .newBuilder()
//                .addHeader("Authorization", "Bearer $token")
//                .build()
//            chain.proceed(authenticatedRequest)
//        } else {
            val clientId = BuildConfig.DEV_APP_ID
            val authenticatedRequest = chain.request()
                .newBuilder()
                .addHeader("Authorization", "Client-ID $clientId")
                .build()
           return chain.proceed(authenticatedRequest)
//        }

    }
}