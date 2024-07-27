package com.thanasis.kottaridis.thannewskmm.domain.models.articles

data class Article(
    val title: String,
    val description: String,
    val date: String,
    val imageUrl: String,
) {
    companion object {
        fun mock(index: Int): Article =
            Article(
                title = "This is a test article $index",
                description = "Lorem ipsum dolor sit amet, consectetur adipiscing elit, sed do eiusmod tempor incididunt ut labore et dolore magna aliqua.",
                date = "2024-07-27",
                imageUrl = "https://miro.medium.com/v2/resize:fit:1400/format:webp/0*Slp6TwFNpTff3lg1",
            )
    }
}
