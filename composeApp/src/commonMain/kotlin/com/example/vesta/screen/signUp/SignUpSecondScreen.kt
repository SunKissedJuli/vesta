package com.example.vesta.screen.signUp

import androidx.compose.foundation.background
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
import androidx.compose.material3.Checkbox
import androidx.compose.material3.CheckboxColors
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
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.input.KeyboardType
import androidx.compose.ui.text.style.TextAlign
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
import com.example.vesta.screen.signIn.SignInScreen
import com.example.vesta.screen.splash.SplashScreen
import com.example.vesta.strings.VestaResourceStrings
import io.github.skeptick.libres.compose.painterResource

internal class SignUpSecondScreen(private val viewModel: SignUpViewModel): Screen {

    @Composable
    override fun Content() {
        val state by viewModel.stateFlow.collectAsState()
        val navigator = LocalNavigator.currentOrThrow

        LaunchedEffect(viewModel) {
            viewModel.container.sideEffectFlow.collect() {
                when (it) {
                    is SignUpEvent.UserRegistrationSucces -> {
                        navigator.push(SplashScreen())
                    }
                    else -> {}
                }
            }
        }

        val checkBoxColors = CheckboxColors(
            checkedBoxColor = MaterialTheme.colorScheme.background,
            uncheckedBoxColor = MaterialTheme.colorScheme.background,
            checkedCheckmarkColor = MaterialTheme.colorScheme.secondaryContainer,
            uncheckedBorderColor = MaterialTheme.colorScheme.secondaryContainer,
            uncheckedCheckmarkColor = MaterialTheme.colorScheme.secondaryContainer,
            checkedBorderColor = MaterialTheme.colorScheme.secondaryContainer,
            disabledBorderColor = MaterialTheme.colorScheme.secondaryContainer,
            disabledIndeterminateBorderColor = MaterialTheme.colorScheme.secondaryContainer,
            disabledCheckedBoxColor = MaterialTheme.colorScheme.background,
            disabledUncheckedBoxColor = MaterialTheme.colorScheme.background,
            disabledUncheckedBorderColor = MaterialTheme.colorScheme.secondaryContainer,
            disabledIndeterminateBoxColor = MaterialTheme.colorScheme.secondaryContainer,
        )

        val checkBoxErrorColors = CheckboxColors(
            checkedBoxColor = MaterialTheme.colorScheme.background,
            uncheckedBoxColor = MaterialTheme.colorScheme.background,
            checkedCheckmarkColor = MaterialTheme.colorScheme.secondaryContainer,
            uncheckedBorderColor = MaterialTheme.colorScheme.onTertiary,
            uncheckedCheckmarkColor = MaterialTheme.colorScheme.onTertiary,
            checkedBorderColor = MaterialTheme.colorScheme.secondaryContainer,
            disabledBorderColor = MaterialTheme.colorScheme.secondaryContainer,
            disabledIndeterminateBorderColor = MaterialTheme.colorScheme.secondaryContainer,
            disabledCheckedBoxColor = MaterialTheme.colorScheme.background,
            disabledUncheckedBoxColor = MaterialTheme.colorScheme.background,
            disabledUncheckedBorderColor = MaterialTheme.colorScheme.secondaryContainer,
            disabledIndeterminateBoxColor = MaterialTheme.colorScheme.secondaryContainer,
        )

        CustomScaffold(
            topBar = {

                HeaderWithButtonBack(
                    onClick = { navigator.pop()},
                    text = VestaResourceStrings.registration
                )
            }
        ) {
            Box(Modifier.fillMaxSize()){
                Column(
                    Modifier
                        .fillMaxSize()
                        .background(MaterialTheme.colorScheme.background)
                        .padding(vertical = 20.dp, horizontal = 20.dp)) {

                    Text(
                        text = VestaResourceStrings.contact_information,
                        fontSize = 16.sp,
                        lineHeight = 19.5.sp,
                        fontWeight = FontWeight.Bold,
                        modifier = Modifier.padding(bottom = 20.dp)
                    )

                    RoundedTextField(
                        value = state.phone,
                        onValueChange = {viewModel.updatePhone(it)},
                        placeholder = VestaResourceStrings.phone,
                        errorMessage = state.errorPhone,
                        keyboardOptions = KeyboardOptions(keyboardType = KeyboardType.NumberPassword),
                        visualTransformation = MaskVisualTransformation("+7 (###) ###-##-##")
                    )

                    Text(
                        text = VestaResourceStrings.your_account,
                        fontSize = 16.sp,
                        fontWeight = FontWeight.Bold,
                        lineHeight = 19.5.sp,
                        modifier = Modifier.padding(top = 30.dp, bottom = 20.dp)
                    )

                    RoundedTextField(
                        value = state.email,
                        onValueChange = { viewModel.updateEmail(it) },
                        placeholder = VestaResourceStrings.email,
                        errorMessage = state.errorEmail
                    )
                    Spacer(Modifier.height(20.dp))
                    RoundedTextField(
                        value = state.password,
                        onValueChange = { viewModel.updatePassword(it) },
                        placeholder = VestaResourceStrings.password,
                        errorMessage = state.errorPassword
                    )
                    Spacer(Modifier.height(20.dp))
                    RoundedTextField(
                        value = state.passwordRepeat,
                        onValueChange = { viewModel.updatePasswordReopeat(it) },
                        placeholder = VestaResourceStrings.password_repeat,
                        errorMessage = state.errorPasswordRepeat
                    )

                    Column(
                        Modifier
                            .fillMaxWidth()
                            .padding(top = 20.dp, start = 20.dp)
                    ) {
                        Row(
                            Modifier.fillMaxWidth(),
                            verticalAlignment = Alignment.CenterVertically
                        ) {
                            Checkbox(
                                checked = state.agreePolitics,
                                onCheckedChange = {viewModel.updateAgreePolitics()},
                                colors = if(state.errorAgreePolitics) checkBoxErrorColors else checkBoxColors
                            )
                            CustomSplitClickableText(
                                text = VestaResourceStrings.i_agree,
                                onClick = {},
                                wordCount = 4,
                                textAlign = TextAlign.Start,
                                modifier = Modifier.padding(start = 15.dp)
                            )
                    }
                        Row(
                            Modifier.fillMaxWidth(),
                            verticalAlignment = Alignment.CenterVertically
                        ) {
                            Checkbox(
                                checked = state.agreeNews,
                                onCheckedChange = {viewModel.updateAgreeNews()},
                                colors = checkBoxColors
                            )
                            Text(
                                text = VestaResourceStrings.i_agree_news,
                                fontSize = 12.sp,
                                color = MaterialTheme.colorScheme.onSecondary,
                                textAlign = TextAlign.Start,
                                letterSpacing = 0.5.sp,
                                lineHeight = 14.63.sp,
                                modifier = Modifier.padding(start = 15.dp)
                            )
                        }
                    }
                }
                Box(
                    Modifier
                        .fillMaxWidth()
                        .padding(bottom = 80.dp, start = 20.dp, end = 20.dp)
                        .align(Alignment.BottomCenter)){
                    Column(
                        verticalArrangement = Arrangement.Center,
                        horizontalAlignment = Alignment.CenterHorizontally
                    ){
                        CustomButton(
                            onClick = {viewModel.isFilledSecondScreen(
                                firstName = state.firstName,
                                lastName = state.lastName,
                                middleName = state.patronymic,
                                email = state.email,
                                password = state.password,
                                passwordConfirmation = state.passwordRepeat,
                                agreeNews = state.agreeNews,
                                agreePolitics = state.agreePolitics,
                                phone = state.phone
                            )},
                            text = VestaResourceStrings.sign_up
                        )
                        Spacer(Modifier.height(25.dp))
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