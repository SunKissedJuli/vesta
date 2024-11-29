package com.example.vesta.domain.modelsUI.blog

import kotlinx.serialization.SerialName
import kotlinx.serialization.Serializable

data class BlogByIdUi(
    val blogArticleId: Int,
    val dateAdded: String,
    val dateAvailable: String,
    val dateModified: String,
    val description: String,
    val image:List <String>,
    val viewed: Int,
    val languageId: Int,
    val metaDescription: String,
    val metaKeyword: String,
    val metaTitle: String,
    val name: String,
    val relatedProduct: List<RelatedProductUi>,
    val shortDescription: String,
    val sortOrder: Int,
    val status: Int,
    val storeId: Int,
    val tag: String,
) {
    companion object {
        val empty = BlogByIdUi(
            blogArticleId = 0,
            dateAdded = "",
            dateAvailable = "",
            dateModified = "",
            description = "",
            viewed = 0,
            image = emptyList(),
            languageId = 0,
            metaDescription = "",
            metaKeyword = "",
            metaTitle = "",
            name = "",
            relatedProduct = emptyList(),
            shortDescription = "",
            sortOrder = 0,
            status = 0,
            storeId = 0,
            tag = "",
        )
    }
}