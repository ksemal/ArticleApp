package com.example.articleapp.data.repository.dataSourceImpl

import com.example.articleapp.data.api.NewsAPIService
import com.example.articleapp.data.model.APIResponse
import com.example.articleapp.data.repository.dataSource.NewsRemoteDataSource
import retrofit2.Response

class NewRemoteDataSourceImpl(
    private val newsAPIService: NewsAPIService,
    private val country: String,
    private val page: Int,
): NewsRemoteDataSource {
    override suspend fun getTopHeadlines(): Response<APIResponse> {
        return newsAPIService.getTopHeadlines(country, page)
    }
}