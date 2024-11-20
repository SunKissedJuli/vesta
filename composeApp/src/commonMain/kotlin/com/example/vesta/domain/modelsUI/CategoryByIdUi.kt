package com.example.vesta.domain.modelsUI

import com.example.vesta.data.models.CategoryById
import com.example.vesta.data.models.ProductsDataResponse
import com.example.vesta.data.models.ProductsResponse
import kotlinx.serialization.SerialName
import kotlinx.serialization.Serializable


class CategoryByIdResponseUi(
    val category: CategoryByIdUi,
    val products: List<ProductsDataResponseUi>,
)

data class CategoryByIdUi(
    val categoryId: Int,
    val children: List<CategoryByIdUi>,
    val column: Int,
    val description: DescriptionUi,
    val image: String,
    val octImage: String,
    val parentId: Int,
    val sortOrder: Int,
    val status: Int,
    val top: Int
){
    companion object{
        val empty = CategoryByIdUi(
            categoryId = 0,
            children = emptyList(),
            column = 0,
            description = DescriptionUi.empty,
            image = "",
            octImage = "",
            parentId = 0,
            sortOrder = 0,
            status = 0,
            top = 0
        )
    }
}

data class LinkUi(
    val active: Boolean,
    val label: String,
    val url: String
)
