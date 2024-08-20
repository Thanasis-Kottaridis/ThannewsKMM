package com.thanasis.kottaridis.thannewskmm.domain.repository

import com.thanasis.kottaridis.thannewskmm.domain.models.articles.Article

interface ArticlesRepository {
    suspend fun fetchArticles(
        country: String = "us",
        category: String = "business",
    ): List<Article>
}
