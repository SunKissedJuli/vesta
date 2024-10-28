package com.example.vesta.screen.signUp

import com.example.vesta.domain.manager.ObserverManager
import com.example.vesta.platform.BaseScreenModel
import org.koin.core.component.inject
import org.orbitmvi.orbit.syntax.simple.blockingIntent
import org.orbitmvi.orbit.syntax.simple.reduce

internal class SignUpViewModel: BaseScreenModel<SignUpState, Unit>(SignUpState.InitState) {

    private val bottomBarVisibleManager: ObserverManager by inject()
    fun updateLastName(newLastName: String) = blockingIntent {
        reduce { state.copy(lastName = newLastName) }
    }

    fun updateFirstName(newFirstName: String) = blockingIntent {
        reduce { state.copy(firstName = newFirstName) }
    }

    fun updatePatronymic(newPatronymic: String) = blockingIntent {
        reduce { state.copy(patronymic = newPatronymic) }
    }

    fun updatePhone(newPhone: String) = blockingIntent {
        reduce { state.copy(phone = newPhone) }
    }

    fun updatePassword(newPassword: String) = blockingIntent {
        reduce { state.copy(password = newPassword) }
    }

    fun updatePasswordReopeat(newPassword: String) = blockingIntent {
        reduce { state.copy(passwordRepeat = newPassword) }
    }

    fun updateEmail(newEmail: String) = blockingIntent {
        reduce { state.copy(email = newEmail) }
    }

    fun updateAgreePolitics() = blockingIntent {
        reduce { state.copy(agreePolitics = !state.agreePolitics) }
    }

    fun updateAgreeNews() = blockingIntent {
        reduce { state.copy(agreeNews = !state.agreeNews) }
    }

    fun setBottomBarVisible(visible: Boolean){
        bottomBarVisibleManager.setBottomBarVisibility(false)
    }
}