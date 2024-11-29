package com.example.vesta.data.mapper

import com.example.vesta.data.models.CategoryById
import com.example.vesta.data.models.CategoryByIdResponse
import com.example.vesta.data.models.Link
import com.example.vesta.domain.modelsUI.CategoryByIdResponseUi
import com.example.vesta.domain.modelsUI.CategoryByIdUi
import com.example.vesta.domain.modelsUI.LinkUi
import com.example.vesta.data.mapper.toUI
import com.example.vesta.data.mapper.toUI
import com.example.vesta.data.models.ProductInCategoryResponse
import com.example.vesta.domain.modelsUI.DescriptionUi
import com.example.vesta.domain.modelsUI.OctStickersUi
import com.example.vesta.domain.modelsUI.ProductInCategoryUi


fun List<CategoryById>.toUI(): List<CategoryByIdUi> {
    return map { it.toUI() }
}

fun Link.toUI(): LinkUi {
    return LinkUi(
        active = active ?: false,
        label = label.orEmpty(),
        url = url.orEmpty()
    )
}

fun CategoryById.toUI(): CategoryByIdUi {
    return CategoryByIdUi(
        categoryId = categoryId ?: 0,
        children = children?.map { it.toUI() }?: emptyList(),
        image = image.orEmpty(),
        name = name.orEmpty()
    )
}

fun CategoryByIdResponse.toUI(): CategoryByIdResponseUi {
    return CategoryByIdResponseUi(
        category = category?.toUI()?: CategoryByIdUi.empty,
        products = products?.map{it.toUI()}  ?: emptyList()
    )
}

fun ProductInCategoryResponse.toUI(): ProductInCategoryUi{
    return ProductInCategoryUi(
        categoryId = this.categoryId?:0,
        image = this.image.orEmpty(),
        manufacturerId = this.manufacturerId?:0,
        manufacturerName = this.manufacturerName.orEmpty(),
        nameKorr = this.nameKorr.orEmpty(),
        octStickers = octStickers?.toUI()?: OctStickersUi.empty,
        price = this.price?:0,
        productId = this.productId?:0,
        quantityStatus = this.quantityStatus.orEmpty(),
        quantity = this.quantity?:0,
        isFavorite = this.isFavorite?:false
    )
}