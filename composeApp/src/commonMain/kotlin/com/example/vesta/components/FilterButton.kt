package com.example.vesta.components

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Button
import androidx.compose.material3.ButtonColors
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import com.example.vesta.strings.VestaResourceStrings

@Composable
fun FilterButton(
    onClick: ()-> Unit,
    text: String = VestaResourceStrings.filter,
    modifier: Modifier = Modifier
){
    Button(
        onClick = onClick,
        modifier
            .fillMaxWidth()
            .padding(20.dp)
            .background(MaterialTheme.colorScheme.primary),
        ){
        Text(text = text)

    }

}