package com.example.vesta.screen.signUp

import com.example.vesta.commons.Constantas.DEFAULT_BOOLEAN
import com.example.vesta.commons.Constantas.DEFAULT_STRING

data class SignUpState(
    val lastName: String,
    val firstName: String,
    val patronymic: String,
    val phone: String,
    val email: String,
    val password: String,
    val passwordRepeat: String,
    val agreePolitics: Boolean,
    val agreeNews: Boolean,
    val errorLastName: String,
    val errorFirstName: String,
    val errorPatronymic: String,
    val errorPhone: String,
    val errorEmail: String,
    val errorPassword: String,
    val errorPasswordRepeat: String,
    val errorAgreePolitics: Boolean
){
    companion object{
        val InitState = SignUpState(
            lastName = DEFAULT_STRING,
            firstName = DEFAULT_STRING,
            patronymic = DEFAULT_STRING,
            phone = DEFAULT_STRING,
            email = DEFAULT_STRING,
            password = DEFAULT_STRING,
            passwordRepeat = DEFAULT_STRING,
            agreePolitics = DEFAULT_BOOLEAN,
            agreeNews = DEFAULT_BOOLEAN,
            errorPassword = DEFAULT_STRING,
            errorEmail = DEFAULT_STRING,
            errorPhone = DEFAULT_STRING,
            errorLastName = DEFAULT_STRING,
            errorFirstName = DEFAULT_STRING,
            errorPasswordRepeat = DEFAULT_STRING,
            errorPatronymic = DEFAULT_STRING,
            errorAgreePolitics = false
        )
    }
}

