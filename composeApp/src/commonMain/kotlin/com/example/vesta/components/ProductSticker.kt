package com.example.vesta.components

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxHeight
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.vesta.domain.modelsUI.OctStickerDataUi
import com.example.vesta.domain.modelsUI.SpecialStickerDataUi
import com.example.vesta.ext.rgbToColor

@Composable
fun ProductStickerSpecial(sticker: SpecialStickerDataUi){
    Row(Modifier.height(28.dp).background(sticker.fonColor.rgbToColor()),
        verticalAlignment = Alignment.CenterVertically){
        Text(
            text = sticker.title,
            color = sticker.textColor.rgbToColor(),
            fontSize = 13.sp,
            modifier = Modifier.padding(horizontal = 5.dp)
        )
    }
}

@Composable
fun ProductSticker(sticker: OctStickerDataUi){
    Row(Modifier.height(30.dp).background(sticker.fonColor.rgbToColor()),
        verticalAlignment = Alignment.CenterVertically){
        Text(
            text = sticker.title,
            color = sticker.textColor.rgbToColor(),
            fontSize = 15.sp,
            modifier = Modifier.padding(horizontal = 5.dp)
        )
    }
}