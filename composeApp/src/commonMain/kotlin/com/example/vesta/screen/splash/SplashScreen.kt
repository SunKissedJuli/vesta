package com.example.vesta.screen.splash

import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import cafe.adriel.voyager.core.model.rememberScreenModel
import cafe.adriel.voyager.core.screen.Screen
import cafe.adriel.voyager.navigator.LocalNavigator
import cafe.adriel.voyager.navigator.currentOrThrow
import com.example.vesta.components.CustomCircularProgressIndicator
import com.example.vesta.screen.mainTab.MainTabScreen
import com.example.vesta.screen.welcome.WelcomeScreen

class SplashScreen : Screen {
    @Composable
    override fun Content() {
        val viewModel = rememberScreenModel { SplashViewModel() }
        val navigator = LocalNavigator.currentOrThrow
        LaunchedEffect(Unit){
            viewModel.isAutorize()
        }

        LaunchedEffect(viewModel) {
            viewModel.container.sideEffectFlow.collect() {
                when (it) {
                    is SplashEvent.UserAutorize -> {
                        viewModel.updateBottomBarVisible(true)
                        navigator.replaceAll(MainTabScreen())
                    }
                    is SplashEvent.UserNotAutorize ->{
                       // navigator.replaceAll(MainTabScreen())
                        navigator.push(WelcomeScreen())
                    }
                }
            }
        }
        CustomCircularProgressIndicator()
    }
}