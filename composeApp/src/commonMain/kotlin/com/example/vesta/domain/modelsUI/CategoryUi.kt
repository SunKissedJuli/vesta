package com.example.vesta.domain.modelsUI

data class CategoryUi(
    val categoryId: Int,
    val image: String,
    val octImage: String,
    val parentId: Int,
    val top: Int,
    val column: Int,
    val sortOrder: Int,
    val status: Int,
    val description: List<DescriptionUi>,
)

data class DescriptionUi(
    val categoryId: Int,
    val name: String,
    val description: String,
    val metaKeyword: String
)