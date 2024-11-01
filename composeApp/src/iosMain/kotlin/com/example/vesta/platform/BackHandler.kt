package com.example.vesta.platform

import androidx.compose.runtime.Composable
import cafe.adriel.voyager.navigator.Navigator

@Composable
actual fun BackHandlerPlatform(backHandler: (Navigator, Navigator, () -> Unit) -> Unit) {

}