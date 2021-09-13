package com.example.articleapp.domain.usecase

import com.example.articleapp.domain.repository.NewsRepository

class DeleteSavedNewsUseCase(private val newsRepository: NewsRepository) {
}