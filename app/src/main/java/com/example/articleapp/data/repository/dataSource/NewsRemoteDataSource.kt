package com.example.articleapp.data.repository.dataSource

import com.example.articleapp.data.model.APIResponse
import retrofit2.Response

interface NewsRemoteDataSource {
    suspend fun getTopHeadlines(country: String, page: Int) : Response<APIResponse>
    suspend fun getSearchedNews(country: String, page: Int, searchQuery: String) : Response<APIResponse>
}