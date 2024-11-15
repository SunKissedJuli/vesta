package com.example.vesta.screen.signUp

sealed class SignUpEvent {

    object UserEnteredValidData: SignUpEvent()

    object UserRegistrationSucces: SignUpEvent()

}