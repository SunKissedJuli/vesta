package com.example.vesta.screen.welcome

import com.example.vesta.domain.manager.ObserverManager
import com.example.vesta.platform.BaseScreenModel
import org.koin.core.component.inject

internal class WelcomeViewModel:BaseScreenModel<Unit, Unit>(Unit) {

    private val bottomBarVisibleManager: ObserverManager by inject()

    fun setBottomBarVisible(visible: Boolean){
        bottomBarVisibleManager.setBottomBarVisibility(visible)
    }
}