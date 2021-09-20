package com.example.articleapp.presentation.di

import android.app.Application
import com.example.articleapp.domain.usecase.GetNewsHeadlinesUseCase
import com.example.articleapp.domain.usecase.GetSearchedNewsUseCase
import com.example.articleapp.presentation.viewModel.NewsViewModelFactory
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import javax.inject.Singleton

@Module
@InstallIn(SingletonComponent::class)
class FactoryModule {

    @Provides
    @Singleton
    fun provideNewsViewModelFactory(
        application: Application,
        getNewsHeadlinesUseCase: GetNewsHeadlinesUseCase,
        getSearchedNewsUseCase: GetSearchedNewsUseCase
    ): NewsViewModelFactory {
        return NewsViewModelFactory(application, getNewsHeadlinesUseCase, getSearchedNewsUseCase)
    }
}