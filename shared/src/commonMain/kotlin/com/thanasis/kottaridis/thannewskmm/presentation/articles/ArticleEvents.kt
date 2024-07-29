package com.thanasis.kottaridis.thannewskmm.presentation.articles

sealed class ArticleEvent {
    data object FetchData : ArticleEvent()

    data object GoToAboutScreen : ArticleEvent()
}
