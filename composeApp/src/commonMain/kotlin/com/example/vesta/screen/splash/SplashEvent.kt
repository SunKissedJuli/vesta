package com.example.vesta.screen.splash

sealed class SplashEvent {

    object UserAuthorize: SplashEvent()

    object UserNotAuthorize: SplashEvent()

}