package com.example.vesta.data.models.product

import kotlinx.serialization.Serializable
import kotlinx.serialization.SerialName

data class ManufacturerUi(
    val image: String,
    val lastSyncAt: String,
    val manufacturerId: Int,
    val name: String,
    val onesUuid: String,
    val sortOrder: Int
) {
    companion object {
        val empty = ManufacturerUi(
            image = "",
            lastSyncAt = "",
            manufacturerId = 0,
            name = "",
            onesUuid = "",
            sortOrder = 0
        )
    }
}
