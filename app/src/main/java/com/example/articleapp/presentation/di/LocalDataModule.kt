package com.example.articleapp.presentation.di

import com.example.articleapp.data.db.ArticleDAO
import com.example.articleapp.data.repository.dataSource.NewsLocalDataSource
import com.example.articleapp.data.repository.dataSourceImpl.NewsLocalDataSourceImpl
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import javax.inject.Singleton

@Module
@InstallIn(SingletonComponent::class)
class LocalDataModule {
    @Provides
    @Singleton
    fun provideNewsLocalDataSource(newsDAO: ArticleDAO): NewsLocalDataSource {
        return NewsLocalDataSourceImpl(newsDAO)
    }
}