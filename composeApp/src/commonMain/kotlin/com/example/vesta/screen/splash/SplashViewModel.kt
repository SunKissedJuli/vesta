package com.example.vesta.screen.splash

import com.example.vesta.domain.manager.AuthManager
import com.example.vesta.domain.manager.ObserverManager
import com.example.vesta.domain.repository.InfoRepository
import com.example.vesta.platform.BaseScreenModel
import kotlinx.coroutines.delay
import org.koin.core.component.inject
import org.orbitmvi.orbit.syntax.simple.intent
import org.orbitmvi.orbit.syntax.simple.postSideEffect

internal class SplashViewModel: BaseScreenModel<Unit, SplashEvent>(Unit) {
    private val manager: AuthManager by inject()
    private val observerManager: ObserverManager by inject()
    fun isAutorize() = intent{
        if(manager.token.isNullOrEmpty()){
            postSideEffect(SplashEvent.UserNotAuthorize)
        }
        else{
            postSideEffectLocal(SplashEvent.UserAuthorize)
        }
    }

    fun updateBottomBarVisible(isVisible: Boolean){
        observerManager.setBottomBarVisibility(isVisible)
    }

    fun updateIsTabNavigator(isVisible: Boolean){
        observerManager.setIsTabNavigator(isVisible)
    }

    fun isTabNavigator() : Boolean{
        return observerManager.isTabNavigator()
    }
}