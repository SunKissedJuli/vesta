package com.example.vesta.screen.favorites

import com.example.vesta.commons.Constantas.DEFAULT_STRING
import com.example.vesta.domain.modelsUI.CategoryUi
import com.example.vesta.domain.modelsUI.blog.RelatedProductUi

data class FavoritesState(
    val favorites: List<RelatedProductUi>,
){
    companion object{
        val InitState = FavoritesState(
            favorites = listOf(),
        )
    }
}

