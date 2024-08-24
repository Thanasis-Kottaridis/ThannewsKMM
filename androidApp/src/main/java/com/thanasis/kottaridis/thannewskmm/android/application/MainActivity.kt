package com.thanasis.kottaridis.thannewskmm.android.application

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Surface
import androidx.compose.ui.Modifier
import com.thanasis.kottaridis.thannewskmm.android.application.base.ui.compose.MyApplicationTheme
import com.thanasis.kottaridis.thannewskmm.android.presentation.screen.articles.ArticlesCoordinator
import com.thanasis.kottaridis.thannewskmm.android.presentation.screen.articles.ArticlesScreen
import com.thanasis.kottaridis.thannewskmm.presentation.articles.ArticleEvent
import com.thanasis.kottaridis.thannewskmm.presentation.articles.ArticlesViewModel
import org.koin.android.ext.android.inject
import org.koin.androidx.viewmodel.ext.android.viewModel

class MainActivity : ComponentActivity() {
    private val coordinator: ArticlesCoordinator by inject()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        coordinator.bind(this)

        val articlesViewModel by viewModel<ArticlesViewModel>()

        setContent {
            MyApplicationTheme {
                Surface(
                    modifier = Modifier.fillMaxSize(),
                    color = MaterialTheme.colorScheme.background,
                ) {
                    ArticlesScreen(
                        onAboutButtonClick = { articlesViewModel.onTriggerEvent(ArticleEvent.GoToAboutScreen) },
                        articlesViewModel = articlesViewModel,
                    )
                }
            }
        }
    }

    override fun onDestroy() {
        super.onDestroy()
        coordinator.unbind()
    }
}
