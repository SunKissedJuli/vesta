package com.example.vesta.domain.modelsUI.info

data class NewsUi(
   val current_page: Int,
   val data: List<NewsDataUi>
)

data class NewsDataUi(
    val blogarticleId: Int,
    val blogcategoryId: Int,
    val dateAdded: String,
    val dateAvailable: String,
    val dateModified: String,
    val description: String,
    val image: String,
    val languageId: Int,
    val metaDescription: String,
    val metaKeyword: String,
    val metaTitle: String,
    val name: String,
    val shotDescription: String,
    val sortOrder: Int,
    val status: Int,
    val storeId: Int,
    val tag: String
)