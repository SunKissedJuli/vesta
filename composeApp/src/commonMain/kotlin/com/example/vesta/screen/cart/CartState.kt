package com.example.vesta.screen.cart

import cafe.adriel.voyager.navigator.tab.TabNavigator
import com.example.vesta.commons.Constantas.DEFAULT_STRING
import com.example.vesta.domain.modelsUI.CategoryUi


data class CartState(
    val tabNavigator: TabNavigator?
){
    companion object{
        val InitState = CartState(
            tabNavigator = null
        )
    }
}
