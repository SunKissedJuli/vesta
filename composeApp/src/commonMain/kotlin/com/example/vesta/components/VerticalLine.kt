package com.example.vesta.components

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.fillMaxHeight
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.width
import androidx.compose.material3.MaterialTheme
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.alpha
import androidx.compose.ui.unit.dp

@Composable
fun VerticalLine(modifier: Modifier = Modifier){
    Box(modifier = modifier
        .padding(horizontal = 2.dp)
        .fillMaxHeight()
        .width(1.dp)
        .background(color = MaterialTheme.colorScheme.background)
        .alpha(0.5f)
    )
}