package com.example.vesta.screen.product

import com.example.vesta.data.models.product.ProductResponseUi

data class ProductState(
    val productData: ProductResponseUi
){
    companion object{
        val InitState = ProductState(
            productData = ProductResponseUi.empty
        )
    }
}
