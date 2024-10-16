package com.example.vesta.domain.modelsUI.info

import kotlinx.serialization.Serializable
import kotlinx.serialization.SerialName

data class ShopsUi(
    val active: Int,
    val address: String,
    val coordinates: String,
    val isWholesale: Int,
    val map: String,
    val name: String,
    val phoneNumber: String,
    val shopId: Int,
    val storeId: Int,
    val workingHours: String
)