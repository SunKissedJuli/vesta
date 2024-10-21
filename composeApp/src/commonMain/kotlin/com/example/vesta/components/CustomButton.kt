package com.example.vesta.components

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Button
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.vesta.strings.VestaResourceStrings

//@Composable
//fun CustomButton(
//    onClick: () -> Unit,
//    text: String ,
//    modifier: Modifier = Modifier
//) {
//    Button(
//        onClick = onClick,
//        modifier = modifier
//            .fillMaxWidth()
//            .background( MaterialTheme.colorScheme.primary),
//    ) {
//        Text(
//            text = text,
//            fontSize = 17.sp,
//            fontWeight = FontWeight.Medium,
//            color = MaterialTheme.colorScheme.background
//        )
//    }
//}

@Composable
fun CustomButton(
    onClick: () -> Unit,
    text: String ,
    modifier: Modifier = Modifier
) {
    Button(
        onClick = onClick,
        modifier = modifier
            .fillMaxWidth()
            .height(40.dp)
            .background(MaterialTheme.colorScheme.primary, RoundedCornerShape(50.dp)),
    ) {
        Text(
            text = text,
            fontSize = 16.sp,
            lineHeight = 19.5.sp,
            fontWeight = FontWeight.Bold,
            letterSpacing = 1.sp,
            color = MaterialTheme.colorScheme.background
        )
    }
}