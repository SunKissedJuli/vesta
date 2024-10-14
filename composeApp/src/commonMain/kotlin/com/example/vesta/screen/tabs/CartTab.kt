package com.example.vesta.screen.tabs

import androidx.compose.runtime.Composable
import cafe.adriel.voyager.navigator.Navigator
import cafe.adriel.voyager.navigator.tab.Tab
import cafe.adriel.voyager.navigator.tab.TabOptions
import com.example.vesta.commons.Constantas.DEFAULT_STRING
import com.example.vesta.images.VestaResourceImages
import io.github.skeptick.libres.compose.painterResource

object CartTab: Tab {

    @Composable
    override fun Content() {
    }

    override val options: TabOptions
        @Composable
        get() = TabOptions(
            index = 1u,
            title = DEFAULT_STRING,
            icon = painterResource(VestaResourceImages.icon_cart)
        )
}