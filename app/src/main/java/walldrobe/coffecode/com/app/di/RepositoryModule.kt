package walldrobe.coffecode.com.app.di

import dagger.Binds
import dagger.Module
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import walldrobe.coffecode.com.data.repository.CollectionRepositoryImpl
import walldrobe.coffecode.com.data.repository.PhotoRepositoryImpl
import walldrobe.coffecode.com.data.repository.SearchRepositoryImpl
import walldrobe.coffecode.com.data.repository.TopicRepositoryImpl
import walldrobe.coffecode.com.data.repository.UserRepositoryImpl
import walldrobe.coffecode.com.domain.repository.CollectionRepository
import walldrobe.coffecode.com.domain.repository.PhotoRepository
import walldrobe.coffecode.com.domain.repository.SearchRepository
import walldrobe.coffecode.com.domain.repository.TopicRepository
import walldrobe.coffecode.com.domain.repository.UserRepository

@Module
@InstallIn(SingletonComponent::class)
abstract class RepositoryModule {

    @Binds
    abstract fun bindPhotoRepository(photoRepositoryImpl: PhotoRepositoryImpl): PhotoRepository

    @Binds
    abstract fun bindCollectionRepository(collectionRepositoryImpl: CollectionRepositoryImpl): CollectionRepository

    @Binds
    abstract fun bindTopicRepository(topicRepositoryImpl: TopicRepositoryImpl): TopicRepository

    @Binds
    abstract fun bindSearchRepository(searchRepositoryImpl: SearchRepositoryImpl): SearchRepository

    @Binds
    abstract fun bindUserRepository(userRepositoryImpl: UserRepositoryImpl): UserRepository

}