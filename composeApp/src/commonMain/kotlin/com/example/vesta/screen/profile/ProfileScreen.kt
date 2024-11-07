package com.example.vesta.screen.profile

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.RowScope
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
import androidx.compose.material3.Button
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
import cafe.adriel.voyager.core.lifecycle.LifecycleEffect
import cafe.adriel.voyager.core.model.rememberScreenModel
import cafe.adriel.voyager.core.screen.Screen
import cafe.adriel.voyager.navigator.LocalNavigator
import cafe.adriel.voyager.navigator.currentOrThrow
import com.example.vesta.components.ArrowButton
import com.example.vesta.components.CustomButton
import com.example.vesta.components.CustomCircularProgressIndicator
import com.example.vesta.components.CustomScaffold
import com.example.vesta.components.HorizontalLine
import com.example.vesta.components.RoundedTextField
import com.example.vesta.components.VerticalLine
import com.example.vesta.ext.formatCost
import com.example.vesta.ext.toFormattedDate
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

        LifecycleEffect(
            onStarted = {
                viewModel.setBottomBarVisible(true)
            }
        )

        LaunchedEffect(viewModel){
            viewModel.loadData()
        }

        LaunchedEffect(viewModel) {
            viewModel.container.sideEffectFlow.collect() {
                when (it) {
                    is ProfileEvent.UserLogOut -> {
                        navigator.replace(SignInScreen())
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
                            text = VestaResourceStrings.personal_account,
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
                        Text(
                            text = VestaResourceStrings.basic_information,
                            fontSize = 16.sp,
                            fontWeight = FontWeight.Bold,
                            lineHeight = 19.5.sp,
                            modifier = Modifier.padding(bottom = 15.dp)
                        )
                        RoundedTextField(
                            value = state.currentUser.firstName,
                            onValueChange = {},
                            placeholder = VestaResourceStrings.first_name
                        )
                        Spacer(Modifier.height(20.dp))

                        RoundedTextField(
                            value = state.currentUser.lastName,
                            onValueChange = {},
                            placeholder = VestaResourceStrings.last_name
                        )
                        Spacer(Modifier.height(20.dp))

                        RoundedTextField(
                            value = state.currentUser.middleName,
                            onValueChange = {},
                            placeholder = VestaResourceStrings.patronymic
                        )
                        Text(
                            text = VestaResourceStrings.contact_information,
                            fontSize = 16.sp,
                            lineHeight = 19.5.sp,
                            fontWeight = FontWeight.Bold,
                            modifier = Modifier.padding(top =20.dp, bottom = 15.dp)
                        )
                        RoundedTextField(
                            value = state.currentUser.telephone,
                            onValueChange = {},
                            placeholder = VestaResourceStrings.phone
                        )
                        Spacer(Modifier.height(20.dp))
                        RoundedTextField(
                            value = state.currentUser.email,
                            onValueChange = {},
                            placeholder = VestaResourceStrings.email
                        )

                        //история заказов
                        HistoryBlock(state, {})

                        Spacer(Modifier.height(20.dp))
                        ArrowButton(
                            onClick = {},
                            text = VestaResourceStrings.address_book
                        )
                        Spacer(Modifier.height(15.dp))
                        ArrowButton(
                            onClick = {},
                            text = VestaResourceStrings.favorites
                        )
                        Spacer(Modifier.height(15.dp))
                        ArrowButton(
                            onClick = {viewModel.updateChangePassword(true)},
                            text = VestaResourceStrings.change_password
                        )
                        Spacer(Modifier.height(45.dp))
                        CustomButton(
                            onClick = {viewModel.logOut()},
                            text = VestaResourceStrings.log_out,
                            modifier = Modifier.height(37.dp)
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

@Composable
private fun HistoryBlock(
    state: ProfileState,
    onClick: ()-> Unit
){
    Box(
        Modifier
            .fillMaxWidth()
            .padding(top = 25.dp)
            .clip(RoundedCornerShape(25.dp))
            .background(MaterialTheme.colorScheme.onSecondaryContainer)) {
        Column(Modifier.padding(horizontal = 10.dp, vertical = 10.dp)
        ) {
            Text(
                text = VestaResourceStrings.history,
                fontSize = 14.sp,
                modifier = Modifier.padding(top = 10.dp, start = 10.dp)
            )

            for(order in state.currentUser.orders){
                Column {
                    HorizontalLine(Modifier.padding(vertical = 5.dp))
                    Row(Modifier.fillMaxWidth().padding(vertical = 5.dp, horizontal = 10.dp),
                        horizontalArrangement = Arrangement.SpaceBetween){
                        Text(
                            text = VestaResourceStrings.number_order + order.orderId.toString(),
                            fontSize = 12.sp,
                            fontWeight = FontWeight.Bold
                        )
                        Text(
                            text = order.total.formatCost(),
                            fontSize = 12.sp,
                            fontWeight = FontWeight.Bold
                        )
                    }
                    Row(Modifier.fillMaxWidth().padding(top = 8.dp, start = 10.dp, end = 10.dp),
                        horizontalArrangement = Arrangement.SpaceBetween){
                        Text(
                            text = order.name,
                            fontSize = 12.sp,
                        )
                        Text(
                            text = order.dateAdded.toFormattedDate(),
                            fontSize = 12.sp,
                        )
                    }
                }
            }
            Spacer(Modifier.height(15.dp))
            ArrowButton(
                onClick = onClick,
                text = VestaResourceStrings.more,
                background = MaterialTheme.colorScheme.primary,
                textColor = MaterialTheme.colorScheme.background,
                modifier = Modifier.height(34.dp)
            )
        }
    }
}
