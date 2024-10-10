package com.example.vesta.screen.root

import androidx.compose.runtime.Composable
import androidx.compose.runtime.CompositionLocalProvider
import cafe.adriel.voyager.navigator.CurrentScreen
import cafe.adriel.voyager.navigator.Navigator
import com.example.vesta.screen.category.CategoryScreen
import com.example.vesta.screen.mainTab.MainTabScreen
import com.example.vesta.theme.VestaTheme

@Composable
fun Root(){
    VestaTheme {
        Navigator(MainTabScreen()) {
            CompositionLocalProvider(RootNavigator provides it,) {
                CurrentScreen()
            }
        }
    }
}