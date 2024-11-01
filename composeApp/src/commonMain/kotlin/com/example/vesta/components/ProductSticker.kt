package com.example.vesta.components

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxHeight
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.wrapContentWidth
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.vesta.domain.modelsUI.OctStickerDataUi
import com.example.vesta.domain.modelsUI.SpecialStickerDataUi
import com.example.vesta.ext.rgbToColor

@Composable
fun ProductSticker(
    sticker: SpecialStickerDataUi
){
    val colorScheme = MaterialTheme.colorScheme
    Box(
        Modifier
            .height(22.dp)
            .padding(start = 10.dp, top = 5.dp )
            .clip(RoundedCornerShape(50.dp))
            .wrapContentWidth()
            .background(sticker.fonColor.rgbToColor(colorScheme)),
       ){
        Box(Modifier
            .fillMaxHeight()
            .clip(RoundedCornerShape(50.dp))
            .wrapContentWidth()
            .background(colorScheme.background.copy(alpha = 0.2f)),
        ) {
            Text(
                text = sticker.title,
                color = sticker.textColor.rgbToColor(colorScheme),
                fontSize = 10.sp,
                softWrap = true,
                modifier = Modifier.align(Alignment.Center).padding(horizontal = 10.dp)
            )
        }
    }
}
