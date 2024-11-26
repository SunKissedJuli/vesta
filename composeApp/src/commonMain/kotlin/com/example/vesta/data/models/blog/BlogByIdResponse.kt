package com.example.vesta.data.models.blog

import kotlinx.serialization.SerialName
import kotlinx.serialization.Serializable

@Serializable
data class BlogByIdResponse(
    @SerialName("blogarticle_id") val blogArticleId: Int?,
    @SerialName("date_added") val dateAdded: String?,
    @SerialName("date_available") val dateAvailable: String?,
    @SerialName("date_modified") val dateModified: String?,
    @SerialName("description") val description: String?,
    @SerialName("image") val image: String?,
    @SerialName("language_id") val languageId: Int?,
    @SerialName("meta_description") val metaDescription: String?,
    @SerialName("meta_keyword") val metaKeyword: String?,
    @SerialName("meta_title") val metaTitle: String?,
    @SerialName("name") val name: String?,
    @SerialName("releated_product") val relatedProduct: List<RelatedProduct>?,
    @SerialName("shot_description") val shortDescription: String?,
    @SerialName("sort_order") val sortOrder: Int?,
    @SerialName("status") val status: Int?,
    @SerialName("store_id") val storeId: Int?,
    @SerialName("tag") val tag: String?,
    @SerialName("viewed") val viewed: Int?
)