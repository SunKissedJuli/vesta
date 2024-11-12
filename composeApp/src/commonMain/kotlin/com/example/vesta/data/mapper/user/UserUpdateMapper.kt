package com.example.vesta.data.mapper.user

import com.example.vesta.data.models.user.TokenResponse
import com.example.vesta.data.models.user.UserUpdate
import com.example.vesta.domain.modelsUI.user.TokenUi
import com.example.vesta.domain.modelsUI.user.UserUpdateUi

fun UserUpdateUi.toUI(): UserUpdate {
    return UserUpdate(
        email = email,
        firstName = firstName,
        lastName = lastName,
        middleName = middleName,
        telephone = telephone,
        password = password,
        passwordConfirmation = passwordConfirmation,
        oldPassword = oldPassword
    )
}