package com.example.vesta.data.mapper

import com.example.vesta.data.models.ProductsDataResponse
import com.example.vesta.data.models.ProductsResponse
import com.example.vesta.data.models.product.ProductResponse
import com.example.vesta.data.models.product.ProductResponseUi
import com.example.vesta.data.models.product.toUI
import com.example.vesta.domain.modelsUI.OctStickersUi
import com.example.vesta.domain.modelsUI.ProductsDataResponseUi
import com.example.vesta.domain.modelsUI.ProductsResponseUi
import com.example.vesta.ext.cleanHtml

fun ProductsResponse.toUI(): ProductsResponseUi {
    return ProductsResponseUi(
        currentPage = currentPage ?: 0,
        data = data?.map { it.toUI() } ?: emptyList(),
        firstPageUrl = firstPageUrl.orEmpty(),
        from = from ?: 0,
        lastPage = lastPage ?: 0,
        lastPageUrl = lastPageUrl.orEmpty(),
        links = links?.map { it.toUI() } ?: emptyList(),
        nextPageUrl = nextPageUrl.orEmpty(),
        path = path.orEmpty(),
        perPage = perPage ?: 0,
        prevPageUrl = prevPageUrl.orEmpty(),
        to = to ?: 0,
        total = total ?: 0
    )
}

fun List<ProductsDataResponse>.toUI(): List<ProductsDataResponseUi> {
    return map { it.toUI() }
}

fun ProductsDataResponse.toUI(): ProductsDataResponseUi {
    return ProductsDataResponseUi(
        categoryId = categoryId ?: 0,
        description = description?.cleanHtml().orEmpty(),
        image = image.orEmpty(),
        isbn = isbn.orEmpty(),
        manufacturerId = manufacturerId ?: 0,
        metaKeyword = metaKeyword.orEmpty(),
        metaTitle = metaTitle.orEmpty(),
        model = if(model=="?") "" else model.orEmpty(),
        name = name?.cleanHtml().orEmpty(),
        nameKorr = nameKorr?.cleanHtml().orEmpty(),
        octStickers = octStickers?.toUI()?: OctStickersUi.empty,
        price = price ?: 0,
        pricep = pricep.orEmpty(),
        productId = productId ?: 0,
        quantity = quantity ?: 0,
        status = status ?: 0,
        stockStatusId = stockStatusId ?: 0,
        storeId = storeId ?: 0,
        tag = tag.orEmpty(),
        quantityStatus = quantityStatus.orEmpty()
    )
}
