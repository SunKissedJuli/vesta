package com.example.vesta.platform

import androidx.compose.runtime.Composable
import androidx.compose.ui.platform.LocalContext
import coil3.request.ImageRequest
import coil3.size.Size
@Composable
internal actual fun CompressedAsyncImage(imageUrl: String) : Any{
     val request = ImageRequest.Builder(LocalContext.current)
        .data(imageUrl)
        .size(80, 120)
        .build()
    return request
}