package com.example.vesta.data.models

import kotlinx.serialization.SerialName
import kotlinx.serialization.Serializable

@Serializable
class CategoryByIdResponse(
    @SerialName("category") val category: CategoryById?,
    @SerialName("products") val products: List<ProductInCategoryResponse>?,
    //мануфактуреры
)

@Serializable
class CategoryById(
    @SerialName("category_id") val categoryId: Int?,
    @SerialName("children") val children: List<CategoryById>?,
    @SerialName("image") val image: String?,
    @SerialName("name") val name: String?,
)

@Serializable
class ProductInCategoryResponse(
    @SerialName("category_id") val categoryId: Int?,
    @SerialName("image") val image: String?,
    @SerialName("manufacturer_id") val manufacturerId: Int?,
    @SerialName("manufacturer_name") val manufacturerName: String?,
    @SerialName("name_korr") val nameKorr: String?,
    @SerialName("oct_stickers") val octStickers: OctStickers?,
    @SerialName("price") val price: Int?,
    @SerialName("product_id") val productId: Int?,
    @SerialName("quantity") val quantity: Int?,
    @SerialName("quantity_status") val quantityStatus: String?,
    @SerialName("is_favorite") val isFavorite: Boolean?
)

@Serializable
class Link(
    @SerialName("active") val active: Boolean?,
    @SerialName("label") val label: String?,
    @SerialName("url") val url: String?
)

