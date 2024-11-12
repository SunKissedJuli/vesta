package com.example.vesta.screen.cart

import cafe.adriel.voyager.navigator.tab.TabNavigator
import com.example.vesta.domain.manager.ObserverManager
import com.example.vesta.platform.BaseScreenModel
import org.koin.core.component.inject
import org.orbitmvi.orbit.syntax.simple.blockingIntent
import org.orbitmvi.orbit.syntax.simple.reduce

internal class CartViewModel: BaseScreenModel<CartState, Unit>(CartState.InitState) {

    private val bottomBarVisibleManager: ObserverManager by inject()

    fun loadData(){
    }

    fun updateTabNavigator(navigator: TabNavigator) = blockingIntent {
        reduce { state.copy(tabNavigator = navigator) }
    }

    fun isTabNavigator() : Boolean{
        return bottomBarVisibleManager.isTabNavigator()
    }
}