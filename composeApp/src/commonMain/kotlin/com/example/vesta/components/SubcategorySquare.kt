package com.example.vesta.components

import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.painter.Painter
import androidx.compose.ui.text.font.FontFamily
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp

@Composable
fun SubcategorySquare(
    modifier: Modifier = Modifier,
    image: Any,
    name: String
){
    Box(modifier
        .fillMaxWidth()
        .height(210.dp)
        .padding(10.dp)
        .background(MaterialTheme.colorScheme.background)
        .clickable{}) {

        Column(
            Modifier
                .padding(10.dp)
                .align(Alignment.Center),
            verticalArrangement = Arrangement.Center,
            horizontalAlignment = Alignment.CenterHorizontally
        ){
            CustomAsyncImage(image = image, size = 88)
            Spacer(Modifier.height(15.dp))
            Text(
                text = name,
                fontSize = 17.sp,
                fontFamily = FontFamily.SansSerif,
                color = MaterialTheme.colorScheme.secondaryContainer,
                softWrap = true,
                maxLines = 3,
                textAlign = TextAlign.Center,
                modifier = Modifier.padding(horizontal = 3.dp)
            )
        }
    }
}