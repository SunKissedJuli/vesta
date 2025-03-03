package com.example.vesta.screen.city

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.BasicAlertDialog
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.runtime.collectAsState
import androidx.compose.runtime.getValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.vesta.components.CustomDropdownMenu
import com.example.vesta.strings.VestaResourceStrings

@OptIn(ExperimentalMaterial3Api::class)
@Composable
internal fun CityScreen(
    viewModel: CityViewModel,
    onDismissRequest: ()-> Unit) {
    val state by viewModel.stateFlow.collectAsState()

    LaunchedEffect(viewModel){
        viewModel.loadData()
    }

    if(state!=CityState.InitState) {

        BasicAlertDialog(
            onDismissRequest = onDismissRequest,
            modifier = Modifier.clip(RoundedCornerShape(15.dp))
                .background(MaterialTheme.colorScheme.background)
        ) {

            Column(
                Modifier
                    .fillMaxWidth()
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
                        items = state.cities,
                        selectedItem = viewModel.getChoosenSity(),
                        onChange = { viewModel.updateChoosenSity(it) })
                }
            }
        }
    }
}