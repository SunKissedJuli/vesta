package com.example.vesta.data.models

import kotlinx.serialization.SerialName
import kotlinx.serialization.Serializable

@Serializable
class ProductsResponse(
    @SerialName("current_page") val currentPage: Int?,
    @SerialName("data") val data: List<ProductDataResponse>?,
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
    @SerialName("total") val total: Int?
)

@Serializable
class ProductDataResponse(
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
    @SerialName("spb1") val spb1: Int?,
    @SerialName("spb10") val spb10: Int?,
    @SerialName("spb11") val spb11: Int?,
    @SerialName("spb12") val spb12: Int?,
    @SerialName("spb13") val spb13: Int?,
    @SerialName("spb14") val spb14: Int?,
    @SerialName("spb15") val spb15: Int?,
    @SerialName("spb16") val spb16: Int?,
    @SerialName("spb2") val spb2: Int?,
    @SerialName("spb3") val spb3: Int?,
    @SerialName("spb4") val spb4: Int?,
    @SerialName("spb5") val spb5: Int?,
    @SerialName("spb6") val spb6: Int?,
    @SerialName("spb7") val spb7: Int?,
    @SerialName("spb8") val spb8: Int?,
    @SerialName("spb9") val spb9: Int?,
    @SerialName("status") val status: Int?,
    @SerialName("stock_status_id") val stockStatusId: Int?,
    @SerialName("store_id") val storeId: Int?,
    @SerialName("tag") val tag: String?
)