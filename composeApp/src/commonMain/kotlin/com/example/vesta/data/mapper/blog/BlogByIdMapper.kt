package com.example.vesta.data.mapper.blog

import com.example.vesta.data.mapper.toUI
import com.example.vesta.data.models.blog.BlogByIdResponse
import com.example.vesta.data.models.blog.RelatedProduct
import com.example.vesta.domain.modelsUI.OctStickersUi
import com.example.vesta.domain.modelsUI.blog.BlogByIdUi
import com.example.vesta.domain.modelsUI.blog.RelatedProductUi
import com.example.vesta.ext.cleanHtml
import kotlinx.serialization.SerialName
import kotlinx.serialization.Serializable
fun BlogByIdResponse.toUI(): BlogByIdUi {
    return BlogByIdUi(
        blogArticleId = this.blogArticleId ?: 0,
        dateAdded = this.dateAdded.orEmpty(),
        dateAvailable = this.dateAvailable.orEmpty(),
        dateModified = this.dateModified.orEmpty(),
        description = this.description?.cleanHtml().orEmpty(),
        image = this.image.orEmpty(),
        languageId = this.languageId ?: 0,
        metaDescription = this.metaDescription.orEmpty(),
        metaKeyword = this.metaKeyword.orEmpty(),
        metaTitle = this.metaTitle.orEmpty(),
        viewed = this.viewed?:0,
        name = this.name.orEmpty().cleanHtml(),
        relatedProduct = this.relatedProduct?.map { it.toUI() } ?: emptyList(),
        shortDescription = this.shortDescription.orEmpty(),
        sortOrder = this.sortOrder ?: 0,
        status = this.status ?: 0,
        storeId = this.storeId ?: 0,
        tag = this.tag.orEmpty(),
    )
}

fun RelatedProduct.toUI(): RelatedProductUi {
    return RelatedProductUi(
        image = this.image.orEmpty(),
        model = this.model.orEmpty(),
        name = this.name?.cleanHtml().orEmpty(),
        octStickers = this.octStickers?.toUI() ?:OctStickersUi.empty,
        price = this.price?:0,
        productId = this.productId?:0,
        quantity = this.quantity?:0,
        quantityStatus = this.quantityStatus.orEmpty(),
        weight = this.weight.orEmpty()
    )
}