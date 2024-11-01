package com.example.vesta.screen.profile

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
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.foundation.verticalScroll
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Email
import androidx.compose.material.icons.outlined.Email
import androidx.compose.material3.BasicAlertDialog
import androidx.compose.material3.Card
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Icon
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.runtime.collectAsState
import androidx.compose.runtime.getValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.draw.shadow
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.compose.ui.window.Dialog
import cafe.adriel.voyager.core.model.rememberScreenModel
import cafe.adriel.voyager.core.screen.Screen
import cafe.adriel.voyager.navigator.LocalNavigator
import cafe.adriel.voyager.navigator.currentOrThrow
import com.example.vesta.components.CustomButton
import com.example.vesta.components.CustomCircularProgressIndicator
import com.example.vesta.components.CustomScaffold
import com.example.vesta.components.RoundedTextField
import com.example.vesta.images.VestaResourceImages
import com.example.vesta.screen.signIn.SignInScreen
import com.example.vesta.strings.VestaResourceStrings
import io.github.skeptick.libres.compose.painterResource


class ProfileScreen(): Screen{
    @Composable
    override fun Content() {
        val viewModel = rememberScreenModel { ProfileViewModel() }
        val state by viewModel.stateFlow.collectAsState()
        val navigator = LocalNavigator.currentOrThrow
        LaunchedEffect(viewModel){
            viewModel.loadData()
        }

        LaunchedEffect(viewModel) {
            viewModel.container.sideEffectFlow.collect() {
                when (it) {
                    is ProfileEvent.UserLogOut -> {
                        navigator.push(SignInScreen())
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
                        verticalAlignment = Alignment.CenterVertically,
                        horizontalArrangement = Arrangement.Center
                    ) {

                        Text(
                            text = VestaResourceStrings.profile,
                            fontSize = 16.sp,
                            fontWeight = FontWeight.Medium,
                            lineHeight = 19.5.sp
                        )
                    }
                }
            }
        ) {
            if (viewModel.status.collectAsState().value && ProfileState.InitState == state) {
                CustomCircularProgressIndicator()
            } else {
                Box(
                    Modifier
                        .fillMaxSize()
                        .background(MaterialTheme.colorScheme.background)
                ) {

                    if(state.changePassword){
                        ChangePassword(
                            uiState = state,
                            onUpdateNewPassword = {viewModel.updateNewPassword(it)},
                            onUpdateOldPassword = {viewModel.updateOldPassword(it)},
                            onUpdateConfirmPassword = {viewModel.updateConfirmPassword(it)},
                            onSave = {},
                            onDismissRequest = {viewModel.updateChangePassword(false)}
                        )
                    }

                    Column(Modifier.fillMaxSize().padding(20.dp).verticalScroll(rememberScrollState())) {
                        RoundedTextField(
                            value = state.currentUser.firstName,
                            onValueChange = {},
                            placeholder = VestaResourceStrings.first_name
                        )
                        Spacer(Modifier.height(25.dp))

                        RoundedTextField(
                            value = state.currentUser.lastName,
                            onValueChange = {},
                            placeholder = VestaResourceStrings.last_name
                        )
                        Spacer(Modifier.height(25.dp))

                        RoundedTextField(
                            value = state.currentUser.middleName,
                            onValueChange = {},
                            placeholder = VestaResourceStrings.patronymic
                        )
                        Spacer(Modifier.height(25.dp))
                        CustomButton(
                            onClick = {},
                            text = VestaResourceStrings.save
                        )

                        Column(Modifier.padding(horizontal = 10.dp, vertical = 30.dp)){
                            Text(
                            text = VestaResourceStrings.contact_information,
                            fontSize = 16.sp,
                            lineHeight = 19.5.sp,
                            fontWeight = FontWeight.Bold,
                        )
                            Row(
                                Modifier
                                    .fillMaxWidth()
                                    .padding(top = 25.dp),
                                verticalAlignment = Alignment.CenterVertically
                            ) {
                                Icon(
                                    painterResource(VestaResourceImages.icon_phone),
                                    contentDescription = "",
                                    tint = MaterialTheme.colorScheme.onSecondary,
                                    modifier = Modifier.size(30.dp)
                                )
                                Spacer(Modifier.width(20.dp))
                                Text(
                                    text = state.currentUser.telephone,
                                    fontSize = 15.sp,
                                    lineHeight = 18.5.sp,
                                    fontWeight = FontWeight.Normal,
                                )
                            }

                            Row(
                                Modifier
                                    .fillMaxWidth()
                                    .padding(top = 25.dp),
                                verticalAlignment = Alignment.CenterVertically
                            ) {
                                Icon(
                                    painterResource(VestaResourceImages.icon_mail),
                                    contentDescription = "",
                                    tint = MaterialTheme.colorScheme.onSecondary,
                                    modifier = Modifier.size(30.dp)
                                )
                                Spacer(Modifier.width(20.dp))
                                Text(
                                    text = state.currentUser.email,
                                    fontSize = 15.sp,
                                    lineHeight = 18.5.sp,
                                    fontWeight = FontWeight.Normal
                                )
                            }
                        }
                        CustomButton(
                            onClick = {viewModel.updateChangePassword(true)},
                            text = VestaResourceStrings.change_password,
                            background =MaterialTheme.colorScheme.secondary
                        )
                        Spacer(Modifier.height(25.dp))
                        CustomButton(
                            onClick = {viewModel.logOut()},
                            text = VestaResourceStrings.log_out
                        )
                    }
                }
            }
        }
    }
}

@OptIn(ExperimentalMaterial3Api::class)
@Composable
private fun ChangePassword(
    uiState: ProfileState,
    onUpdateOldPassword: (String) -> Unit,
    onUpdateNewPassword: (String) -> Unit,
    onUpdateConfirmPassword: (String) -> Unit,
    onSave: () -> Unit,
    onDismissRequest: () -> Unit
) {
    BasicAlertDialog(
        onDismissRequest = onDismissRequest,
        modifier = Modifier.clip(RoundedCornerShape(15.dp))
        .background(MaterialTheme.colorScheme.background)
    ) {
        Column(
            Modifier
                .fillMaxWidth()
                .padding(20.dp),
            verticalArrangement = Arrangement.Center
        ) {
            RoundedTextField(uiState.oldPassword, onUpdateOldPassword,
                VestaResourceStrings.old_password )
            Spacer(Modifier.height(25.dp))
            RoundedTextField(uiState.newPassword, onUpdateNewPassword,
                VestaResourceStrings.new_password )
            Spacer(Modifier.height(25.dp))
            RoundedTextField(uiState.confirmPassword, onUpdateConfirmPassword,
                VestaResourceStrings.confirm_password)
            Spacer(Modifier.height(35.dp))
            CustomButton(
                onClick = {
                    onSave()
                    onDismissRequest() },
                VestaResourceStrings.save)
        }
    }
}