package com.example.vesta.screen.splash

sealed class SplashEvent {

    object UserAutorize: SplashEvent()

    object UserNotAutorize: SplashEvent()

}