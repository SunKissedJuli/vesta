package com.example.vesta.data.mapper.user

import com.example.vesta.data.models.user.NewUser
import com.example.vesta.data.models.user.TokenResponse
import com.example.vesta.data.models.user.UserUpdate
import com.example.vesta.domain.modelsUI.user.NewUserUi
import com.example.vesta.domain.modelsUI.user.TokenUi
import com.example.vesta.domain.modelsUI.user.UserUpdateUi

fun NewUser.toUI(): NewUserUi {
    return NewUserUi(
        email = email.orEmpty(),
        firstName = firstName.orEmpty(),
        lastName = lastName.orEmpty(),
        middleName = middleName.orEmpty(),
        telephone = telephone.orEmpty(),
        password = password.orEmpty(),
        passwordConfirmation = passwordConfirmation.orEmpty(),
        storeId = storeId?:0,
        newsletter = newsletter?:0
    )
}