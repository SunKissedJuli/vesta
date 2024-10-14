package com.example.vesta.screen.profile

import com.example.vesta.platform.BaseScreenModel
import org.orbitmvi.orbit.syntax.simple.blockingIntent
import org.orbitmvi.orbit.syntax.simple.intent
import org.orbitmvi.orbit.syntax.simple.reduce
import vestatrade.composeapp.generated.resources.Res

internal class ProfileViewModel: BaseScreenModel<ProfileState, Unit>(ProfileState.InitState) {

    fun updatePassword(newPassword: String) = blockingIntent {
        reduce { state.copy(password = newPassword) }
    }

    fun updateEmail(newEmail: String) = blockingIntent {
        reduce { state.copy(email = newEmail) }
    }

    fun signIn(email: String, password: String) = intent {

    }
}