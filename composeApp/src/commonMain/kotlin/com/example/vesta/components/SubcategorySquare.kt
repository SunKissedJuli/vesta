package com.example.vesta.components

import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.painter.Painter
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp

@Composable
fun SubcategorySquare(
    modifier: Modifier = Modifier,
    image: Painter,
    name: String
){
    Column(modifier
        .fillMaxWidth()
        .height(180.dp)
        .background(MaterialTheme.colorScheme.background),
        horizontalAlignment = Alignment.CenterHorizontally,
        verticalArrangement = Arrangement.Center) {

        CustomAsyncImage(
            image = image,
            size = 88
        )
        Text(text = name, fontSize = 14.sp, color = MaterialTheme.colorScheme.tertiaryContainer)

    }
}