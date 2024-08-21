package com.thanasis.kottaridis.thannewskmm.data.network.api

import com.thanasis.kottaridis.thannewskmm.data.network.dto.ArticlesWrapperDto
import io.ktor.client.HttpClient
import io.ktor.client.call.body
import io.ktor.client.request.get

class NewsApi(
    private val httpClient: HttpClient,
) {
    companion object {
        const val API_KEY = "fb64b976697f46d0805d99f4952717ce"
    }

    suspend fun getArticlesByCategoryAndCountry(
        category: String,
        country: String,
    ): ArticlesWrapperDto {
        val response = httpClient.get("v2/top-headlines?country=$country&category=$category&apiKey=$API_KEY")
        return response.body()
    }
}
