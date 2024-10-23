package com.example.vesta.platform

import androidx.compose.runtime.Composable
import coil3.request.ImageRequest

@Composable
internal expect fun CompressedAsyncImage(imageUrl: String) : Any