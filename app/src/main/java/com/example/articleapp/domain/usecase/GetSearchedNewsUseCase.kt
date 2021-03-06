package com.example.articleapp.domain.usecase

import com.example.articleapp.data.model.APIResponse
import com.example.articleapp.data.util.Resource
import com.example.articleapp.domain.repository.NewsRepository

class GetSearchedNewsUseCase(private val newsRepository: NewsRepository) {
    suspend fun execute(country: String, page: Int, searchQuery: String): Resource<APIResponse> {
        return newsRepository.getSearchedNews(country, page, searchQuery)
    }
}