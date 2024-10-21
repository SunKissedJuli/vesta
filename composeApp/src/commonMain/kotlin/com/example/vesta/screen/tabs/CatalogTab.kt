package com.example.vesta.screen.tabs

import androidx.compose.runtime.Composable
import cafe.adriel.voyager.navigator.Navigator
import cafe.adriel.voyager.navigator.tab.Tab
import cafe.adriel.voyager.navigator.tab.TabOptions
import com.example.vesta.images.VestaResourceImages
import com.example.vesta.screen.category.CategoryScreen
import com.example.vesta.strings.VestaResourceStrings
import io.github.skeptick.libres.compose.painterResource

object CatalogTab: Tab {

    @Composable
    override fun Content() {
        Navigator(CategoryScreen())
    }

    override val options: TabOptions
        @Composable
        get() = TabOptions(
            index = 1u,
            title = VestaResourceStrings.catalog,
            icon = painterResource(VestaResourceImages.icon_burger)
        )
}