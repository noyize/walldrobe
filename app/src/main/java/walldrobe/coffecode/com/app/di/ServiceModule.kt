package walldrobe.coffecode.com.app.di

import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import retrofit2.Retrofit
import retrofit2.create
import walldrobe.coffecode.com.data.remote.collection.CollectionService
import walldrobe.coffecode.com.data.remote.photo.PhotoService
import walldrobe.coffecode.com.data.remote.search.SearchService
import walldrobe.coffecode.com.data.remote.topic.TopicService
import walldrobe.coffecode.com.data.remote.user.UserService
import javax.inject.Singleton

@Module
@InstallIn(SingletonComponent::class)
class ServiceModule {
    @Provides
    @Singleton
    fun provideTopicService(retrofit: Retrofit): TopicService = retrofit.create()

    @Provides
    @Singleton
    fun providePhotoService(retrofit: Retrofit): PhotoService = retrofit.create()

    @Provides
    @Singleton
    fun provideCollectionService(retrofit: Retrofit): CollectionService = retrofit.create()

    @Provides
    @Singleton
    fun provideSearchService(retrofit: Retrofit): SearchService = retrofit.create()

    @Provides
    @Singleton
    fun provideUserService(retrofit: Retrofit): UserService = retrofit.create()
}