package com.example.vesta.data.models.product

import kotlinx.serialization.Serializable
import kotlinx.serialization.SerialName

data class CategoryUi(
    val category: CategoryDetailsUi,
    val categoryId: Int,
    val lastSyncAt: String,
    val mainCategory: Int,
    val productId: Int
) {
    companion object {
        val empty = CategoryUi(
            category = CategoryDetailsUi.empty,
            categoryId = 0,
            lastSyncAt = "",
            mainCategory = 0,
            productId = 0
        )
    }
}

data class CategoryDetailsUi(
    val categoryId: Int,
    val column: Int,
    val description: List<DescriptionUi>,
    val image: String,
    val octImage: String,
    val parentId: Int,
    val sortOrder: Int,
    val status: Int,
    val top: Int
) {
    companion object {
        val empty = CategoryDetailsUi(
            categoryId = 0,
            column = 0,
            description = emptyList(),
            image = "",
            octImage = "",
            parentId = 0,
            sortOrder = 0,
            status = 0,
            top = 0
        )
    }
}

data class DescriptionUi(
    val categoryId: Int,
    val description: String,
    val metaKeyword: String,
    val name: String
) {
    companion object {
        val empty = DescriptionUi(
            categoryId = 0,
            description = "",
            metaKeyword = "",
            name = "",
        )
    }
}

class ImageUi(
    val image: String,
    val productId: Int,
    val productImageId: Int,
    val sortOrder: Int
) {
    companion object {
        val empty = Image(
            image = "",
            productId = 0,
            productImageId = 0,
            sortOrder = 0
        )
    }
}