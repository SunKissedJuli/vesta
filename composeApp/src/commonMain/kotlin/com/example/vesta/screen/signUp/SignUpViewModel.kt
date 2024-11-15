package com.example.vesta.screen.signUp

import cafe.adriel.voyager.navigator.Navigator
import com.example.vesta.data.models.user.NewUser
import com.example.vesta.domain.manager.AuthManager
import com.example.vesta.domain.manager.ObserverManager
import com.example.vesta.domain.repository.UserRepository
import com.example.vesta.ext.formatPhone
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
    private val userRepository: UserRepository by inject()
    private val authManager: AuthManager by inject()

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
        reduce { state.copy(
            errorLastName = "",
            errorFirstName = "",
            errorPhone = "",
        )}
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
        lastName: String,
        firstName: String,
        middleName: String,
        phone: String,
        email: String,
        password: String,
        passwordConfirmation: String,
        agreePolitics: Boolean,
        agreeNews: Boolean,
    ) = intent{
        reduce { state.copy(
            errorEmail = "",
            errorPassword = "",
            errorPasswordRepeat = "",
            errorAgreePolitics = false
        )}

        if(email.isEmpty()||password.isEmpty()||passwordConfirmation.isEmpty()){
            println("ошибка email.isEmpty()||password.isEmpty()||passwordConfirmation.isEmpty()")
            reduce { state.copy(
                errorEmail = if(email.isEmpty()) VestaResourceStrings.error_fill_all_fields else "",
                errorPassword = if(password.isEmpty()) VestaResourceStrings.error_fill_all_fields else "",
                errorPasswordRepeat = if(passwordConfirmation.isEmpty()) VestaResourceStrings.error_fill_all_fields else "",
            )}
        }
        else if(password.length<6||password.length>24){
            println("ошибка password.length<6||password.length>24")

            reduce { state.copy(errorPassword = VestaResourceStrings.error_password_length )}
        }
        else if(password!=passwordConfirmation){
            println("ошибка password!=passwordConfirmation")
            reduce { state.copy(
                errorPassword = VestaResourceStrings.error_passwords_not_same,
                errorPasswordRepeat = VestaResourceStrings.error_passwords_not_same,
            )}
        }
        else if(!email.isValidEmail()){
            println("ошибка !email.isValidEmail()")
            reduce { state.copy(errorEmail = VestaResourceStrings.error_invalid_email)}
        }
        else if(!agreePolitics){
            println("ошибка !agreePolitics")
            reduce { state.copy(errorAgreePolitics = true)}
        }
        else{
            registration(
                NewUser(
                    email = email,
                    password = password,
                    passwordConfirmation = passwordConfirmation,
                    firstName = firstName,
                    lastName = lastName,
                    middleName = middleName,
                    telephone = phone.formatPhone(),
                    storeId = authManager.sity,
                    newsletter = if(agreeNews) 1 else 0,
            ))
        }
    }

    private fun registration(newUser: NewUser) = intent {
        launchOperation(
            operation = {
                userRepository.registration(newUser)
            },
            success = {
                postSideEffectLocal(SignUpEvent.UserRegistrationSucces)
            },
            failure = { failure ->
                when(failure.message){
                    VestaResourceStrings.error_phone_is_unique_long -> {
                        reduceLocal { state.copy(errorEmail = VestaResourceStrings.error_phone_is_unique) }
                    }
                    VestaResourceStrings.error_email_is_unique -> {
                        reduceLocal { state.copy(errorEmail = VestaResourceStrings.error_email_is_unique) }
                    }
                }
            }
        )
    }
}