package com.example.vesta.data.models.info

import kotlinx.serialization.Serializable
import kotlinx.serialization.SerialName

@Serializable
data class ShopsResponse(
    @SerialName("active") val active: Int?,
    @SerialName("address") val address: String?,
    @SerialName("coordinates") val coordinates: String?,
    @SerialName("is_wholesale") val isWholesale: Int?,
    @SerialName("map") val map: String?,
    @SerialName("name") val name: String?,
    @SerialName("phone_number") val phoneNumber: String?,
    @SerialName("shop_id") val shopId: Int?,
    @SerialName("store_id") val storeId: Int?,
    @SerialName("working_hours") val workingHours: String?
)