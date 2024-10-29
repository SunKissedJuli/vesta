package com.example.vesta.screen.profile

import com.example.vesta.commons.Constantas.DEFAULT_BOOLEAN
import com.example.vesta.commons.Constantas.DEFAULT_STRING
import com.example.vesta.domain.modelsUI.user.CurrentUserUi

data class ProfileState(
    val currentUser: CurrentUserUi,
    val oldPassword: String,
    val newPassword: String,
    val confirmPassword: String,
    val changePassword: Boolean

    ){
    companion object{
        val InitState = ProfileState(
            currentUser = CurrentUserUi.empty,
            oldPassword = DEFAULT_STRING,
            newPassword = DEFAULT_STRING,
            confirmPassword = DEFAULT_STRING,
            changePassword = DEFAULT_BOOLEAN
        )
    }
}
