package com.example.vesta.screen.newsDetails

import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.runtime.collectAsState
import androidx.compose.runtime.getValue
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import cafe.adriel.voyager.core.model.rememberScreenModel
import cafe.adriel.voyager.core.screen.Screen
import cafe.adriel.voyager.navigator.LocalNavigator
import cafe.adriel.voyager.navigator.currentOrThrow
import cafe.adriel.voyager.navigator.tab.LocalTabNavigator
import com.example.vesta.components.CustomAsyncImage
import com.example.vesta.components.CustomCircularProgressIndicator
import com.example.vesta.components.CustomScaffold
import com.example.vesta.components.HeaderOneWord
import com.example.vesta.strings.VestaResourceStrings


class NewsDetailsScreen(private val id: String): Screen {
    @OptIn(ExperimentalMaterial3Api::class)
    @Composable
    override fun Content() {

        val viewModel = rememberScreenModel { NewsDetailsViewModel() }
        val state by viewModel.stateFlow.collectAsState()
        val navigator = LocalNavigator.currentOrThrow
        val tabNavigator = LocalTabNavigator.current

        LaunchedEffect(viewModel) {
            viewModel.loadData(id)
        }

        CustomScaffold(
            topBar = {
                HeaderOneWord(VestaResourceStrings.home)
            }
        ) {
            if (viewModel.status.collectAsState().value && NewsDetailsState.InitState == state) {
                CustomCircularProgressIndicator()
            } else {

                Column(
                    Modifier
                        .fillMaxSize()
                        .padding(horizontal = 20.dp, vertical = 10.dp)) {

                    Text(
                        text = ""
                    )

                    CustomAsyncImage(
                        ""
                    )

                }
            }
        }
    }
}
