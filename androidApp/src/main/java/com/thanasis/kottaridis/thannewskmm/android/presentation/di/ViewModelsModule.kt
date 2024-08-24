package com.thanasis.kottaridis.thannewskmm.android.presentation.di

import com.thanasis.kottaridis.thannewskmm.presentation.articles.ArticlesViewModel
import org.koin.androidx.viewmodel.dsl.viewModel
import org.koin.dsl.module

val viewModelsModule =
    module {
        viewModel { ArticlesViewModel(useCase = get(), actionHandler = get()) }
    }
