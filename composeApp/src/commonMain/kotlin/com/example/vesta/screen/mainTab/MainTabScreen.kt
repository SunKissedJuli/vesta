package com.example.vesta.screen.mainTab

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.RowScope
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.size
import androidx.compose.material3.Icon
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.NavigationBar
import androidx.compose.material3.NavigationBarItem
import androidx.compose.material3.NavigationBarItemColors
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.runtime.collectAsState
import androidx.compose.runtime.getValue
import androidx.compose.runtime.key
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.shadow
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import cafe.adriel.voyager.core.lifecycle.LifecycleEffect
import cafe.adriel.voyager.core.screen.Screen
import cafe.adriel.voyager.navigator.tab.LocalTabNavigator
import cafe.adriel.voyager.navigator.tab.Tab
import cafe.adriel.voyager.navigator.tab.TabNavigator
import com.example.vesta.components.CustomScaffold
import com.example.vesta.domain.manager.ObserverManager
import com.example.vesta.screen.tabs.CartTab
import com.example.vesta.screen.tabs.CatalogTab
import com.example.vesta.screen.tabs.HomeTab
import com.example.vesta.screen.tabs.InfoTab
import com.example.vesta.screen.tabs.ProfileTab
import kotlinx.coroutines.launch
import org.koin.core.component.KoinComponent
import org.koin.core.component.inject

class MainTabScreen: Screen, KoinComponent {

    @Composable
    override fun Content() {

        val observerManager: ObserverManager by inject()
        val tabStack by observerManager.tabStack.collectAsState()
        var isBottomBarVisible by remember { mutableStateOf(false) }
        LaunchedEffect(Unit){
            launch {
                observerManager.observeBottomBarVisibility {
                    isBottomBarVisible = observerManager.isBottomBarVisible()
                }
            }
        }
        LifecycleEffect(
            onStarted = {
                observerManager.setIsTabNavigator(true)
            }
        )
        TabNavigator(HomeTab, disposeNestedNavigators = false){ tab ->
            val tabNavigator = LocalTabNavigator.current
            LaunchedEffect(tabStack) {
                tabStack.lastOrNull()?.let {
                    tabNavigator.current = it
                }
            }

            CustomScaffold(

                bottomBar = {
                    key(isBottomBarVisible){
                        if(observerManager.isBottomBarVisible()){
                            Box(
                                Modifier
                                    .fillMaxWidth()
                                    .height(82.dp)
                                    .background(Color.Transparent)
                                    .shadow(10.dp, shape = MaterialTheme.shapes.small,
                                        ambientColor = Color(0x1FF00000), clip = false)
                            ) {
                                NavigationBar(
                                    modifier = Modifier.height(72.dp).fillMaxWidth()
                                        .align(Alignment.BottomStart)
                                    ,
                                    containerColor = MaterialTheme.colorScheme.background,
                                    contentColor = MaterialTheme.colorScheme.onSecondary,
                                    tonalElevation = 5.dp
                                ) {
                                    TabNavItem(HomeTab)
                                    TabNavItem(CatalogTab)
                                    TabNavItem(CartTab)
                                    TabNavItem(ProfileTab)
                                    TabNavItem(InfoTab)
                                }
                            }
                        }
                    }
                }
            ){
                tab.current.Content()
            }
        }
    }
}

@Composable
private fun RowScope.TabNavItem(tab: Tab) {
    val tabNavigator = LocalTabNavigator.current
    NavigationBarItem(
        selected = tabNavigator.current == tab,
        label = { Text(text = tab.options.title, fontSize = 10.sp, lineHeight = 12.19.sp) },
        colors = NavigationBarItemColors(
            selectedIconColor = MaterialTheme.colorScheme.primary,
            selectedTextColor = MaterialTheme.colorScheme.primary,
            selectedIndicatorColor = Color.Transparent,
            unselectedIconColor = MaterialTheme.colorScheme.onSecondary,
            unselectedTextColor = MaterialTheme.colorScheme.onSecondary,
            disabledTextColor = MaterialTheme.colorScheme.onSecondary,
            disabledIconColor = MaterialTheme.colorScheme.onSecondary),
        onClick = {
            tabNavigator.current = tab
        },
        icon = {
            tab.options.icon?.let { painter ->
                Icon(painter, contentDescription = null,
                    modifier = Modifier.size(20.dp))
            }
        }
    )
}