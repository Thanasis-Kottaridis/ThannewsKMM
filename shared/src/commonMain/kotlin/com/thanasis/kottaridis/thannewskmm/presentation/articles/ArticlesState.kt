package com.thanasis.kottaridis.thannewskmm.presentation.articles

import com.thanasis.kottaridis.thannewskmm.domain.models.articles.Article

data class ArticlesState(
    val isLoading: Boolean = false,
    val articles: List<Article> = listOf(),
    val error: String? = null,
)
