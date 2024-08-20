package com.thanasis.kottaridis.thannewskmm.data.network.dto

import kotlinx.serialization.Serializable

@Serializable
data class ArticlesWrapperDto(
    val status: String,
    val totalResults: Int,
    val articles: List<ArticleDto>,
)
