package com.example.vesta.components

import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Button
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.vesta.strings.VestaResourceStrings

@Composable
fun CustomButton(
    onClick: () -> Unit,
    text: String ,
    modifier: Modifier = Modifier
) {
//    Button( onClick = onClick,
//        shape =  RoundedCornerShape(40.dp),
//        modifier = modifier
//        .fillMaxWidth()
//        .height(50.dp)
//        .background(MaterialTheme.colorScheme.primary,
//            RoundedCornerShape(40.dp)
//        ),
//  //      shape =  RoundedCornerShape(50.dp),
//
//        )
    Row( modifier = modifier
        .fillMaxWidth()
        .height(40.dp)
        .clip(RoundedCornerShape(50.dp))
        .background(MaterialTheme.colorScheme.primary)
        .clickable(onClick = onClick),
        horizontalArrangement = Arrangement.Center,
        verticalAlignment = Alignment.CenterVertically
    ){
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