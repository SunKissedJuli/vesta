package com.example.vesta.data.mapper

import com.example.vesta.data.models.ProductDataResponse
import com.example.vesta.data.models.ProductsResponse
import com.example.vesta.domain.modelsUI.OctStickersUi
import com.example.vesta.domain.modelsUI.ProductDataResponseUi
import com.example.vesta.domain.modelsUI.ProductsResponseUi

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

fun ProductDataResponse.toUI(): ProductDataResponseUi {
    return ProductDataResponseUi(
        categoryId = categoryId ?: 0,
        description = description.orEmpty(),
        image = image.orEmpty(),
        isbn = isbn.orEmpty(),
        manufacturerId = manufacturerId ?: 0,
        metaKeyword = metaKeyword.orEmpty(),
        metaTitle = metaTitle.orEmpty(),
        model = if(model=="?") "" else model.orEmpty(),
        name = name.orEmpty(),
        nameKorr = nameKorr.orEmpty(),
        octStickers = octStickers?.toUI()?: OctStickersUi.empty,
        price = price ?: 0,
        pricep = pricep.orEmpty(),
        productId = productId ?: 0,
        quantity = quantity ?: 0,
        spb1 = spb1 ?: 0,
        spb10 = spb10 ?: 0,
        spb11 = spb11 ?: 0,
        spb12 = spb12 ?: 0,
        spb13 = spb13 ?: 0,
        spb14 = spb14 ?: 0,
        spb15 = spb15 ?: 0,
        spb16 = spb16 ?: 0,
        spb2 = spb2 ?: 0,
        spb3 = spb3 ?: 0,
        spb4 = spb4 ?: 0,
        spb5 = spb5 ?: 0,
        spb6 = spb6 ?: 0,
        spb7 = spb7 ?: 0,
        spb8 = spb8 ?: 0,
        spb9 = spb9 ?: 0,
        status = status ?: 0,
        stockStatusId = stockStatusId ?: 0,
        storeId = storeId ?: 0,
        tag = tag.orEmpty()
    )
}
