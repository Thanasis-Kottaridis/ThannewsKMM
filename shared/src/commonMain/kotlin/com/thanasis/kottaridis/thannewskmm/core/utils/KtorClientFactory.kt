package com.thanasis.kottaridis.thannewskmm.core.utils

import io.github.aakira.napier.DebugAntilog
import io.github.aakira.napier.Napier
import io.ktor.client.HttpClient
import io.ktor.client.HttpClientConfig
import io.ktor.client.plugins.DefaultRequest
import io.ktor.client.plugins.contentnegotiation.ContentNegotiation
import io.ktor.client.plugins.logging.LogLevel
import io.ktor.client.plugins.logging.Logger
import io.ktor.client.plugins.logging.Logging
import io.ktor.client.request.accept
import io.ktor.http.ContentType
import io.ktor.http.contentType
import io.ktor.serialization.kotlinx.json.json
import kotlinx.serialization.json.Json

object KtorClientFactory {
    // Base url const val
    // TODO Move to gradle properties based on environment.
    private const val BASE_URL = "https://newsapi.org"

    fun build(): HttpClient =
        HttpClient {
            // 1. set up logging mechanism
            addLogging()
            // 2. set up base URL and Common headers
            addDefaultRequest()
            // 3. Set up ContentNegotiation to handle Json response and ignore extra properties retrieved from BackEnd
            addContentNegotiation()
        }.also { Napier.base(DebugAntilog()) }

    private fun HttpClientConfig<*>.addLogging() {
        install(Logging) {
            logger =
                object : Logger {
                    override fun log(message: String) {
                        println(message)
                    }
                }
            level = LogLevel.ALL
        }
    }

    private fun HttpClientConfig<*>.addDefaultRequest() {
        install(DefaultRequest) {
            url(BASE_URL)
            contentType(ContentType.Application.Json)
            accept(ContentType.Application.Json)
        }
    }

    private fun HttpClientConfig<*>.addContentNegotiation() {
        install(ContentNegotiation) {
            json(
                Json {
                    prettyPrint = true
                    isLenient = true
                    ignoreUnknownKeys = true
                },
            )
        }
    }
}
