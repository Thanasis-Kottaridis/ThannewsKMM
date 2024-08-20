package com.thanasis.kottaridis.thannewskmm.data.network.api

import com.thanasis.kottaridis.thannewskmm.data.network.dto.ArticleDto
import com.thanasis.kottaridis.thannewskmm.data.network.dto.ArticlesWrapperDto
import io.ktor.client.HttpClient
import io.ktor.client.call.body
import io.ktor.client.request.get

class NewsApi(
    private val httpClient: HttpClient,
) {
    companion object {
        const val API_KEY = "fb64b976697f46d0805d99f4952717ce"
        const val BASE_URL = "https://newsapi.org/v2"
    }

    suspend fun getArticlesByCategoryAndCountry(
        category: String,
        country: String,
    ): ArticlesWrapperDto {
        val response = httpClient.get("$BASE_URL/top-headlines?country=$country&category=$category&apiKey=$API_KEY")
        return response.body()
    }
}

class ArticlesService(
    private val httpClient: HttpClient,
) {
    private val country = "us"
    private val category = "business"
    private val apiKey = "f67ace1b27b24ce4b95c7f71fde88920"

    suspend fun fetchArticles(): List<ArticleDto> {
        val response: ArticlesWrapperDto =
            httpClient
                .get(
                    "https://newsapi.org/v2/top-headlines?country=$country&category=$category&apiKey=$apiKey",
                ).body()
        return response.articles
    }
}
