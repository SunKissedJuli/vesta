package com.example.vesta.components

import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.material3.MaterialTheme
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.painter.Painter
import androidx.compose.ui.unit.dp

@Composable
fun SubcategorySquare(
    modifier: Modifier = Modifier,
    image: Painter,
    name: String
){
    Column(modifier
        .fillMaxWidth()
        .height(180.dp)
        .background(MaterialTheme.colorScheme.background)) {

//        CustomAsyncImage(
//            image = image,
//            size =
//            )
    }
}