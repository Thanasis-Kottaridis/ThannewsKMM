package com.thanasis.kottaridis.thannewskmm.presentation.articles

import com.thanasis.kottaridis.thannewskmm.presentation.base.navigation.BaseActionHandler

interface ArticlesActionHandler : BaseActionHandler {
    fun goToArticlesLanding()

    fun goToArticleDetails(articleId: String)

    fun goToAboutScreen()
}
