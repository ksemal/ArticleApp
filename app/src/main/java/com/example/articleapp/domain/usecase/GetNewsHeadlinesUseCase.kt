package com.example.articleapp.domain.usecase

import com.example.articleapp.domain.repository.NewsRepository

class GetNewsHeadlinesUseCase(private val newsRepository: NewsRepository) {
}