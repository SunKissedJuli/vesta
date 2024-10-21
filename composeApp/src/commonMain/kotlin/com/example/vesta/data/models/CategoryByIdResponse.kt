package com.example.vesta.data.models

import kotlinx.serialization.SerialName
import kotlinx.serialization.Serializable

@Serializable
class CategoryByIdResponse(
    @SerialName("category") val category: CategoryById?,
    @SerialName("products") val products: List<ProductsDataResponse>?,
)

@Serializable
class CategoryById(
    @SerialName("category_id") val categoryId: Int?,
    @SerialName("children") val children: List<CategoryById>?,
    @SerialName("column") val column: Int?,
    @SerialName("description") val description: List<DescriptionResponse>?,
    @SerialName("image") val image: String?,
    @SerialName("oct_image") val octImage: String?,
    @SerialName("parent_id") val parentId: Int?,
    @SerialName("sort_order") val sortOrder: Int?,
    @SerialName("status") val status: Int?,
    @SerialName("top") val top: Int?
)

@Serializable
class Link(
    @SerialName("active") val active: Boolean?,
    @SerialName("label") val label: String?,
    @SerialName("url") val url: String?
)
