package com.example.articleapp.data.repository

import com.example.articleapp.data.model.APIResponse
import com.example.articleapp.data.model.Article
import com.example.articleapp.data.repository.dataSource.NewsLocalDataSource
import com.example.articleapp.data.repository.dataSource.NewsRemoteDataSource
import com.example.articleapp.data.util.Resource
import com.example.articleapp.domain.repository.NewsRepository
import kotlinx.coroutines.flow.Flow
import retrofit2.Response

class NewsRepositoryImpl(
    private val newsRemoteDataSource: NewsRemoteDataSource,
    private val newsLocalDataSource: NewsLocalDataSource
): NewsRepository {
    override suspend fun getNewsHeadlines(country: String, page: Int): Resource<APIResponse> {
        return responseToResource(newsRemoteDataSource.getTopHeadlines(country, page))
    }

    override suspend fun getSearchedNews(
        country: String,
        page: Int,
        searchQuery: String
    ): Resource<APIResponse> {
        return responseToResource(newsRemoteDataSource.getSearchedNews(country, page, searchQuery))
    }

    private fun responseToResource(response: Response<APIResponse>): Resource<APIResponse> {
        if(response.isSuccessful) {
            response.body()?.let { result ->
                return Resource.Success(result)
            }
        }
        return Resource.Error(response.message())
    }

    override suspend fun saveNews(article: Article) {
        newsLocalDataSource.saveArticlesToDB(article)
    }

    override suspend fun deleteNews(article: Article) {
        newsLocalDataSource.deleteArticleFromDB(article)
    }

    override fun getSavedNews(): Flow<List<Article>> {
        return newsLocalDataSource.getSavedArticles()
    }
}