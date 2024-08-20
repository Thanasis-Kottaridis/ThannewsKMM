package com.thanasis.kottaridis.thannewskmm.data.repository

import com.thanasis.kottaridis.thannewskmm.data.network.api.NewsApi
import com.thanasis.kottaridis.thannewskmm.data.network.mappers.ArticleMapper
import com.thanasis.kottaridis.thannewskmm.domain.models.articles.Article
import com.thanasis.kottaridis.thannewskmm.domain.repository.ArticlesRepository

class ArticlesRepositoryImpl(
    private val service: NewsApi,
) : ArticlesRepository {
    override suspend fun fetchArticles(
        country: String,
        category: String,
    ): List<Article> {
        // 1. fetch data from service.
        val response =
            service.getArticlesByCategoryAndCountry(country = country, category = category)
        // 2. map them to domain model.
        return ArticleMapper.mapModelLists(response.articles)
    }
}
