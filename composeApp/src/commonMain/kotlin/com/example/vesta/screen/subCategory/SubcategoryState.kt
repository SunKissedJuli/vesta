package com.example.vesta.screen.subCategory

import com.example.vesta.domain.modelsUI.CategoryByIdUi
import com.example.vesta.domain.modelsUI.CategoryUi
import com.example.vesta.domain.modelsUI.ProductDataResponseUi
import com.example.vesta.domain.modelsUI.ProductsResponseUi

data class SubcategoryState(
    val subcategoryList: CategoryByIdUi,
    val productList: List<ProductDataResponseUi>,
){
    companion object{
        val InitState = SubcategoryState(
            subcategoryList = CategoryByIdUi.empty,
            productList = listOf()
        )
    }
}
