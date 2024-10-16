package com.example.vesta.data.models

import kotlinx.serialization.SerialName
import kotlinx.serialization.Serializable

//@Serializable
//class CategoryResponse(
//    @SerialName("category_id") val categoryId: Int?,
//    @SerialName("image") val image: String?,
//    @SerialName("oct_image") val octImage: String?,
//    @SerialName("parent_id") val parentId: Int?,
//    @SerialName("top") val top: Int?,
//    @SerialName("column") val column: Int?,
//    @SerialName("sort_order") val sortOrder: Int?,
//    @SerialName("status") val status: Int?,
//    @SerialName("description") val description: List<DescriptionResponse>?,
//)
//
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