package com.example.vesta.components

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.CircularProgressIndicator
import androidx.compose.material3.MaterialTheme
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.Shape
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.unit.dp
import coil3.compose.SubcomposeAsyncImage
import coil3.request.ImageRequest
import com.example.vesta.platform.CompressedAsyncImage


@Composable
fun CustomFlexAsyncImage(
    image: Any?,
    size: Int = 30,
    errorColor: Color = MaterialTheme.colorScheme.background,
    modifier: Modifier = Modifier,
    contentScale: ContentScale = ContentScale.FillWidth,
){

    SubcomposeAsyncImage(
        model =(image),
        contentDescription = "",
        contentScale = contentScale,
        modifier = modifier.fillMaxWidth(),
        loading = { Box(modifier = modifier
            .size(size.dp)
            .background(errorColor)){
            CircularProgressIndicator(
                color = MaterialTheme.colorScheme.primary,
                modifier = Modifier.align(Alignment.Center)) }
                  },
        //сделать норм заглушки
        error = { Box(modifier = modifier
            .size(size.dp)
            .background(errorColor))
        })
}