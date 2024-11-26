package com.example.vesta.domain.modelsUI.blog

import com.example.vesta.domain.modelsUI.OctStickersUi


data class RelatedProductUi(
    val image: String,
    val model: String,
    val name: String,
    val octStickers: OctStickersUi,
    val price: Int,
    val productId: Int,
    val quantity: Int,
    val quantityStatus: String,
    val weight: String
)