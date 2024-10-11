package com.example.vesta.screen.subCategory

import com.example.vesta.domain.modelsUI.CategoryUi

data class SubcategoryState(
    val subcategoryList: List<CategoryUi>
){
    companion object{
        val InitState = SubcategoryState(
            subcategoryList = listOf()
        )
    }
}
