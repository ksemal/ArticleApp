package com.example.articleapp.presentation.di

import com.example.articleapp.data.repository.NewsRepositoryImpl
import com.example.articleapp.data.repository.dataSource.NewsLocalDataSource
import com.example.articleapp.data.repository.dataSource.NewsRemoteDataSource
import com.example.articleapp.domain.repository.NewsRepository
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import javax.inject.Singleton

@Module
@InstallIn(SingletonComponent::class)
class RepositoryModule {

    @Provides
    @Singleton
    fun provideNewsRepository(
        newsRemoteDataSource: NewsRemoteDataSource,
        newsLocalDataSource: NewsLocalDataSource
    ): NewsRepository {
        return NewsRepositoryImpl(newsRemoteDataSource, newsLocalDataSource)
    }
}