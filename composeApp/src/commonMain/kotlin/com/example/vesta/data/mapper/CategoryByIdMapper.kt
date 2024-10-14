package com.example.vesta.data.mapper

import com.example.vesta.data.models.CategoryById
import com.example.vesta.data.models.CategoryByIdResponse
import com.example.vesta.data.models.CategoryResponse
import com.example.vesta.data.models.Link
import com.example.vesta.data.models.ProductsResponse
import com.example.vesta.domain.modelsUI.CategoryByIdResponseUi
import com.example.vesta.domain.modelsUI.CategoryByIdUi
import com.example.vesta.domain.modelsUI.CategoryUi
import com.example.vesta.domain.modelsUI.LinkUi
import com.example.vesta.domain.modelsUI.ProductsResponseUi


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
        column = column ?: 0,
        description = description?.map { it.toUI() } ?: emptyList(),
        image = image.orEmpty(),
        octImage = octImage.orEmpty(),
        parentId = parentId ?: 0,
        sortOrder = sortOrder ?: 0,
        status = status ?: 0,
        top = top ?: 0
    )
}

fun CategoryByIdResponse.toUI(): CategoryByIdResponseUi {
    return CategoryByIdResponseUi(
        category = category?.toUI()?: CategoryByIdUi.empty,
        products = products?.map{it.toUI()}  ?: emptyList()
    )
}