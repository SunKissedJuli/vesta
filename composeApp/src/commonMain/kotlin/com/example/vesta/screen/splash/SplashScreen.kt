package com.example.vesta.screen.splash

import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.runtime.ProvidableCompositionLocal
import cafe.adriel.voyager.core.model.rememberScreenModel
import cafe.adriel.voyager.core.screen.Screen
import cafe.adriel.voyager.navigator.LocalNavigator
import cafe.adriel.voyager.navigator.Navigator
import cafe.adriel.voyager.navigator.currentOrThrow
import cafe.adriel.voyager.navigator.tab.LocalTabNavigator
import cafe.adriel.voyager.navigator.tab.Tab
import cafe.adriel.voyager.navigator.tab.TabNavigator
import cafe.adriel.voyager.navigator.tab.TabNavigatorContent
import com.example.vesta.components.CustomCircularProgressIndicator
import com.example.vesta.screen.home.HomeScreen
import com.example.vesta.screen.mainTab.MainTabScreen
import com.example.vesta.screen.tabs.HomeTab
import com.example.vesta.screen.tabs.ProfileTab
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
                    is SplashEvent.UserAuthorize -> {
                        viewModel.updateBottomBarVisible(true)
                        if(!viewModel.isTabNavigator()){
                            viewModel.updateIsTabNavigator(true)
                            navigator.replaceAll(MainTabScreen())
                        }
                        else{
                            navigator.push(HomeScreen())
                        }
                    }
                    is SplashEvent.UserNotAuthorize ->{
                        navigator.push(WelcomeScreen())
                    }
                }
            }
        }
        CustomCircularProgressIndicator()
    }
}
