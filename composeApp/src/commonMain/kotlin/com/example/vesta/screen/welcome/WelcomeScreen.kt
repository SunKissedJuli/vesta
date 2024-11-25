package com.example.vesta.screen.welcome

import androidx.compose.foundation.Image
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.text.ClickableText
import androidx.compose.foundation.verticalScroll
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.text.SpanStyle
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.buildAnnotatedString
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
import com.example.vesta.images.VestaResourceImages
import com.example.vesta.screen.mainTab.MainTabScreen
import com.example.vesta.screen.signIn.SignInScreen
import com.example.vesta.strings.VestaResourceStrings
import io.github.skeptick.libres.compose.painterResource

class WelcomeScreen : Screen {
    @Composable
    override fun Content() {
        val navigator = LocalNavigator.currentOrThrow
        val viewModel = rememberScreenModel { WelcomeViewModel() }

        Box(Modifier.fillMaxSize()){
            Image(
                painter = painterResource(VestaResourceImages.background_signin_top),
                contentDescription = "",
                modifier = Modifier.fillMaxWidth().align(Alignment.TopCenter),
                contentScale = ContentScale.FillWidth
            )

            Image(
                painter = painterResource(VestaResourceImages.background_signin_bottom),
                contentDescription = "",
                modifier = Modifier.fillMaxWidth().align(Alignment.BottomCenter),
                contentScale = ContentScale.FillWidth
            )
        }

        CustomScaffold(
            bottomBar = {
                Box(
                    Modifier
                        .fillMaxWidth()
                        .padding(start = 20.dp, end = 20.dp, bottom = 80.dp)
                ) {
                    Column(
                        verticalArrangement = Arrangement.Center,
                        horizontalAlignment = Alignment.CenterHorizontally
                    ) {
                        CustomButton(
                            onClick = { navigator.push(SignInScreen()) },
                            text = VestaResourceStrings.sign_in
                        )
                        Spacer(Modifier.height(25.dp))

                        Text(
                            text = VestaResourceStrings.miss,
                            color = MaterialTheme.colorScheme.primary,
                            style = TextStyle(textDecoration = TextDecoration.Underline),
                            letterSpacing = 0.5.sp,
                            lineHeight = 14.63.sp,
                            modifier = Modifier
                                .clickable {
                                    viewModel.setBottomBarVisible(true)
                                    navigator.replaceAll(MainTabScreen())
                                }
                        )
                    }
                }
            },
            containerColor = Color.Transparent,
            contentBackground = Color.Transparent
        ) {
            Box(
                Modifier
                    .fillMaxSize()
                    .verticalScroll(rememberScrollState())
            ) {
                Column(
                    Modifier
                        .fillMaxWidth()
                        .padding(horizontal = 20.dp)
                        .align(Alignment.Center),
                    verticalArrangement = Arrangement.Center,
                    horizontalAlignment = Alignment.CenterHorizontally
                ) {
                    Image(
                        painter = painterResource(VestaResourceImages.icon_logo),
                        contentDescription = "",
                        modifier = Modifier.size(150.dp)
                    )
                    Text(
                        text = VestaResourceStrings.app_name,
                        fontSize = 48.sp,
                        fontWeight = FontWeight.Bold,
                        lineHeight = 58.51.sp,
                        modifier = Modifier.padding(top = 30.dp)
                    )
                    Text(
                        text = VestaResourceStrings.app_name_trading,
                        fontSize = 20.sp,
                        fontWeight = FontWeight.Bold,
                        lineHeight = 24.38.sp
                    )

                    Text(
                        text = VestaResourceStrings.hello_text,
                        fontSize = 16.sp,
                        modifier = Modifier.padding(top = 50.dp),
                        textAlign = TextAlign.Center,
                        letterSpacing = 0.5.sp,
                        lineHeight = 19.5.sp
                    )

                }
            }
        }
    }
}