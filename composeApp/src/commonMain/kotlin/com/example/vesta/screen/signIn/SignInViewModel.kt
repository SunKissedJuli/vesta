package com.example.vesta.screen.signIn

import com.example.vesta.data.models.info.SityUi
import com.example.vesta.domain.manager.AuthManager
import com.example.vesta.domain.repository.InfoRepository
import com.example.vesta.platform.BaseScreenModel
import org.koin.core.component.inject
import org.orbitmvi.orbit.syntax.simple.blockingIntent
import org.orbitmvi.orbit.syntax.simple.intent
import org.orbitmvi.orbit.syntax.simple.reduce

internal class SignInViewModel:BaseScreenModel<SignInState, Unit>(SignInState.InitState) {

    private val infoRepository: InfoRepository by inject()
    private val authManager: AuthManager by inject()

    fun updatePassword(newPassword: String) = blockingIntent {
        reduce { state.copy(password = newPassword) }
    }

    fun updateEmail(newEmail: String) = blockingIntent {
        reduce { state.copy(email = newEmail) }
    }
}