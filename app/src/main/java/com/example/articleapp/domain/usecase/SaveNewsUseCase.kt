package com.example.articleapp.domain.usecase

import com.example.articleapp.domain.repository.NewsRepository

class SaveNewsUseCase(private val newsRepository: NewsRepository) {
}