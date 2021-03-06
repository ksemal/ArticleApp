package com.example.articleapp.data.repository.dataSourceImpl

import com.example.articleapp.data.api.NewsAPIService
import com.example.articleapp.data.model.APIResponse
import com.example.articleapp.data.repository.dataSource.NewsRemoteDataSource
import retrofit2.Response

class NewsRemoteDataSourceImpl(
    private val newsAPIService: NewsAPIService
): NewsRemoteDataSource {
    override suspend fun getTopHeadlines(country: String, page: Int): Response<APIResponse> {
        return newsAPIService.getTopHeadlines(country, page)
    }

    override suspend fun getSearchedNews(
        country: String,
        page: Int,
        searchQuery: String
    ): Response<APIResponse> {
        return newsAPIService.getSearchedTopHeadlines(country,page, searchQuery)
    }
}