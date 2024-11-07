package com.example.vesta.data.models.product

import com.example.vesta.commons.Constantas.BASE_IMAGE_URL
import kotlinx.serialization.Serializable
import kotlinx.serialization.SerialName

fun Category.toUI(): CategoryUi {
    return CategoryUi(
        category = this.category?.toUI()?: CategoryDetailsUi.empty,
        categoryId = this.categoryId ?: 0,
        lastSyncAt = this.lastSyncAt.orEmpty(),
        mainCategory = this.mainCategory ?: 0,
        productId = this.productId ?: 0,
    )
}

fun CategoryDetails.toUI(): CategoryDetailsUi {
    return CategoryDetailsUi(
        categoryId = this.categoryId ?: 0,
        column = this.column ?: 0,
        description = this.description?.map { it.toUI() } ?: emptyList(),
        image = this.image.orEmpty(),
        octImage = this.octImage.orEmpty(),
        parentId = this.parentId ?: 0,
        sortOrder = this.sortOrder ?: 0,
        status = this.status ?: 0,
        top = this.top ?: 0
    )
}

fun CategoryDescription.toUI(): DescriptionUi {
    return DescriptionUi(
        categoryId = this.categoryId ?: 0,
        description = this.description.orEmpty(),
        metaKeyword = this.metaKeyword.orEmpty(),
        name = this.name.orEmpty(),
    )
}

fun Image.toUI(): ImageUi {
    return ImageUi(
        image = this.image.orEmpty(),
        //if(!image.isNullOrEmpty()) BASE_IMAGE_URL + image else "",
        productId = this.productId ?: 0,
        productImageId = this.productImageId ?: 0,
        sortOrder = this.sortOrder ?: 0
    )
}