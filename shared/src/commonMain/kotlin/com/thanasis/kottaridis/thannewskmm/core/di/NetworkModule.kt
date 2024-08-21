package com.thanasis.kottaridis.thannewskmm.core.di

import com.thanasis.kottaridis.thannewskmm.core.utils.KtorClientFactory
import io.ktor.client.HttpClient
import org.koin.dsl.module

val networkModule =
    module {
        single<HttpClient> { KtorClientFactory.build() }
    }
