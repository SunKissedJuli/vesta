package com.example.vesta.screen.profile

import com.example.vesta.data.mapper.user.toUI
import com.example.vesta.data.models.user.UserUpdate
import com.example.vesta.domain.manager.AuthManager
import com.example.vesta.domain.manager.ObserverManager
import com.example.vesta.domain.modelsUI.user.UserUpdateUi
import com.example.vesta.domain.repository.UserRepository
import com.example.vesta.platform.BaseScreenModel
import com.example.vesta.screen.splash.SplashEvent
import com.example.vesta.strings.VestaResourceStrings
import org.koin.core.component.inject
import org.orbitmvi.orbit.annotation.OrbitExperimental
import org.orbitmvi.orbit.syntax.simple.blockingIntent
import org.orbitmvi.orbit.syntax.simple.intent
import org.orbitmvi.orbit.syntax.simple.reduce
import vestatrade.composeapp.generated.resources.Res

internal class ProfileViewModel: BaseScreenModel<ProfileState, ProfileEvent>(ProfileState.InitState) {

    private val userRepository: UserRepository by inject()
    private val authManager: AuthManager by inject()
    private val bottomBarVisibleManager: ObserverManager by inject()

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

    fun updatePhone(phone: String) = blockingIntent {
        reduce {
            state.copy(
                newUserData =  state.newUserData.copy(telephone = phone),
                currentUser = state.currentUser.copy(telephone = phone),
                phoneError = if(phone.isEmpty()) VestaResourceStrings.error_fill_all_fields else "" )
        }
    }

    fun updateEmail(email: String) = blockingIntent {
        reduce {
            state.copy(
                newUserData =  state.newUserData.copy(email = email),
                currentUser = state.currentUser.copy(email = email),
                emailError = if(email.isEmpty()) VestaResourceStrings.error_fill_all_fields else "" )
        }
    }

    fun updateFirstName(name: String) = blockingIntent {
        reduce {
            state.copy(
                newUserData =  state.newUserData.copy(firstName = name),
                currentUser = state.currentUser.copy(firstName = name),
                firstNameError = if(name.isEmpty()) VestaResourceStrings.error_fill_all_fields else "" )
        }
    }

    fun updateMiddleName(name: String) = blockingIntent {
        reduce {
            state.copy(
                newUserData =  state.newUserData.copy(middleName = name),
                currentUser = state.currentUser.copy(middleName = name),
                middleNameError = if(name.isEmpty()) VestaResourceStrings.error_fill_all_fields else "" )
        }
    }

    fun updateLastName(name: String) = blockingIntent {
        reduce {
            state.copy(
                newUserData =  state.newUserData.copy(lastName = name),
                currentUser = state.currentUser.copy(lastName = name),
                lastNameError = if(name.isEmpty()) VestaResourceStrings.error_fill_all_fields else "" )
        }
    }

    fun updateOldPassword(password: String) = blockingIntent {
        reduce { state.copy(
            newUserData =  state.newUserData.copy(oldPassword = password),
            oldPasswordError = if(password.isEmpty()) VestaResourceStrings.error_fill_all_fields else ""
        ) }
    }

    fun updateChangePassword(change: Boolean) = blockingIntent {
        //сброс несохранённого пароля при закрытии диалога "изменить пароль"
        if(!change){
            reduce { state.copy(
                changePassword = change,
                newUserData =  state.newUserData.copy(
                    password = "",
                    oldPassword = "",
                    passwordConfirmation = ""),
                newPasswordError = "",
                oldPasswordError = "",
                confirmPasswordError = ""
            ) }
        }
        else{
            reduce { state.copy(changePassword = change) }
        }
    }

    fun updateNewPassword(password: String) = blockingIntent {
        reduce { state.copy(
            newUserData =  state.newUserData.copy(password = password),
            newPasswordError = if(password.isEmpty()) VestaResourceStrings.error_fill_all_fields else ""
        ) }
    }

    fun updateConfirmPassword(password: String) = blockingIntent {
        reduce { state.copy(
            newUserData =  state.newUserData.copy(passwordConfirmation = password),
            confirmPasswordError = if(password.isEmpty()) VestaResourceStrings.error_fill_all_fields else ""
        ) }
    }

    @OptIn(OrbitExperimental::class)
    fun saveData(userData: UserUpdateUi) = blockingIntent {
        if(userData!=UserUpdateUi.empty){
            launchOperation(
                operation = {
                    userRepository.editUser(userData.toUI())
                }
            )
        }
        reduce { state.copy(
            newUserData = UserUpdateUi.empty,
            emailError = "",
            phoneError = "",
            lastNameError = "",
            firstNameError = "",
            middleNameError = "") }
    }

    fun savePassword(
        oldPassword: String?,
        newPassword: String?,
        confirmPassword: String?
    ) = intent {
        // Сброс ошибок
        reduce { state.copy(
                oldPasswordError = "",
                newPasswordError = "",
                confirmPasswordError = "") }

        if (oldPassword.isNullOrEmpty() || newPassword.isNullOrEmpty() || confirmPassword.isNullOrEmpty()) {
            reduce { state.copy(
                    oldPasswordError = if (oldPassword.isNullOrEmpty()) VestaResourceStrings.error_fill_all_fields else "",
                    newPasswordError = if (newPassword.isNullOrEmpty()) VestaResourceStrings.error_fill_all_fields else "",
                    confirmPasswordError = if (confirmPassword.isNullOrEmpty()) VestaResourceStrings.error_fill_all_fields else "") }
        } else if (newPassword != confirmPassword) {
            reduce { state.copy(
                    newPasswordError = VestaResourceStrings.error_passwords_not_same,
                    confirmPasswordError = VestaResourceStrings.error_passwords_not_same) }
        }
        else if (newPassword == oldPassword) {
            reduce { state.copy(newPasswordError = VestaResourceStrings.error_new_password_must_be_different,) }
        }
        else if(newPassword.length<6||newPassword.length>24){
            reduce { state.copy(newPasswordError = VestaResourceStrings.error_password_length) }

        }
        else{
            val newUserPassword = UserUpdateUi.empty.copy(
                password = newPassword,
                passwordConfirmation = confirmPassword,
                oldPassword = oldPassword)

            launchOperation(
                operation = { userRepository.editUser(newUserPassword.toUI()) },
                success = { updateChangePassword(false) },
                failure = { failure ->
                    if(failure.message=="Wrong password"){
                        reduceLocal { state.copy(oldPasswordError = VestaResourceStrings.error_invalid_old_password) }
                    }
                }
            )
        }
    }

    fun setBottomBarVisible(visible: Boolean){
        bottomBarVisibleManager.setBottomBarVisibility(visible)
    }
}