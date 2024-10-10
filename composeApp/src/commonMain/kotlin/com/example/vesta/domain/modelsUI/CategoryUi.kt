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
    val pageGroupLinks: String,
    val dateAdded: String,
    val dateModified: String,
    val lastSyncAt: String,
    val onesUuid: String,
    val description: List<DescriptionUi>,
    val category: List<SubCategoryUi>
)

data class DescriptionUi(
    val categoryId: Int,
    val languageId: Int,
    val name: String,
    val description: String,
    val metaTitle: String,
    val metaH1: String,
    val metaDescription: String,
    val metaKeyword: String
)

data class SubCategoryUi(
    val categoryId: Int,
    val image: String,
    val octImage: String,
    val parentId: Int,
    val top: Int,
    val column: Int,
    val sortOrder: Int,
    val status: Int,
    val pageGroupLinks: String,
    val dateAdded: String,
    val dateModified: String,
    val lastSyncAt: String,
    val onesUuid: String,
    val description: List<DescriptionUi>
)