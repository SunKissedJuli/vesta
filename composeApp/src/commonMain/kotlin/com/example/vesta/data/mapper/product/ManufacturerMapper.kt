package com.example.vesta.data.models.product

import kotlinx.serialization.Serializable
import kotlinx.serialization.SerialName

fun Manufacturer.toUI(): ManufacturerUi {
    return ManufacturerUi(
        image = this.image.orEmpty(),
        lastSyncAt = this.lastSyncAt.orEmpty(),
        manufacturerId = this.manufacturerId ?: 0,
        name = this.name.orEmpty(),
        onesUuid = this.onesUuid.orEmpty(),
        sortOrder = this.sortOrder ?: 0
    )
}