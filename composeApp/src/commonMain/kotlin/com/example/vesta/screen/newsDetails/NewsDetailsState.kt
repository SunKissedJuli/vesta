package com.example.vesta.screen.newsDetails

import com.example.vesta.commons.Constantas.DEFAULT_BOOLEAN
import com.example.vesta.commons.Constantas.DEFAULT_STRING
import com.example.vesta.data.models.product.ProductResponseUi
import com.example.vesta.domain.modelsUI.info.MainBlogObjectUi
import com.example.vesta.screen.home.HomeState
import com.example.vesta.strings.VestaResourceStrings

data class NewsDetailsState(
    val stockData: MainBlogObjectUi,
){
    companion object{
        val InitState = NewsDetailsState(
            stockData = MainBlogObjectUi.empty
        )
    }
}

