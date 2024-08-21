package com.thanasis.kottaridis.thannewskmm.domain.usecase

import com.thanasis.kottaridis.thannewskmm.domain.models.articles.Article
import com.thanasis.kottaridis.thannewskmm.domain.repository.ArticlesRepository

fun interface ArticlesUseCase : suspend () -> List<Article> {
    companion object {
        fun create(repository: ArticlesRepository): ArticlesUseCase =
            ArticlesUseCase {
                repository.fetchArticles()
            }
    }
}
