package com.example.vesta.screen.home

import com.example.vesta.commons.Constantas.DEFAULT_BOOLEAN
import com.example.vesta.commons.Constantas.DEFAULT_STRING
import com.example.vesta.data.models.product.ProductResponseUi
import com.example.vesta.domain.modelsUI.ProductsDataResponseUi
import com.example.vesta.domain.modelsUI.ProductsResponseUi
import com.example.vesta.domain.modelsUI.info.MainBlogObjectUi
import com.example.vesta.domain.modelsUI.info.NewsDataUi
import com.example.vesta.domain.modelsUI.info.StocksUi
import com.example.vesta.strings.VestaResourceStrings

data class HomeState(
    val stockData: MainBlogObjectUi,
    val newsData: MainBlogObjectUi,
    val stockSliderData: MainBlogObjectUi,
    val newProductsData: MainBlogObjectUi,
    val productList: List<ProductResponseUi>,
    val isOpenPhone: Boolean,
    val isOpenSity: Boolean,
    val phone: String,
    val selectedPage: Int,
    val pages: List<String>
){
    companion object{
        val InitState = HomeState(
            stockData = MainBlogObjectUi.empty,
            newsData = MainBlogObjectUi.empty,
            stockSliderData = MainBlogObjectUi.empty,
            newProductsData = MainBlogObjectUi.empty,
            productList = listOf(),
            isOpenPhone = DEFAULT_BOOLEAN,
            isOpenSity = DEFAULT_BOOLEAN,
            phone = DEFAULT_STRING,
            selectedPage = 0,
            pages = listOf(
                VestaResourceStrings.everything,
                VestaResourceStrings.news,
                VestaResourceStrings.stocks,
                VestaResourceStrings.new_products)
        )
    }
}
