package com.thanasis.kottaridis.thannewskmm.core.di

import com.thanasis.kottaridis.thannewskmm.data.network.api.NewsApi
import com.thanasis.kottaridis.thannewskmm.data.repository.ArticlesRepositoryImpl
import com.thanasis.kottaridis.thannewskmm.domain.repository.ArticlesRepository
import com.thanasis.kottaridis.thannewskmm.domain.usecase.ArticlesUseCase
import org.koin.dsl.module

val articlesModule =
    module {
        // 1. set up dependency of NewsApi
        single<NewsApi> { NewsApi(get()) }

        // 2. set up dependency of Repository
        single<ArticlesRepository> { ArticlesRepositoryImpl(get()) }

        // 3. set up use case dependency
        single<ArticlesUseCase> { ArticlesUseCase.create(get()) }
    }
