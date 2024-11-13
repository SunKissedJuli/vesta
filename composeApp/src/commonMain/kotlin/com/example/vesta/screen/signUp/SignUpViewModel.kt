package com.example.vesta.screen.signUp

import cafe.adriel.voyager.navigator.Navigator
import com.example.vesta.domain.manager.ObserverManager
import com.example.vesta.ext.isValidEmail
import com.example.vesta.platform.BaseScreenModel
import com.example.vesta.strings.VestaResourceStrings
import org.koin.core.component.inject
import org.orbitmvi.orbit.syntax.simple.blockingIntent
import org.orbitmvi.orbit.syntax.simple.intent
import org.orbitmvi.orbit.syntax.simple.postSideEffect
import org.orbitmvi.orbit.syntax.simple.reduce

internal class SignUpViewModel: BaseScreenModel<SignUpState, SignUpEvent>(SignUpState.InitState) {

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
        if(newPhone.length<=10&&newPhone.all { it.isDigit() }){
            reduce { state.copy(phone = newPhone, errorPhone = "") }
        }
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

    fun isFilled(
        lastName: String,
        firstName: String,
        phone: String
    ) = intent{

        if(lastName.isEmpty() ||firstName.isEmpty()||phone.isEmpty()){
            reduce { state.copy(
                errorFirstName =  if(firstName.isEmpty()) VestaResourceStrings.error_fill_all_fields else "",
                errorLastName =  if(lastName.isEmpty()) VestaResourceStrings.error_fill_all_fields else "",
                errorPhone = if(phone.isEmpty()) VestaResourceStrings.error_fill_all_fields else ""
            ) }
        }
        else if(state.phone.length!=10){
            reduce { state.copy(errorPhone = VestaResourceStrings.error_short_phone)}
        }
        else{
            postSideEffect(SignUpEvent.UserEnteredValidData)
        }
    }

    fun isFilledSecondScreen(
        email: String,
        password: String,
        passwordConfirmation: String
    ) = intent{
        if(email.isEmpty()||password.isEmpty()||passwordConfirmation.isEmpty()){
            reduce { state.copy(
                errorEmail = if(email.isEmpty()) VestaResourceStrings.error_fill_all_fields else "",
                errorPassword = if(password.isEmpty()) VestaResourceStrings.error_fill_all_fields else "",
                errorPasswordRepeat = if(passwordConfirmation.isEmpty()) VestaResourceStrings.error_fill_all_fields else "",
            )}
        }
        else if(password.length<6||password.length>24){
            reduce { state.copy(errorPassword = if(password.isEmpty()) VestaResourceStrings.error_password_length else "",)}
        }
        else if(password!=passwordConfirmation){
            reduce { state.copy(
                errorPassword = if(password.isEmpty()) VestaResourceStrings.error_passwords_not_same else "",
                errorPasswordRepeat = if(passwordConfirmation.isEmpty()) VestaResourceStrings.error_passwords_not_same else "",
            )}
        }
        else if(!email.isValidEmail()){
            reduce { state.copy(errorEmail = VestaResourceStrings.error_invalid_email)}
        }
        else{
            //ура, квест пройден!
            //жаль, что апи-запрос для регистрации ещё не завезли >:(
        }
    }
}