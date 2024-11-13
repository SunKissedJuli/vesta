package com.example.vesta.screen.profile

import com.example.vesta.commons.Constantas.DEFAULT_BOOLEAN
import com.example.vesta.commons.Constantas.DEFAULT_STRING
import com.example.vesta.data.models.user.UserUpdate
import com.example.vesta.domain.modelsUI.user.CurrentUserUi
import com.example.vesta.domain.modelsUI.user.UserUpdateUi

data class ProfileState(
    val currentUser: CurrentUserUi,
    val changePassword: Boolean,
    val newUserData: UserUpdateUi,
    val oldPasswordError: String,
    val newPasswordError: String,
    val confirmPasswordError: String,
    val emailError: String,
    val phoneError: String,
    val firstNameError: String,
    val middleNameError: String,
    val lastNameError: String
){
    companion object{
        val InitState = ProfileState(
            currentUser = CurrentUserUi.empty,
            changePassword = DEFAULT_BOOLEAN,
            newUserData = UserUpdateUi.empty,
            oldPasswordError = DEFAULT_STRING,
            newPasswordError = DEFAULT_STRING,
            confirmPasswordError = DEFAULT_STRING,
            emailError = DEFAULT_STRING,
            phoneError = DEFAULT_STRING,
            firstNameError = DEFAULT_STRING,
            lastNameError = DEFAULT_STRING,
            middleNameError = DEFAULT_STRING
        )
    }
}
