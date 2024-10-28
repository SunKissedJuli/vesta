package com.example.vesta.screen.sity

import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.gestures.detectTapGestures
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.BasicAlertDialog
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.material3.TextButton
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.runtime.collectAsState
import androidx.compose.runtime.getValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.input.pointer.pointerInput
import androidx.compose.ui.platform.LocalFocusManager
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.vesta.components.CustomButton
import com.example.vesta.components.CustomCircularProgressIndicator
import com.example.vesta.components.CustomDropdownMenu
import com.example.vesta.components.LoginTextField
import com.example.vesta.screen.category.CategoryState
import com.example.vesta.strings.VestaResourceStrings

@OptIn(ExperimentalMaterial3Api::class)
@Composable
internal fun SityScreen(
    viewModel: SityViewModel,
    onDismissRequest: ()-> Unit) {
    val state by viewModel.stateFlow.collectAsState()

    LaunchedEffect(viewModel){
        viewModel.loadData()
    }

    if(state!=SityState.InitState) {

        BasicAlertDialog(
            onDismissRequest = onDismissRequest,
            modifier = Modifier.clip(RoundedCornerShape(15.dp))
                .background(MaterialTheme.colorScheme.background)
        ) {

            Column(
                Modifier
                    .fillMaxWidth()
                // .background(MaterialTheme.colorScheme.background)
            ) {

                Row(
                    Modifier
                        .fillMaxWidth()
                        .height(70.dp)
                        .background(MaterialTheme.colorScheme.secondary),
                    verticalAlignment = Alignment.CenterVertically
                ) {

                    Text(
                        text = VestaResourceStrings.choose_sity,
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
                        .padding(30.dp)
                ) {
                    CustomDropdownMenu(
                        items = state.sities,
                        selectedItem = viewModel.getChoosenSity(),
                        onChange = { viewModel.updateChoosenSity(it) })
                }
            }
        }
    }
}