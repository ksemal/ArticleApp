package com.example.articleapp.domain.usecase

import com.example.articleapp.domain.repository.NewsRepository

class GetSavedNewsUseCase(private val newsRepository: NewsRepository) {
}