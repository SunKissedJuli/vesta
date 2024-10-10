package com.example.vesta.screen.category

import com.example.vesta.commons.Constantas.DEFAULT_STRING
import com.example.vesta.domain.modelsUI.CategoryUi

data class CategoryState(
    val categoryList: List<CategoryUi>,
    val topCategoryList : List<CategoryUi>,
    val searchString: String,
){
    companion object{
        val InitState = CategoryState(
            categoryList = listOf(),
            topCategoryList = listOf(),
            searchString = DEFAULT_STRING
        )
    }
}
