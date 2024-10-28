package com.example.vesta.screen.tabs

import androidx.compose.runtime.Composable
import cafe.adriel.voyager.navigator.Navigator
import cafe.adriel.voyager.navigator.tab.Tab
import cafe.adriel.voyager.navigator.tab.TabOptions
import com.example.vesta.commons.Constantas.DEFAULT_STRING
import com.example.vesta.domain.manager.AuthManagerImpl
import com.example.vesta.images.VestaResourceImages
import com.example.vesta.screen.mainTab.MainTabScreen
import com.example.vesta.screen.profile.ProfileScreen
import com.example.vesta.screen.signIn.SignInScreen
import com.example.vesta.strings.VestaResourceStrings
import io.github.skeptick.libres.compose.painterResource

object ProfileTab: Tab {

    @Composable
    override fun Content() {
        val manager = AuthManagerImpl()
        if(manager.token.isNullOrEmpty()){
            Navigator(SignInScreen())
        }
        else{
            Navigator(ProfileScreen())
        }
    }

    override val options: TabOptions
        @Composable
        get() = TabOptions(
            index = 1u,
            title = VestaResourceStrings.profile,
            icon = painterResource(VestaResourceImages.icon_profile)
        )
}