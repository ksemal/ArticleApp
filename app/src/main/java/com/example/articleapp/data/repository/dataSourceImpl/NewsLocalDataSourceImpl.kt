package com.example.articleapp.data.repository.dataSourceImpl

import com.example.articleapp.data.db.ArticleDAO
import com.example.articleapp.data.model.Article
import com.example.articleapp.data.repository.dataSource.NewsLocalDataSource

class NewsLocalDataSourceImpl(
    private val articleDAO: ArticleDAO
): NewsLocalDataSource {
    override suspend fun saveArticlesToDB(article: Article) {
        articleDAO.insert(article)
    }
}