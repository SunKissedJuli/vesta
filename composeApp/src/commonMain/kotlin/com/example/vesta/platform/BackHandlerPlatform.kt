package com.example.vesta.platform

import androidx.compose.runtime.Composable
import cafe.adriel.voyager.navigator.Navigator
import cafe.adriel.voyager.navigator.tab.TabNavigator

@Composable
expect fun BackHandlerPlatform(backHandler: (Navigator, Navigator, () -> Unit) -> Unit)