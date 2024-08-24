package com.thanasis.kottaridis.thannewskmm.android.presentation.screen.articles

import android.widget.Toast
import com.thanasis.kottaridis.thannewskmm.android.application.MainActivity
import com.thanasis.kottaridis.thannewskmm.android.application.base.navigation.Coordinator
import com.thanasis.kottaridis.thannewskmm.presentation.articles.ArticlesActionHandler

class ArticlesCoordinator :
    Coordinator<MainActivity>(),
    ArticlesActionHandler {
    override fun start() {
        goToArticlesLanding()
    }

    /**
     * ArticlesActionHandler Implementation
     */
    override fun goToArticlesLanding() {
        Toast.makeText(safeActivity, "Articles Coordinator goToArticlesLanding", Toast.LENGTH_SHORT).show()
    }

    override fun goToArticleDetails(articleId: String) {
        Toast.makeText(safeActivity, "Articles Coordinator goToArticleDetails", Toast.LENGTH_SHORT).show()
    }

    override fun goToAboutScreen() {
        Toast.makeText(safeActivity, "Articles Coordinator goToAboutScreen", Toast.LENGTH_SHORT).show()
    }
}
