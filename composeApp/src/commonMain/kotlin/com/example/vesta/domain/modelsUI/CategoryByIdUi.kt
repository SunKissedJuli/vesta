package com.example.vesta.domain.modelsUI

import com.example.vesta.data.models.CategoryById
import com.example.vesta.data.models.Manufacturers
import com.example.vesta.data.models.OctStickers
import com.example.vesta.data.models.ProductsDataResponse
import com.example.vesta.data.models.ProductsResponse
import kotlinx.serialization.SerialName
import kotlinx.serialization.Serializable


data class CategoryByIdResponseUi(
    val category: CategoryByIdUi,
    val products: List<ProductInCategoryUi>,
    val manufacturers: List<ManufacturersUi>
)

data class ManufacturersUi(
    val manufacturerId: Int,
    val name:String,
)

data class CategoryByIdUi(
    val categoryId: Int,
    val children: List<CategoryByIdUi>,
    val image: String,
    val name: String
){
    companion object{
        val empty = CategoryByIdUi(
            categoryId = 0,
            children = emptyList(),
            image = "",
            name = ""
        )
    }
}

data class ProductInCategoryUi(
    val categoryId: Int?,
    val image: String,
    val manufacturerId: Int,
    val manufacturerName: String,
    val name: String,
    val octStickers: OctStickersUi,
    val price: Int,
    val productId: Int,
    val quantity: Int,
    val quantityStatus: String,
    val isFavorite: Boolean
)

data class LinkUi(
    val active: Boolean,
    val label: String,
    val url: String
)
