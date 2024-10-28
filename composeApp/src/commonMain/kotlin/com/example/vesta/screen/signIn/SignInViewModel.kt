package com.example.vesta.screen.signIn

import cafe.adriel.voyager.navigator.Navigator
import com.example.vesta.data.models.info.SityUi
import com.example.vesta.domain.manager.AuthManager
import com.example.vesta.domain.manager.ObserverManager
import com.example.vesta.domain.repository.InfoRepository
import com.example.vesta.domain.repository.UserRepository
import com.example.vesta.platform.BaseScreenModel
import com.example.vesta.screen.profile.ProfileScreen
import org.koin.core.component.inject
import org.orbitmvi.orbit.syntax.simple.blockingIntent
import org.orbitmvi.orbit.syntax.simple.intent
import org.orbitmvi.orbit.syntax.simple.reduce

internal class SignInViewModel:BaseScreenModel<SignInState, Unit>(SignInState.InitState) {

    private val userRepository: UserRepository by inject()
    private val authManager: AuthManager by inject()
    private val bottomBarVisibleManager: ObserverManager by inject()

    fun updatePassword(newPassword: String) = blockingIntent {
        reduce { state.copy(password = newPassword) }
    }

    fun updateEmail(newEmail: String) = blockingIntent {
        reduce { state.copy(email = newEmail) }
    }

    fun autorize(login: String, password: String, navigator: Navigator) = intent {
        launchOperation(
            operation = {
                userRepository.autirize(login, password)
            },
            success = { response ->
                authManager.token = response.plainTextToken
                setBottomBarVisible(true)
                navigator.push(ProfileScreen())
            }
        )
    }

    fun setBottomBarVisible(visible: Boolean){
        bottomBarVisibleManager.setBottomBarVisibility(false)
    }
}