package com.example.vesta.data.models.blog

import com.example.vesta.data.models.OctStickers

import kotlinx.serialization.SerialName
import kotlinx.serialization.Serializable

@Serializable
class RelatedProduct(
 //   @SerialName("coupons") val coupons: List<Any>?,
    @SerialName("image") val image: String?,
    @SerialName("model") val model: String?,
    @SerialName("name") val name: String?,
    @SerialName("oct_stickers") val octStickers: OctStickers?,
    @SerialName("price") val price: Int?,
    @SerialName("product_id") val productId: Int?,
    @SerialName("quantity") val quantity: Int?,
    @SerialName("quantity_status") val quantityStatus: String?,
    @SerialName("weight") val weight: String?
)