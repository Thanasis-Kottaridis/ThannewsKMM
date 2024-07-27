package com.thanasis.kottaridis.thannewskmm.android.about

import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.material3.Divider
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.material3.TopAppBar
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.thanasis.kottaridis.thannewskmm.Platform
import com.thanasis.kottaridis.thannewskmm.android.MyApplicationTheme

@Composable
fun AboutScreen() {
    Column {
        Toolbar()
        AboutContentView()
    }
}

// TODO: - SHOULD I MAKE IT GENERIC?
@OptIn(ExperimentalMaterial3Api::class)
@Composable
private fun Toolbar() {
    TopAppBar(title = { Text(text = "About Device") })
}

@Composable
private fun AboutContentView() {
    LazyColumn(
        modifier = Modifier.fillMaxSize(),
    ) {
        items(Platform().toItemsList()) { row ->
            AboutRowView(
                title = row.first,
                subtitle = row.second,
            )
        }
    }
}

@Composable
private fun AboutRowView(
    title: String,
    subtitle: String,
) {
    Column(
        modifier =
            Modifier
                .fillMaxSize()
                .padding(8.dp),
    ) {
        Text(
            text = title,
            style = MaterialTheme.typography.bodySmall,
            color = Color.Gray,
        )
        Text(
            text = subtitle,
            style = MaterialTheme.typography.bodyLarge,
            color = Color.Gray,
        )
        Divider()
    }
}

@Preview
@Composable
fun DefaultAboutScreen() {
    MyApplicationTheme {
        AboutScreen()
    }
}
