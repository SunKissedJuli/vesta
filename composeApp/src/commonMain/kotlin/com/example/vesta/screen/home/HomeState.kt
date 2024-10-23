package com.example.vesta.screen.home

import com.example.vesta.commons.Constantas.DEFAULT_BOOLEAN
import com.example.vesta.data.models.product.ProductResponseUi
import com.example.vesta.domain.modelsUI.info.StocksUi

data class HomeState(
    val stockData: List<StocksUi>,
    val isOpenPhone: Boolean,
    val isOpenSity: Boolean,
){
    companion object{
        val InitState = HomeState(
            stockData = emptyList(),
            isOpenPhone = DEFAULT_BOOLEAN,
            isOpenSity = DEFAULT_BOOLEAN
        )
    }
}
