package com.example.vesta.screen.home

import com.example.vesta.data.models.product.ProductResponseUi
import com.example.vesta.domain.modelsUI.info.StocksUi

data class HomeState(
    val stockData: List<StocksUi>
){
    companion object{
        val InitState = HomeState(
            stockData = emptyList()
        )
    }
}
