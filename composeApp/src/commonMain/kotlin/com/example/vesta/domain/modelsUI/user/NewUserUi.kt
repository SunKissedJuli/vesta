package com.example.vesta.domain.modelsUI.user

import kotlinx.serialization.SerialName
import kotlinx.serialization.Serializable

data class NewUserUi(
    val email: String,
    val firstName: String,
    val lastName: String,
    val middleName: String,
    val password: String,
    val passwordConfirmation: String,
    val telephone: String,
    val storeId: Int,
    val newsletter: Int
){
    companion object{
        val empty = NewUserUi(
            email = "",
            firstName = "",
            lastName = "",
            middleName = "",
            password = "",
            passwordConfirmation = "",
            telephone = "",
            storeId = 0,
            newsletter = 0
        )
    }
}