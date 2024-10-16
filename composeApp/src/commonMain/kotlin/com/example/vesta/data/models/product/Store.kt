package com.example.vesta.data.models.product

import kotlinx.serialization.Serializable
import kotlinx.serialization.SerialName

@Serializable
class Store(
    @SerialName("product_id") val productId: Int?,
    @SerialName("store") val store: StoreDetails?,
    @SerialName("store_id") val storeId: Int?
)

@Serializable
class StoreDetails(
    @SerialName("name") val name: String?,
    @SerialName("ssl") val ssl: String?,
    @SerialName("store_id") val storeId: Int?,
    @SerialName("url") val url: String?
)