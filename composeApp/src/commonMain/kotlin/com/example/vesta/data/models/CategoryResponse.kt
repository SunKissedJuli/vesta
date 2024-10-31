package com.example.vesta.data.models

import kotlinx.serialization.SerialName
import kotlinx.serialization.Serializable

@Serializable
class DescriptionResponse(
    @SerialName("category_id") val categoryId: Int?,
    @SerialName("name") val name: String?,
    @SerialName("description") val description: String?,
    @SerialName("meta_keyword") val metaKeyword: String?
)

@Serializable
class CategoryResponse(
    @SerialName("category_id") val categoryId: Int?,
    @SerialName("image") val image: String?,
    @SerialName("oct_image") val octImage: String?,
    @SerialName("name") val name: String?,
    @SerialName("description") val description: String?,
    @SerialName("meta_description") val metaDescription: String?,
    @SerialName("meta_keyword") val metaKeyword: String?,
    @SerialName("meta_title") val metaTitle: String?,
)