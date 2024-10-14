package com.example.vesta.screen.profile

import com.example.vesta.commons.Constantas.DEFAULT_STRING

data class ProfileState(
    val email: String,
    val password: String
){
    companion object{
        val InitState = ProfileState(
            email = DEFAULT_STRING,
            password = DEFAULT_STRING
        )
    }
}
