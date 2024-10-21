package com.example.vesta.screen.signIn

import com.example.vesta.commons.Constantas.DEFAULT_STRING
import com.example.vesta.data.models.info.SityUi
import com.example.vesta.screen.profile.ProfileState

data class SignInState(
    val email: String,
    val password: String,
){
    companion object{
        val InitState = SignInState(
            email = DEFAULT_STRING,
            password = DEFAULT_STRING
        )
    }
}

