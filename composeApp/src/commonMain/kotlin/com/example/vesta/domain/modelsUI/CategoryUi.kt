package com.example.vesta.domain.modelsUI

data class DescriptionUi(
    val categoryId: Int,
    val name: String,
    val description: String,
    val metaKeyword: String
)

data class CategoryUi(
    val categoryId: Int,
    val image: String,
    val name: String,
    val octImage: String,
    val description: String,
    val metaDescription: String,
    val metaTitle: String,
    val metaKeyword: String,
)