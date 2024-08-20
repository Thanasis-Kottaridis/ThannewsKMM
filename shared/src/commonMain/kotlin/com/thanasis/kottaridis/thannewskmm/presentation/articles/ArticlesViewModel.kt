package com.thanasis.kottaridis.thannewskmm.presentation.articles

import com.thanasis.kottaridis.thannewskmm.data.network.api.NewsApi
import com.thanasis.kottaridis.thannewskmm.data.repository.ArticlesRepositoryImpl
import com.thanasis.kottaridis.thannewskmm.domain.models.articles.Article
import com.thanasis.kottaridis.thannewskmm.domain.repository.ArticlesRepository
import com.thanasis.kottaridis.thannewskmm.presentation.base.viewmodel.BaseViewModel
import com.thanasis.kottaridis.thannewskmm.presentation.base.viewmodel.KmmStateFlow
import com.thanasis.kottaridis.thannewskmm.presentation.base.viewmodel.asKmmStateFlow
import io.github.aakira.napier.DebugAntilog
import io.github.aakira.napier.Napier
import io.ktor.client.HttpClient
import io.ktor.client.plugins.contentnegotiation.ContentNegotiation
import io.ktor.client.plugins.logging.LogLevel
import io.ktor.client.plugins.logging.Logger
import io.ktor.client.plugins.logging.Logging
import io.ktor.serialization.kotlinx.json.json
import kotlinx.coroutines.delay
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.launch
import kotlinx.serialization.json.Json

class ArticlesViewModel : BaseViewModel() {
    private val mState: MutableStateFlow<ArticlesState> = MutableStateFlow(ArticlesState.default())
    val state: KmmStateFlow<ArticlesState> get() = mState.asKmmStateFlow()

    private val repository: ArticlesRepository

    init {

        // mock repository...
        val httpClient =
            HttpClient {
                install(Logging) {
                    logger =
                        object : Logger {
                            override fun log(message: String) {
                                println(message)
                            }
                        }
                    level = LogLevel.ALL
                }

                install(ContentNegotiation) {
                    json(
                        Json {
                            prettyPrint = true
                            isLenient = true
                            ignoreUnknownKeys = true
                        },
                    )
                }
            }.also { Napier.base(DebugAntilog()) }

        val service = NewsApi(httpClient)
        repository = ArticlesRepositoryImpl(service)

        // perform initial call
        onTriggerEvent(ArticleEvent.FetchData)
    }

    fun onTriggerEvent(event: ArticleEvent) {
        when (event) {
            is ArticleEvent.FetchData -> getArticles()
            is ArticleEvent.GoToAboutScreen -> {}
        }
    }

    private fun getArticles() {
        scope.launch {
            // 1. show loader
            mState.emit(mState.value.copy(isLoading = true))

            // 2. fetch data
            val articles = repository.fetchArticles()

            // 3. update state.
            mState.emit(
                mState.value.copy(
                    isLoading = false,
                    articles = articles,
                ),
            )
        }
    }

    private suspend fun fetchArticles(): List<Article> {
        delay(1500)
        return getMockArticles()
    }

    // TODO Move to usecase
    private fun getMockArticles() =
        listOf(
            Article.mock(1),
            Article.mock(2),
            Article.mock(3),
        )
}
