package com.example.articleapp.domain.usecase

import com.example.articleapp.data.model.Article
import com.example.articleapp.domain.repository.NewsRepository

class DeleteSavedNewsUseCase(private val newsRepository: NewsRepository) {
    suspend fun execute(article: Article) {
        return newsRepository.deleteNews(article)
    }
}