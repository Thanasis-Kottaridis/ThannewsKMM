package com.thanasis.kottaridis.thannewskmm.core.di

// Every feature has to provide its own module in order to instantiate the dependencies of the feature
val sharedKoinModules =
    listOf(
        networkModule,
        articlesModule,
    )
