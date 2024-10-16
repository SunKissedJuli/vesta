package com.example.vesta.data.mapper.product

import com.example.vesta.data.models.product.Store
import com.example.vesta.data.models.product.StoreDetails
import com.example.vesta.data.models.product.StoreDetailsUi
import com.example.vesta.data.models.product.StoreUi

fun Store.toUI(): StoreUi {
    return StoreUi(
        productId = this.productId ?: 0,
        store = this.store?.toUI()?:StoreDetailsUi.empty,
        storeId = this.storeId ?: 0
    )
}

fun StoreDetails.toUI(): StoreDetailsUi {
    return StoreDetailsUi(
        name = this.name.orEmpty(),
        ssl = this.ssl.orEmpty(),
        storeId = this.storeId ?: 0,
        url = this.url.orEmpty()
    )
}