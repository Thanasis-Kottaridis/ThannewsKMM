package com.thanasis.kottaridis.thannewskmm.presentation.articles

import com.thanasis.kottaridis.thannewskmm.domain.models.articles.Article
import com.thanasis.kottaridis.thannewskmm.presentation.base.BaseViewModel
import kotlinx.coroutines.delay
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.launch

class ArticlesViewModel : BaseViewModel() {
    private val mState: MutableStateFlow<ArticlesState> = MutableStateFlow(ArticlesState())
    val state: StateFlow<ArticlesState> get() = mState

    init {
        getArticles()
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
