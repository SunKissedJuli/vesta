package com.example.vesta.screen.profile

import com.example.vesta.domain.manager.AuthManager
import com.example.vesta.domain.repository.UserRepository
import com.example.vesta.platform.BaseScreenModel
import com.example.vesta.screen.splash.SplashEvent
import org.koin.core.component.inject
import org.orbitmvi.orbit.syntax.simple.blockingIntent
import org.orbitmvi.orbit.syntax.simple.intent
import org.orbitmvi.orbit.syntax.simple.reduce
import vestatrade.composeapp.generated.resources.Res

internal class ProfileViewModel: BaseScreenModel<ProfileState, ProfileEvent>(ProfileState.InitState) {

    val userRepository: UserRepository by inject()
    val authManager: AuthManager by inject()

    fun loadData() = intent {
        launchOperation(
            operation = {
                userRepository.getCurrentUser()
            },
            success = { response ->
                reduceLocal {
                    state.copy(
                        currentUser = response
                    )
                }
            }
        )
    }

    fun logOut() = intent {
        launchOperation(
            operation = {
                userRepository.logOut()
            },
            success = {
                authManager.token = ""
                postSideEffectLocal(ProfileEvent.UserLogOut)
            }
        )
    }

    fun updateChangePassword(change: Boolean) = blockingIntent {
        reduce { state.copy(changePassword = change) }
    }

    fun updateOldPassword(password: String) = blockingIntent {
        reduce { state.copy(oldPassword = password) }
    }

    fun updateNewPassword(password: String) = blockingIntent {
        reduce { state.copy(newPassword = password) }
    }
    fun updateConfirmPassword(password: String) = blockingIntent {
        reduce { state.copy(confirmPassword = password) }
    }
}