package com.example.articleapp.presentation.di

import com.example.articleapp.domain.repository.NewsRepository
import com.example.articleapp.domain.usecase.GetNewsHeadlinesUseCase
import com.example.articleapp.domain.usecase.GetSearchedNewsUseCase
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import javax.inject.Singleton

@Module
@InstallIn(SingletonComponent::class)
class UseCaseModule {

    @Provides
    @Singleton
    fun provideNewsHeadlinesUseCase(newsRepository: NewsRepository): GetNewsHeadlinesUseCase {
        return GetNewsHeadlinesUseCase(newsRepository)
    }

    @Provides
    @Singleton
    fun provideSearchedNewsUseCase(newsRepository: NewsRepository): GetSearchedNewsUseCase {
        return GetSearchedNewsUseCase(newsRepository)
    }
}