package com.example.vesta.screen.cart

import com.example.vesta.commons.Constantas.DEFAULT_STRING
import com.example.vesta.domain.modelsUI.CategoryUi


data class CartState(
    val currentUser: List<CategoryUi>,
    val topCategoryList : List<CategoryUi>,
    val searchString: String,
){
    companion object{
        val InitState = AboutState(
            categoryList = listOf(),
            topCategoryList = listOf(),
            searchString = DEFAULT_STRING
        )
    }
}
