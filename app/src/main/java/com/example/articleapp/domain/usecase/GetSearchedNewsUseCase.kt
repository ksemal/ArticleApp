package com.example.articleapp.domain.usecase

import com.example.articleapp.domain.repository.NewsRepository

class GetSearchedNewsUseCase(private val newsRepository: NewsRepository) {
}