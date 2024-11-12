package com.example.vesta.screen.signUp

import cafe.adriel.voyager.navigator.Navigator
import com.example.vesta.domain.manager.ObserverManager
import com.example.vesta.platform.BaseScreenModel
import com.example.vesta.strings.VestaResourceStrings
import org.koin.core.component.inject
import org.orbitmvi.orbit.syntax.simple.blockingIntent
import org.orbitmvi.orbit.syntax.simple.intent
import org.orbitmvi.orbit.syntax.simple.reduce

internal class SignUpViewModel: BaseScreenModel<SignUpState, Unit>(SignUpState.InitState) {

    private val bottomBarVisibleManager: ObserverManager by inject()
    fun updateLastName(newLastName: String) = blockingIntent {

        reduce { state.copy(lastName = newLastName, errorLastName = "") }
    }

    fun updateFirstName(newFirstName: String) = blockingIntent {
        reduce { state.copy(firstName = newFirstName, errorFirstName = "") }
    }

    fun updatePatronymic(newPatronymic: String) = blockingIntent {
        reduce { state.copy(patronymic = newPatronymic, errorPatronymic = "") }
    }

    fun updatePhone(newPhone: String) = blockingIntent {
        reduce { state.copy(phone = newPhone, errorPhone = "") }
    }

    fun updatePassword(newPassword: String) = blockingIntent {
        reduce { state.copy(password = newPassword) }
    }

    fun updatePasswordReopeat(newPassword: String) = blockingIntent {
        reduce { state.copy(passwordRepeat = newPassword) }
    }

    fun updateEmail(newEmail: String) = blockingIntent {
        reduce { state.copy(email = newEmail, errorEmail = "") }
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

    fun isFilled(navigator: Navigator, viewModel: SignUpViewModel) = intent{
        if(state.patronymic.isEmpty()||state.lastName.isEmpty()
            ||state.firstName.isEmpty()||state.phone.isEmpty()){
            reduce { state.copy(
                errorFirstName = state.firstName.ifEmpty { VestaResourceStrings.error_fill_all_fields },
                errorLastName = state.lastName.ifEmpty { VestaResourceStrings.error_fill_all_fields } ,
                errorPatronymic = state.patronymic.ifEmpty { VestaResourceStrings.error_fill_all_fields } ,
                errorPhone = state.phone.ifEmpty { VestaResourceStrings.error_fill_all_fields } ,) }
        }
        else if(state.phone.isEmpty()){

        }
        else{
            navigator.push(SignUpSecondScreen(viewModel))
            //стоит переписать на event
        }
    }

    fun isFilledSecondScreen(email: String) = intent{
        val emailRegex = "^[A-Za-z0-9+_.-]+@[A-Za-z0-9.-]+\\.[A-Za-z]{2,}$".toRegex()
        if(emailRegex.matches(email)){

        }
        else{

        }
    }
}