package com.thanasis.kottaridis.thannewskmm.data.network.mappers

import com.thanasis.kottaridis.thannewskmm.data.network.dto.ArticleDto
import com.thanasis.kottaridis.thannewskmm.data.utils.DateMapper
import com.thanasis.kottaridis.thannewskmm.domain.models.articles.Article
import com.thanasis.kottaridis.thannewskmm.domain.utils.helpers.DomainMapper

object ArticleMapper : DomainMapper<Article, ArticleDto> {
    private const val DEFAULT_DESCRIPTION = "Click to find out more"
    private const val DEFAULT_IMAGE_URL = "https://image.cnbcfm.com/api/v1/image/107326078-1698758530118-gettyimages-1765623456-wall26362_igj6ehhp.jpeg?v=1698758587&w=1920&h=1080"

    override fun modelToDomain(model: Article): ArticleDto =
        ArticleDto(
            title = model.title,
            desc = model.description,
            date = model.date,
            imageUrl = model.imageUrl,
        )

    override fun domainToModel(domainModel: ArticleDto): Article =
        Article(
            title = domainModel.title,
            description = domainModel.desc ?: DEFAULT_DESCRIPTION,
            date = DateMapper.getDaysAgoString(domainModel.date),
            imageUrl = domainModel.imageUrl ?: DEFAULT_IMAGE_URL,
        )
}
