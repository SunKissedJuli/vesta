package com.example.vesta.data.models.product

import com.example.vesta.data.models.OctStickers
import kotlinx.serialization.Serializable
import kotlinx.serialization.SerialName

@Serializable
class Related(
    @SerialName("product_id") val productId: Int?,
    @SerialName("related") val related: RelatedDetails?,
    @SerialName("related_id") val relatedId: Int?
)

@Serializable
class RelatedDetails(
    @SerialName("date_added") val dateAdded: String?,
    @SerialName("date_available") val dateAvailable: String?,
    @SerialName("date_modified") val dateModified: String?,
    @SerialName("description") val description: List<ProductDescription>?,
    @SerialName("ean") val ean: String?,
    @SerialName("height") val height: String?,
    @SerialName("image") val image: String?,
    @SerialName("isbn") val isbn: String?,
    @SerialName("jan") val jan: String?,
    @SerialName("last_sync_at") val lastSyncAt: String?,
    @SerialName("length") val length: String?,
    @SerialName("length_class_id") val lengthClassId: Int?,
    @SerialName("location") val location: String?,
    @SerialName("manufacturer_id") val manufacturerId: Int?,
    @SerialName("minimum") val minimum: Int?,
    @SerialName("model") val model: String?,
    @SerialName("mpn") val mpn: String?,
    @SerialName("oct_stickers") val octStickers: OctStickers?,
    @SerialName("ones_uuid") val onesUuid: String?,
    @SerialName("points") val points: Int?,
    @SerialName("product_id") val productId: Int?,
    @SerialName("quantity_len117") val quantityLen117: Int?,
    @SerialName("shipping") val shipping: Int?,
    @SerialName("sku") val sku: String?,
    @SerialName("sort_order") val sortOrder: Int?,
    @SerialName("status") val status: Int?,
    @SerialName("stock_status_id") val stockStatusId: Int?,
    @SerialName("subtract") val subtract: Int?,
    @SerialName("tax_class_id") val taxClassId: Int?,
    @SerialName("upc") val upc: String?,
    @SerialName("viewed") val viewed: Int?,
    @SerialName("weight") val weight: String?,
    @SerialName("weight_class_id") val weightClassId: Int?,
    @SerialName("width") val width: String?
)

@Serializable
class ProductDescription(
    @SerialName("description") val description: String?,
    @SerialName("language_id") val languageId: Int?,
    @SerialName("meta_description") val metaDescription: String?,
    @SerialName("meta_h1") val metaH1: String?,
    @SerialName("meta_keyword") val metaKeyword: String?,
    @SerialName("meta_title") val metaTitle: String?,
    @SerialName("name") val name: String?,
    @SerialName("name_korr") val nameKorr: String?,
    @SerialName("product_id") val productId: Int?,
    @SerialName("tag") val tag: String?
)