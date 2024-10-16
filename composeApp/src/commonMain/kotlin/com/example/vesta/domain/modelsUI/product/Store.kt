package com.example.vesta.data.models.product

import kotlinx.serialization.Serializable
import kotlinx.serialization.SerialName

class StoreUi(
    val productId: Int,
    val store: StoreDetailsUi,
    val storeId: Int
) {
    companion object {
        val empty = StoreUi(
            productId = 0,
            store = StoreDetailsUi.empty,
            storeId = 0
        )
    }
}

class StoreDetailsUi(
    val name: String,
    val ssl: String,
    val storeId: Int,
    val url: String
) {
    companion object {
        val empty = StoreDetailsUi(
            name = "",
            ssl = "",
            storeId = 0,
            url = ""
        )
    }
}