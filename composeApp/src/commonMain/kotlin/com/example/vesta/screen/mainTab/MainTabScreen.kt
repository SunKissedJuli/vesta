package com.example.vesta.screen.mainTab

import androidx.compose.foundation.layout.RowScope
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.width
import androidx.compose.material3.Icon
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.NavigationBar
import androidx.compose.material3.NavigationBarItem
import androidx.compose.material3.NavigationBarItemColors
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import cafe.adriel.voyager.core.model.rememberScreenModel
import cafe.adriel.voyager.core.screen.Screen
import cafe.adriel.voyager.navigator.tab.LocalTabNavigator
import cafe.adriel.voyager.navigator.tab.Tab
import cafe.adriel.voyager.navigator.tab.TabNavigator
import com.example.vesta.components.CustomScaffold
import com.example.vesta.components.VerticalLine
import com.example.vesta.platform.OpenPhone
import com.example.vesta.screen.Info.InfoDialog
import com.example.vesta.screen.profile.ProfileScreen
import com.example.vesta.screen.profile.ProfileViewModel
import com.example.vesta.screen.sity.SityScreen
import com.example.vesta.screen.sity.SityViewModel
import com.example.vesta.screen.tabs.CartTab
import com.example.vesta.screen.tabs.CategoryTab
import com.example.vesta.screen.tabs.GeolocationTab
import com.example.vesta.screen.tabs.InfoTab
import com.example.vesta.screen.tabs.PhoneTab
import com.example.vesta.screen.tabs.ProfileTab

class MainTabScreen(): Screen {

    @Composable
    override fun Content() {
        TabNavigator(CategoryTab, disposeNestedNavigators = false){ tab ->
            CustomScaffold(
                bottomBar = {
                    NavigationBar(
                        modifier = Modifier.height(70.dp),
                        containerColor = MaterialTheme.colorScheme.primary,
                        contentColor = MaterialTheme.colorScheme.background
                    ) {
                        TabNavItem(CategoryTab)
                        VerticalLine()
                        TabNavItem(InfoTab)
                        VerticalLine()
                        TabNavItem(ProfileTab)
                        VerticalLine()
                        TabNavItem(PhoneTab)
                        VerticalLine()
                        TabNavItem(GeolocationTab)
                        VerticalLine()
                        TabNavItem(CartTab)
                    }
                }
            ){
                CategoryTab.Content()
                if(tab.current == InfoTab){
                    InfoDialog { tab.current = CategoryTab }
                }
                else if(tab.current==ProfileTab){
                    val viewModel = rememberScreenModel { ProfileViewModel() }
                    ProfileScreen(viewModel) { tab.current = CategoryTab }
                }
                else if(tab.current == PhoneTab){
                    OpenPhone()
                }
                else if(tab.current == GeolocationTab){
                    val viewModel = rememberScreenModel { SityViewModel() }
                    SityScreen(viewModel) { tab.current = CategoryTab }
                }
            }
        }
    }
}

@Composable
private fun RowScope.TabNavItem(tab: Tab) {
    val tabNavigator = LocalTabNavigator.current
    NavigationBarItem(
        selected = tabNavigator.current == tab,
        colors = NavigationBarItemColors(
            selectedIconColor = MaterialTheme.colorScheme.background,
            selectedTextColor = MaterialTheme.colorScheme.background,
            selectedIndicatorColor = Color.Transparent,
            unselectedIconColor = MaterialTheme.colorScheme.background,
            unselectedTextColor = MaterialTheme.colorScheme.background,
            disabledTextColor = MaterialTheme.colorScheme.background,
            disabledIconColor = MaterialTheme.colorScheme.background),
        onClick = {
            tabNavigator.current = tab
        },
        icon = {
            tab.options.icon?.let { painter ->
                Icon(painter, contentDescription = null,
                    modifier = Modifier.size(30.dp))
            }
        }
    )
}