package com.example.vesta.components

import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Icon
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.draw.rotate
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.vesta.images.VestaResourceImages
import io.github.skeptick.libres.compose.painterResource

@Composable
fun ArrowButton(
    onClick: () -> Unit,
    text: String,
    modifier: Modifier = Modifier,
    background: Color = MaterialTheme.colorScheme.onSecondaryContainer,
    textColor: Color = MaterialTheme.colorScheme.onSecondary,
) {
    Row( modifier = modifier
        .fillMaxWidth()
        .height(44.dp)
        .clip(RoundedCornerShape(50.dp))
        .background(background)
        .clickable(onClick = onClick),
        horizontalArrangement = Arrangement.SpaceBetween,
        verticalAlignment = Alignment.CenterVertically
    ){
        Text(
            text = text,
            fontSize = 14.sp,
            fontWeight = FontWeight.Normal,
            letterSpacing = 0.6.sp,
            color = textColor,
            modifier = Modifier.padding(start = 20.dp)
        )
        Icon(
            painter = painterResource(VestaResourceImages.button_back),
            tint = textColor,
            contentDescription = "",
            modifier = Modifier.padding(end = 20.dp).rotate(180f))
    }
}