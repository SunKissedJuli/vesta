package com.example.vesta.screen.signIn

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
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.material3.TopAppBar
import androidx.compose.runtime.Composable
import androidx.compose.runtime.collectAsState
import androidx.compose.runtime.getValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.shadow
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.text.style.TextDecoration
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import cafe.adriel.voyager.core.model.rememberScreenModel
import cafe.adriel.voyager.core.screen.Screen
import cafe.adriel.voyager.navigator.LocalNavigator
import cafe.adriel.voyager.navigator.currentOrThrow
import com.example.vesta.components.CustomButton
import com.example.vesta.components.CustomScaffold
import com.example.vesta.components.CustomSplitClickableText
import com.example.vesta.components.RoundedTextField
import com.example.vesta.images.VestaResourceImages
import com.example.vesta.screen.mainTab.MainTabScreen
import com.example.vesta.screen.profile.ProfileScreen
import com.example.vesta.screen.signUp.SignUpScreen
import com.example.vesta.strings.VestaResourceStrings
import io.github.skeptick.libres.compose.painterResource

class SignInScreen: Screen {
    @Composable
    override fun Content() {
        val viewModel = rememberScreenModel { SignInViewModel() }
        val state by viewModel.stateFlow.collectAsState()
        val navigator = LocalNavigator.currentOrThrow

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
                            text = VestaResourceStrings.authorize,
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
                Column(Modifier
                    .fillMaxSize()
                    .background(MaterialTheme.colorScheme.background)
                    .padding(vertical = 40.dp, horizontal = 20.dp)) {

                    RoundedTextField(
                        value = state.email,
                        onValueChange = {viewModel.updateEmail(it)},
                        placeholder = VestaResourceStrings.email
                    )
                    Spacer(Modifier.height(25.dp))
                    RoundedTextField(
                        value = state.password,
                        onValueChange = {viewModel.updatePassword(it)},
                        placeholder = VestaResourceStrings.password
                    )
                    Text(
                        text = VestaResourceStrings.forgot_password,
                        color =  MaterialTheme.colorScheme.primary,
                        style = TextStyle(textDecoration = TextDecoration.Underline),
                        letterSpacing = 0.5.sp,
                        lineHeight = 14.63.sp,
                        modifier = Modifier.padding(start = 20.dp, top = 15.dp).clickable{navigator.replaceAll(MainTabScreen())}
                    )
                }

                Box(Modifier
                    .fillMaxWidth()
                    .padding(bottom = 100.dp, start = 20.dp, end = 20.dp)
                    .align(Alignment.BottomCenter)){
                    Column(
                        verticalArrangement = Arrangement.Center,
                        horizontalAlignment = Alignment.CenterHorizontally
                    ){
                        CustomButton(
                            onClick = {navigator.push(ProfileScreen())},
                            text = VestaResourceStrings.sign_in
                        )
                        Spacer(Modifier.height(25.dp))
                        CustomSplitClickableText(
                            text = VestaResourceStrings.wanna_registration,
                            onClick = {navigator.push(SignUpScreen())}
                        )
                    }
                }
            }
        }
    }
}