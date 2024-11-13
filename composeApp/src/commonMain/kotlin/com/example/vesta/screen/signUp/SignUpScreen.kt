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
import androidx.compose.foundation.text.KeyboardOptions
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
import com.example.vesta.components.RoundedTextField
import com.example.vesta.images.VestaResourceImages
import com.example.vesta.screen.mainTab.MainTabScreen
import com.example.vesta.screen.profile.ProfileEvent
import com.example.vesta.screen.signIn.SignInScreen
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
                        navigator.push(SignUpSecondScreen(viewModel))
                    }
                }
            }
        }

        CustomScaffold(
            topBar = {
                Box(
                    modifier = Modifier
                        .fillMaxWidth().height(51.dp).background(Color.Transparent)
                        .shadow(
                            5.dp,
                            shape = MaterialTheme.shapes.medium,
                            ambientColor = Color(0x1FF00000),
                            clip = false,
                        )
                ) {
                    Row(
                        Modifier
                            .align(Alignment.TopCenter)
                            .fillMaxWidth()
                            .height(46.dp)
                            .background(MaterialTheme.colorScheme.background),
                        verticalAlignment = Alignment.CenterVertically
                    ) {
                        Spacer(modifier = Modifier.width(20.dp))
                        IconButton(
                            onClick = { navigator.pop() },
                        ) {
                            Icon(
                                painter = painterResource(VestaResourceImages.button_back),
                                contentDescription = "",
                                modifier = Modifier.size(24.dp)
                            )
                        }
                        Spacer(modifier = Modifier.weight(1f))
                        Text(
                            text = VestaResourceStrings.registration,
                            fontSize = 16.sp,
                            fontWeight = FontWeight.Medium,
                            lineHeight = 19.5.sp
                        )
                        Spacer(modifier = Modifier.weight(1.2f))
                        Spacer(modifier = Modifier.width(20.dp))
                    }
                }
            }
        ) {
            Box(Modifier.fillMaxSize()){
                Column(
                    Modifier
                    .fillMaxSize()
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

                    Text(
                        text = VestaResourceStrings.contact_information,
                        fontSize = 16.sp,
                        lineHeight = 19.5.sp,
                        fontWeight = FontWeight.Bold,
                        modifier = Modifier.padding(top =30.dp, bottom = 20.dp)
                    )

                    RoundedTextField(
                        value = state.phone,
                        onValueChange = {viewModel.updatePhone(it)},
                        placeholder = VestaResourceStrings.phone,
                        errorMessage = state.errorPhone,
                        keyboardOptions = KeyboardOptions(keyboardType = KeyboardType.NumberPassword),
                        visualTransformation = MaskVisualTransformation("+7 (###) ###-##-##")
                    )
                }

                Box(
                    Modifier
                    .fillMaxWidth()
                    .padding(bottom = 100.dp, start = 20.dp, end = 20.dp)
                    .align(Alignment.BottomCenter)){
                    Column(
                        verticalArrangement = Arrangement.Center,
                        horizontalAlignment = Alignment.CenterHorizontally
                    ){
                        CustomButton(
                            onClick = { viewModel.isFilled(
                                lastName = state.lastName,
                                firstName = state.firstName,
                                phone = state.phone
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
        }
    }
}