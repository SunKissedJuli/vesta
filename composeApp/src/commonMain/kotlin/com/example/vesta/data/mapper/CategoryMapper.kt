package com.example.vesta.data.mapper

import com.example.vesta.commons.Constantas.BASE_IMAGE_URL
import com.example.vesta.data.models.CategoryResponse
import com.example.vesta.data.models.DescriptionResponse
import com.example.vesta.data.models.SubCategoryResponse
import com.example.vesta.domain.modelsUI.CategoryUi
import com.example.vesta.domain.modelsUI.DescriptionUi
import com.example.vesta.domain.modelsUI.SubCategoryUi

fun List<CategoryResponse>.toUI(): List<CategoryUi> {
    return map { it.toUI() }
}

fun CategoryResponse.toUI(): CategoryUi {
    return CategoryUi(
        categoryId = this.categoryId ?: 0,
        image = this.image.orEmpty(),
        octImage = this.octImage.orEmpty(),
        parentId = this.parentId ?: 0,
        top = this.top ?: 0,
        column = this.column ?: 0,
        sortOrder = this.sortOrder ?: 0,
        status = this.status ?: 0,
        pageGroupLinks = this.pageGroupLinks.orEmpty(),
        dateAdded = this.dateAdded.orEmpty(),
        dateModified = this.dateModified.orEmpty(),
        lastSyncAt = this.lastSyncAt.orEmpty(),
        onesUuid = this.onesUuid.orEmpty(),
        description = this.description?.map { it.toUI() } ?: emptyList(),
        category = this.children?.map { it.toUI() } ?: emptyList()
    )
}

fun DescriptionResponse.toUI(): DescriptionUi {
    return DescriptionUi(
        categoryId = this.categoryId ?: 0,
        languageId = this.languageId ?: 0,
        name = this.name.orEmpty(),
        description = this.description.orEmpty(),
        metaTitle = this.metaTitle.orEmpty(),
        metaH1 = this.metaH1.orEmpty(),
        metaDescription = this.metaDescription.orEmpty(),
        metaKeyword = this.metaKeyword.orEmpty()
    )
}

fun SubCategoryResponse.toUI(): SubCategoryUi {
    return SubCategoryUi(
        categoryId = this.categoryId ?: 0,
        image = this.image.orEmpty(),
        octImage = this.octImage.orEmpty(),
        parentId = this.parentId ?: 0,
        top = this.top ?: 0,
        column = this.column ?: 0,
        sortOrder = this.sortOrder ?: 0,
        status = this.status ?: 0,
        pageGroupLinks = this.pageGroupLinks.orEmpty(),
        dateAdded = this.dateAdded.orEmpty(),
        dateModified = this.dateModified.orEmpty(),
        lastSyncAt = this.lastSyncAt.orEmpty(),
        onesUuid = this.onesUuid.orEmpty(),
        description = this.description?.map { it.toUI() } ?: emptyList()
    )
}