package com.example.articleapp.data.repository.dataSource

import com.example.articleapp.data.model.Article

interface NewsLocalDataSource {
    suspend fun saveArticlesToDB(article: Article)
}