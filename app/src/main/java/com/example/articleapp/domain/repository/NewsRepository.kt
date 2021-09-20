package com.example.articleapp.domain.repository

import com.example.articleapp.data.model.APIResponse
import com.example.articleapp.data.model.Article
import com.example.articleapp.data.util.Resource
import kotlinx.coroutines.flow.Flow

interface NewsRepository {
    // remote data source
    suspend fun getNewsHeadlines(country: String, page: Int) : Resource<APIResponse>
    suspend fun getSearchedNews(country: String, page: Int, searchQuery:String) : Resource<APIResponse>

    // local data source
    suspend fun saveNews(article: Article)
    suspend fun deleteNews(article: Article)
    fun getSavedNews(): Flow<List<Article>> // not recommended to use livedata in repository because of the threading issues. Use flow instead. Doesn't need suspend because it returns data stream
}