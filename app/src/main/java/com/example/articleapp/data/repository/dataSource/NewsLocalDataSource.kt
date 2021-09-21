package com.example.articleapp.data.repository.dataSource

import com.example.articleapp.data.model.Article
import kotlinx.coroutines.flow.Flow

interface NewsLocalDataSource {
    suspend fun saveArticlesToDB(article: Article)

    fun getSavedArticles(): Flow<List<Article>>
}