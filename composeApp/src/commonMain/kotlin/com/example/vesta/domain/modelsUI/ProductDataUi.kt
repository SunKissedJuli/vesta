package com.example.vesta.domain.modelsUI

import kotlinx.serialization.SerialName
import kotlinx.serialization.Serializable

data class ProductDataResponseUi(
    val categoryId: Int,
    val description: String,
    val image: String,
    val isbn: String,
    val manufacturerId: Int,
    val metaKeyword: String,
    val metaTitle: String,
    val model: String,
    val name: String,
    val nameKorr: String,
    val octStickers: OctStickersUi,
    val price: Int,
    val pricep: String,
    val productId: Int,
    val quantity: Int,
    val spb1: Int,
    val spb10: Int,
    val spb11: Int,
    val spb12: Int,
    val spb13: Int,
    val spb14: Int,
    val spb15: Int,
    val spb16: Int,
    val spb2: Int,
    val spb3: Int,
    val spb4: Int,
    val spb5: Int,
    val spb6: Int,
    val spb7: Int,
    val spb8: Int,
    val spb9: Int,
    val status: Int,
    val stockStatusId: Int,
    val storeId: Int,
    val tag: String
)

data class ProductsResponseUi(
    val currentPage: Int,
    val data: List<ProductDataResponseUi>,
    val firstPageUrl: String,
    val from: Int,
    val lastPage: Int,
    val lastPageUrl: String,
    val links: List<LinkUi>,
    val nextPageUrl: String,
    val path: String,
    val perPage: Int,
    val prevPageUrl: String,
    val to: Int,
    val total: Int
){
    companion object{
        val empty = ProductsResponseUi(
            currentPage = 0,
            data = emptyList(),
            firstPageUrl = "",
            from = 0,
            lastPage = 0,
            lastPageUrl = "",
            links = emptyList(),
            nextPageUrl = "",
            path = "",
            perPage = 0,
            prevPageUrl = "",
            to = 0,
            total = 0,
        )
    }
}