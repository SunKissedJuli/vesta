package com.example.vesta.screen.profile

import androidx.compose.foundation.background
import androidx.compose.foundation.gestures.detectTapGestures
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.AlertDialog
import androidx.compose.material3.AlertDialogDefaults
import androidx.compose.material3.BasicAlertDialog
import androidx.compose.material3.Button
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.material3.TextButton
import androidx.compose.runtime.Composable
import androidx.compose.runtime.collectAsState
import androidx.compose.runtime.getValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.input.pointer.pointerInput
import androidx.compose.ui.platform.LocalFocusManager
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.compose.ui.window.Dialog
import com.example.vesta.components.CustomButton
import com.example.vesta.components.LoginTextField
import com.example.vesta.strings.VestaResourceStrings

@OptIn(ExperimentalMaterial3Api::class)
@Composable
internal fun ProfileScreen(viewModel: ProfileViewModel, onDismissRequest: ()-> Unit){
    val localFocusManager = LocalFocusManager.current
    val state by viewModel.stateFlow.collectAsState()

    BasicAlertDialog(
        onDismissRequest = onDismissRequest){

        Column(Modifier
            .fillMaxWidth()
            .background(MaterialTheme.colorScheme.background)
            .pointerInput(Unit) { detectTapGestures(
                onTap = { localFocusManager.clearFocus() }
            ) }
        ) {

            Row(Modifier
                .fillMaxWidth()
                .height(70.dp)
                .background(MaterialTheme.colorScheme.secondary),
                verticalAlignment = Alignment.CenterVertically){

                Text(
                    text = VestaResourceStrings.authorize,
                    color = MaterialTheme.colorScheme.background,
                    fontWeight = FontWeight.Medium,
                    letterSpacing = 1.sp,
                    fontSize = 22.sp,
                    modifier = Modifier.padding(start = 30.dp)
                )
            }

            Column(
                Modifier
                    .fillMaxWidth()
                    .padding(30.dp)) {
                LoginTextField(
                    placeholder = VestaResourceStrings.email,
                    value = state.email,
                    onValueChange = {viewModel.updateEmail(it)}
                )
                Spacer(Modifier.height(30.dp))

                LoginTextField(
                    placeholder = VestaResourceStrings.password,
                    value = state.password,
                    onValueChange = {viewModel.updatePassword(it)}
                )
                Spacer(Modifier.height(30.dp))

                Row(Modifier.fillMaxWidth(),
                    horizontalArrangement = Arrangement.SpaceBetween){
                    TextButton(onClick={}, modifier = Modifier.weight(1f)){
                        Text(text = VestaResourceStrings.forgot_password)
                    }
                    TextButton(onClick={}, modifier = Modifier.weight(1f)){
                        Text(text = VestaResourceStrings.registration)
                    }
                }
                Spacer(Modifier.height(30.dp))

                CustomButton(
                    text = VestaResourceStrings.sign_in,
                    onClick = {viewModel.signIn(state.email, state.password)}
                )
            }
        }
    }
}