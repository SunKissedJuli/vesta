package com.example.vesta.screen.comments

import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.runtime.collectAsState
import androidx.compose.runtime.getValue
import cafe.adriel.voyager.core.model.rememberScreenModel
import cafe.adriel.voyager.core.screen.Screen
import cafe.adriel.voyager.navigator.LocalNavigator
import cafe.adriel.voyager.navigator.currentOrThrow
import cafe.adriel.voyager.navigator.tab.LocalTabNavigator
import com.example.vesta.components.CustomCircularProgressIndicator
import com.example.vesta.components.CustomScaffold
import com.example.vesta.components.HeaderWithButtonBack
import com.example.vesta.strings.VestaResourceStrings

class CommentScreen(): Screen {
    @Composable
    override fun Content() {

        val viewModel = rememberScreenModel { CommentViewModel() }
        val state by viewModel.stateFlow.collectAsState()
        val navigator = LocalNavigator.currentOrThrow
        val tabNavigator = LocalTabNavigator.current

        LaunchedEffect(viewModel) {
            viewModel.loadData()
        }

        CustomScaffold(
            topBar = {
                HeaderWithButtonBack(
                    onClick = { navigator.pop() },
                    text = VestaResourceStrings.home
                )
            }
        ) {
            if (viewModel.status.collectAsState().value && CommentState.InitState == state) {
                CustomCircularProgressIndicator()
            } else {

            }
        }
    }
}
