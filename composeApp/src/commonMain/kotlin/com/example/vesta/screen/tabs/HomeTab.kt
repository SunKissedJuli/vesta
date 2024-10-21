package com.example.vesta.screen.tabs

import androidx.compose.runtime.Composable
import cafe.adriel.voyager.navigator.Navigator
import cafe.adriel.voyager.navigator.tab.Tab
import cafe.adriel.voyager.navigator.tab.TabOptions
import com.example.vesta.commons.Constantas.DEFAULT_STRING
import com.example.vesta.images.VestaResourceImages
import com.example.vesta.screen.home.HomeScreen
import com.example.vesta.strings.VestaResourceStrings
import io.github.skeptick.libres.compose.painterResource

object HomeTab: Tab {

    @Composable
    override fun Content() {
        Navigator(HomeScreen())
    }

    override val options: TabOptions
        @Composable
        get() = TabOptions(
            index = 1u,
            title = VestaResourceStrings.home,
            icon = painterResource(VestaResourceImages.icon_home)
        )
}