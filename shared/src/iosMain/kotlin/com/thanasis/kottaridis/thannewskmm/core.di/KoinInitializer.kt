package com.thanasis.kottaridis.thannewskmm.core.di

import com.thanasis.kottaridis.thannewskmm.domain.usecase.ArticlesUseCase
import org.koin.core.component.KoinComponent
import org.koin.core.component.inject
import org.koin.core.context.startKoin

fun initKoin() {
    val modules = sharedKoinModules

    startKoin {
        modules(modules)
    }
}

class ArticlesInjector : KoinComponent {
    val articlesUseCase: ArticlesUseCase by inject()
}
