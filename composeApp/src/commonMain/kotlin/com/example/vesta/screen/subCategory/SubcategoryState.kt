package com.example.vesta.screen.subCategory

import com.example.vesta.commons.Constantas.DEFAULT_BOOLEAN
import com.example.vesta.domain.modelsUI.CategoryByIdUi
import com.example.vesta.domain.modelsUI.CategoryUi
import com.example.vesta.domain.modelsUI.ManufacturersUi
import com.example.vesta.domain.modelsUI.ProductInCategoryUi
import com.example.vesta.domain.modelsUI.ProductsDataResponseUi
import com.example.vesta.domain.modelsUI.ProductsResponseUi

data class SubcategoryState(
    val subcategoryList: CategoryByIdUi,
    val productList: List<ProductInCategoryUi>,
    val manufacturers: List<ManufacturersUi>,
    val isProducts: Boolean,
    val showFilter: Boolean,

){
    companion object{
        val InitState = SubcategoryState(
            subcategoryList = CategoryByIdUi.empty,
            productList = listOf(),
            manufacturers = listOf(),
            isProducts = DEFAULT_BOOLEAN,
            showFilter = DEFAULT_BOOLEAN
        )
    }
}
