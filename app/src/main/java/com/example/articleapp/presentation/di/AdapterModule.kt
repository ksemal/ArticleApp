package com.example.articleapp.presentation.di

import com.example.articleapp.presentation.adapter.NewsAdapter
import com.example.articleapp.presentation.viewModel.NewsViewModelFactory
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import javax.inject.Singleton

@Module
@InstallIn(SingletonComponent::class)
class AdapterModule {

    @Provides
    @Singleton
    fun provideNewsAdapter(): NewsAdapter {
        return NewsAdapter()
    }
}