package com.thanasis.kottaridis.thannewskmm.presentation.articles

import com.thanasis.kottaridis.thannewskmm.domain.models.articles.Article
import com.thanasis.kottaridis.thannewskmm.presentation.base.viewmodel.BaseViewModel
import com.thanasis.kottaridis.thannewskmm.presentation.base.viewmodel.KmmStateFlow
import com.thanasis.kottaridis.thannewskmm.presentation.base.viewmodel.asKmmStateFlow
import kotlinx.coroutines.delay
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.launch

class ArticlesViewModel : BaseViewModel() {
    private val mState: MutableStateFlow<ArticlesState> = MutableStateFlow(ArticlesState.default())
    val state: KmmStateFlow<ArticlesState> get() = mState.asKmmStateFlow()

    init {
        // perform initial call
        onTriggerEvent(ArticleEvent.FetchData)
    }

    fun onTriggerEvent(event: ArticleEvent) {
        when (event) {
            is ArticleEvent.FetchData -> getArticles()
            is ArticleEvent.GoToAboutScreen -> { }
        }
    }

    private fun getArticles() {
        scope.launch {
            // 1. show loader
            mState.emit(mState.value.copy(isLoading = true))

            // 2. fetch data
            val articles = fetchArticles()

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
