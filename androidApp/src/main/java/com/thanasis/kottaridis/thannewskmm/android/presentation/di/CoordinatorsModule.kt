package com.thanasis.kottaridis.thannewskmm.android.presentation.di

import com.thanasis.kottaridis.thannewskmm.android.application.MainActivity
import com.thanasis.kottaridis.thannewskmm.android.presentation.screen.articles.ArticlesCoordinator
import com.thanasis.kottaridis.thannewskmm.presentation.articles.ArticlesActionHandler
import org.koin.core.module.dsl.bind
import org.koin.core.module.dsl.singleOf
import org.koin.dsl.module

val coordinatorsModule =
    module {
        // We define the scope that the following dependencies live
        // for example `ArticlesCoordinator` should live only while `ArticlesActivity`
        // is alive
        scope<MainActivity> {
            // The following code creates a singleton instance of `ArticlesCoordinator`
            // so method `get()` or `inject()` can provide this instance
            // and also binds this instance with `ArticlesActionHandler` so
            // it can be injected as `ArticlesActionHandler` as well.
            singleOf(::ArticlesCoordinator) {
                bind<ArticlesActionHandler>()
            }
        }
    }
