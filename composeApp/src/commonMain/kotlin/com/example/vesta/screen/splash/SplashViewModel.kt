package com.example.vesta.screen.splash

import com.example.vesta.domain.manager.AuthManager
import com.example.vesta.domain.manager.ObserverManager
import com.example.vesta.domain.repository.UserRepository
import com.example.vesta.platform.BaseScreenModel
import org.koin.core.component.inject
import org.orbitmvi.orbit.syntax.simple.intent
import org.orbitmvi.orbit.syntax.simple.postSideEffect

internal class SplashViewModel: BaseScreenModel<Unit, SplashEvent>(Unit) {
    private val manager: AuthManager by inject()
    private val observerManager: ObserverManager by inject()
    private val userRepository: UserRepository by inject()

    fun isAutorize() = intent{
        if(manager.token.isNullOrEmpty()){
            if(manager.sessionId.isNullOrEmpty()){
                registrationNullableUser()
            }
            else{
                postSideEffect(SplashEvent.UserNotAuthorize)
            }
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

    private fun registrationNullableUser() = intent{
        launchOperation(
            operation = {
                userRepository.registrationNullableUser()
            },
            success = { response ->
                manager.sessionId = response.plainTextToken
                postSideEffectLocal(SplashEvent.UserNotAuthorize)
            }
        )
    }
}