package com.example.vesta.screen.signIn

import cafe.adriel.voyager.navigator.tab.TabNavigator
import com.example.vesta.commons.Constantas.DEFAULT_STRING

data class SignInState(
    val email: String,
    val password: String,
    val tabNavigator: TabNavigator?,
    val errorEmail: String,
    val errorPassword: String
){
    companion object{
        val InitState = SignInState(
            email = DEFAULT_STRING,
            password = DEFAULT_STRING,
            tabNavigator = null,
            errorPassword = DEFAULT_STRING,
            errorEmail = DEFAULT_STRING
        )
    }
}

