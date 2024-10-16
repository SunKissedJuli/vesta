package com.example.vesta.data.models.product

import kotlinx.serialization.Serializable
import kotlinx.serialization.SerialName

@Serializable
class Category(
    @SerialName("category") val category: CategoryDetails?,
    @SerialName("category_id") val categoryId: Int?,
    @SerialName("last_sync_at") val lastSyncAt: String?,
    @SerialName("main_category") val mainCategory: Int?,
    @SerialName("product_id") val productId: Int?
)

@Serializable
class CategoryDetails(
    @SerialName("category_id") val categoryId: Int?,
    @SerialName("column") val column: Int?,
    @SerialName("description") val description: List<CategoryDescription>?,
    @SerialName("image") val image: String?,
    @SerialName("oct_image") val octImage: String?,
    @SerialName("parent_id") val parentId: Int?,
    @SerialName("sort_order") val sortOrder: Int?,
    @SerialName("status") val status: Int?,
    @SerialName("top") val top: Int?
)

@Serializable
class CategoryDescription(
    @SerialName("category_id") val categoryId: Int?,
    @SerialName("description") val description: String?,
    @SerialName("meta_keyword") val metaKeyword: String?,
    @SerialName("name") val name: String?
)

@Serializable
class Image(
    @SerialName("image") val image: String?,
    @SerialName("product_id") val productId: Int?,
    @SerialName("product_image_id") val productImageId: Int?,
    @SerialName("sort_order") val sortOrder: Int?
)