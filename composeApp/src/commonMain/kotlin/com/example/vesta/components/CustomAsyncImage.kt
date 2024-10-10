package com.example.vesta.components

import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.material3.MaterialTheme
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.unit.dp
import coil3.compose.SubcomposeAsyncImage

@Composable
fun CustomAsyncImage(
    image: Any?,
    size: Int = 30,
    errorColor: Color = MaterialTheme.colorScheme.background
){
    SubcomposeAsyncImage((image),
        contentDescription = "",
        contentScale = ContentScale.Crop,
        modifier = Modifier
            .size(size.dp),
        loading = { Box(modifier = Modifier
            .size(size.dp)
            .background(errorColor))
        },
        error = { Box(modifier = Modifier
            .size(size.dp)
            .background(errorColor))
        })
}