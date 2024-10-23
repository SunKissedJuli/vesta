package com.example.vesta.data.models

import kotlinx.serialization.SerialName
import kotlinx.serialization.Serializable

@Serializable
class ProductsResponse(
    @SerialName("current_page") val currentPage: Int?,
    @SerialName("data") val data: List<ProductsDataResponse>?,
    @SerialName("first_page_url") val firstPageUrl: String?,
    @SerialName("from") val from: Int?,
    @SerialName("last_page") val lastPage: Int?,
    @SerialName("last_page_url") val lastPageUrl: String?,
    @SerialName("links") val links: List<Link>?,
    @SerialName("next_page_url") val nextPageUrl: String?,
    @SerialName("path") val path: String?,
    @SerialName("per_page") val perPage: Int?,
    @SerialName("prev_page_url") val prevPageUrl: String?,
    @SerialName("to") val to: Int?,
    @SerialName("total") val total: Int?,
    @SerialName("quantity_status") val quantityStatus: String?
)

@Serializable
class ProductsDataResponse(
    @SerialName("category_id") val categoryId: Int?,
    @SerialName("description") val description: String?,
    @SerialName("image") val image: String?,
    @SerialName("isbn") val isbn: String?,
    @SerialName("manufacturer_id") val manufacturerId: Int?,
    @SerialName("meta_keyword") val metaKeyword: String?,
    @SerialName("meta_title") val metaTitle: String?,
    @SerialName("model") val model: String?,
    @SerialName("name") val name: String?,
    @SerialName("name_korr") val nameKorr: String?,
    @SerialName("oct_stickers") val octStickers: OctStickers?,
    @SerialName("price") val price: Int?,
    @SerialName("pricep") val pricep: String?,
    @SerialName("product_id") val productId: Int?,
    @SerialName("quantity") val quantity: Int?,
    @SerialName("status") val status: Int?,
    @SerialName("stock_status_id") val stockStatusId: Int?,
    @SerialName("store_id") val storeId: Int?,
    @SerialName("tag") val tag: String?,
    @SerialName("quantity_status") val quantityStatus: String?
)