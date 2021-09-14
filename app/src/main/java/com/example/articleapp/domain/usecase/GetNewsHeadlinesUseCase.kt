package com.example.articleapp.domain.usecase

import com.example.articleapp.data.model.APIResponse
import com.example.articleapp.data.util.Resource
import com.example.articleapp.domain.repository.NewsRepository

class GetNewsHeadlinesUseCase(private val newsRepository: NewsRepository) {
    suspend fun execute(): Resource<APIResponse> {
        // logic to modify data can be added here and the return type can be different
        return newsRepository.getNewsHeadlines()
    }
}