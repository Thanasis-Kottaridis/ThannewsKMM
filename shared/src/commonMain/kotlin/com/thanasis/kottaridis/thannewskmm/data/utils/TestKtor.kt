package com.thanasis.kottaridis.thannewskmm.data.utils

import io.ktor.client.HttpClient
import io.ktor.client.request.get
import io.ktor.client.statement.bodyAsText

class TestKtor {
    private val httpClient = HttpClient()

    private val country = "us"
    private val category = "business"
    private val apiKey = "f67ace1b27b24ce4b95c7f71fde88920"

    suspend fun greeting(): String {
        val response = httpClient.get("https://newsapi.org/v2/top-headlines?country=$country&category=$category&apiKey=$apiKey")
        return response.bodyAsText()
    }
}
