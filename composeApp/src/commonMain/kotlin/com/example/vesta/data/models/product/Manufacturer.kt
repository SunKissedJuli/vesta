package com.example.vesta.data.models.product

import kotlinx.serialization.Serializable
import kotlinx.serialization.SerialName

@Serializable
class Manufacturer(
    @SerialName("image") val image: String?,
    @SerialName("last_sync_at") val lastSyncAt: String?,
    @SerialName("manufacturer_id") val manufacturerId: Int?,
    @SerialName("name") val name: String?,
    @SerialName("ones_uuid") val onesUuid: String?,
    @SerialName("sort_order") val sortOrder: Int?
)