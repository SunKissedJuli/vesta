package com.example.vesta.screen.splash

import com.example.vesta.domain.manager.AuthManager
import com.example.vesta.domain.repository.InfoRepository
import com.example.vesta.platform.BaseScreenModel
import kotlinx.coroutines.delay
import org.koin.core.component.inject
import org.orbitmvi.orbit.syntax.simple.intent
import org.orbitmvi.orbit.syntax.simple.postSideEffect

internal class SplashViewModel: BaseScreenModel<Unit, SplashEvent>(Unit) {
    private val infoRepository: InfoRepository by inject()
    private val manager: AuthManager by inject()
    fun isAutorize() = intent{
        println(manager.sity)
        //когда будет запрос из апишки на авторизацию, тут она будет проверяться
        delay(500)
        postSideEffect(SplashEvent.UserNotAutorize)

    }
}