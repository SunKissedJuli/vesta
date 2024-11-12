package com.example.vesta.domain.modelsUI.user

import kotlinx.serialization.SerialName
import kotlinx.serialization.Serializable

data class UserUpdateUi(
    val email: String?,
    val firstName: String?,
    val lastName: String?,
    val middleName: String?,
    val oldPassword: String?,
    val password: String?,
    val passwordConfirmation: String?,
    val telephone: String?
){
    companion object{
        val empty = UserUpdateUi(
            email = null,
            firstName = null,
            lastName = null,
            middleName = null,
            oldPassword = null,
            password = null,
            passwordConfirmation = null,
            telephone = null
        )
    }
}