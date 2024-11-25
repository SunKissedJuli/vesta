package com.example.vesta.screen.signUp

import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.text.KeyboardOptions
import androidx.compose.foundation.verticalScroll
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.runtime.collectAsState
import androidx.compose.runtime.getValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.shadow
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.input.KeyboardType
import androidx.compose.ui.text.style.TextDecoration
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import cafe.adriel.voyager.core.model.rememberScreenModel
import cafe.adriel.voyager.core.screen.Screen
import cafe.adriel.voyager.navigator.LocalNavigator
import cafe.adriel.voyager.navigator.currentOrThrow
import com.example.vesta.commons.MaskVisualTransformation
import com.example.vesta.components.CustomButton
import com.example.vesta.components.CustomScaffold
import com.example.vesta.components.CustomSplitClickableText
import com.example.vesta.components.HeaderWithButtonBack
import com.example.vesta.components.RoundedTextField
import com.example.vesta.images.VestaResourceImages
import com.example.vesta.screen.mainTab.MainTabScreen
import com.example.vesta.screen.profile.ProfileEvent
import com.example.vesta.screen.signIn.SignInScreen
import com.example.vesta.screen.tabs.HomeTab
import com.example.vesta.strings.VestaResourceStrings
import io.github.skeptick.libres.compose.painterResource

class SignUpScreen: Screen {
    @Composable
    override fun Content() {
        val viewModel = rememberScreenModel { SignUpViewModel() }
        val state by viewModel.stateFlow.collectAsState()
        val navigator = LocalNavigator.currentOrThrow

        LaunchedEffect(viewModel) {
            viewModel.container.sideEffectFlow.collect() {
                when (it) {
                    is SignUpEvent.UserEnteredValidData -> {
                        viewModel.setBottomBarVisible(true)
                        navigator.push(SignUpSecondScreen(viewModel))
                    }
                    else -> {}
                }
            }
        }

        CustomScaffold(
            topBar = {

                HeaderWithButtonBack(
                    onClick = { navigator.pop()},
                    text = VestaResourceStrings.registration
                )

            },
            bottomBar = {
                Box(
                    Modifier
                        .fillMaxWidth()
                        .padding(bottom = 80.dp, start = 20.dp, end = 20.dp)
                ){
                    Column(
                        verticalArrangement = Arrangement.Center,
                        horizontalAlignment = Alignment.CenterHorizontally
                    ){
                        CustomButton(
                            onClick = { viewModel.isFilled(
                                lastName = state.lastName,
                                firstName = state.firstName
                            ) },
                            text = VestaResourceStrings.further
                        )
                        Spacer(Modifier.height(20.dp))
                        CustomSplitClickableText(
                            text = VestaResourceStrings.wanna_enter,
                            onClick = {navigator.push(SignInScreen())}
                        )
                    }
                }
            }
        ) {
            Box(Modifier.fillMaxSize()){
                Column(
                    Modifier
                    .fillMaxSize()
                    .verticalScroll(rememberScrollState())
                    .background(MaterialTheme.colorScheme.background)
                    .padding(vertical = 20.dp, horizontal = 20.dp)) {

                    Text(
                        text = VestaResourceStrings.basic_information,
                        fontSize = 16.sp,
                        fontWeight = FontWeight.Bold,
                        lineHeight = 19.5.sp,
                        modifier = Modifier.padding(bottom = 20.dp)
                    )

                    RoundedTextField(
                        value = state.lastName,
                        onValueChange = {viewModel.updateLastName(it)},
                        placeholder = VestaResourceStrings.last_name,
                        errorMessage = state.errorLastName
                    )
                    Spacer(Modifier.height(20.dp))
                    RoundedTextField(
                        value = state.firstName,
                        onValueChange = {viewModel.updateFirstName(it)},
                        placeholder = VestaResourceStrings.first_name,
                        errorMessage = state.errorFirstName
                    )
                    Spacer(Modifier.height(20.dp))
                    RoundedTextField(
                        value = state.patronymic,
                        onValueChange = {viewModel.updatePatronymic(it)},
                        placeholder = VestaResourceStrings.patronymic,
                        errorMessage = state.errorPatronymic
                    )
                }
            }
        }
    }
}