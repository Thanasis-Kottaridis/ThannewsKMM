package com.thanasis.kottaridis.thannewskmm.android

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.viewModels
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.rememberCoroutineScope
import androidx.compose.runtime.setValue
import androidx.compose.ui.Modifier
import com.thanasis.kottaridis.thannewskmm.android.screen.articles.ArticlesScreen
import com.thanasis.kottaridis.thannewskmm.data.utils.TestKtor
import com.thanasis.kottaridis.thannewskmm.presentation.articles.ArticlesViewModel
import kotlinx.coroutines.launch

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        val articlesViewModel: ArticlesViewModel by viewModels()

        setContent {
            MyApplicationTheme {
                Surface(
                    modifier = Modifier.fillMaxSize(),
                    color = MaterialTheme.colorScheme.background,
                ) {
                    ArticlesScreen(
                        onAboutButtonClick = { /*TODO*/ },
                        articlesViewModel = articlesViewModel,
                    )
                }
            }
        }
    }
}

@Composable
fun TestKtorComponent() {
    val scope = rememberCoroutineScope()
    var text by remember { mutableStateOf("Loading") }
    LaunchedEffect(true) {
        scope.launch {
            text =
                try {
                    TestKtor().greeting()
                } catch (e: Exception) {
                    e.localizedMessage ?: "error"
                }
        }
    }

    Text(text = text)
}
