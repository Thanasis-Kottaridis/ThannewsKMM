package com.thanasis.kottaridis.thannewskmm.presentation.articles

import com.thanasis.kottaridis.thannewskmm.domain.models.articles.Article

data class ArticlesState(
    val isLoading: Boolean,
    val articles: List<Article>,
    val error: String?,
) {
    companion object {
        fun default(): ArticlesState =
            ArticlesState(
                isLoading = false,
                articles = listOf(),
                error = null,
            )
    }
}
