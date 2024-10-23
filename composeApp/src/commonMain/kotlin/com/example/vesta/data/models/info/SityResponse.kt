package com.example.vesta.data.models.info

import kotlinx.serialization.SerialName
import kotlinx.serialization.Serializable

@Serializable
class SityResponse(
    @SerialName("store_id") val storeId: Int?,
    @SerialName("name") val name: String?,
    @SerialName("url") val url: String?,
    @SerialName("ssl") val ssl: String?,
    @SerialName("phone") val phone: String?
)

