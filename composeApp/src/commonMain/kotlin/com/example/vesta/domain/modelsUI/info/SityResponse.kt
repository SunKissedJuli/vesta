package com.example.vesta.data.models.info

import kotlinx.serialization.SerialName
import kotlinx.serialization.Serializable

@Serializable
data class SityUi(
    val storeId: Int,
    val name: String,
    val url: String,
    val ssl: String
)

