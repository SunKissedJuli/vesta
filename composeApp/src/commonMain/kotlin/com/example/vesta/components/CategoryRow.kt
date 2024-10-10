package com.example.vesta.components

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.width
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.ArrowDropDown
import androidx.compose.material.icons.filled.KeyboardArrowDown
import androidx.compose.material3.Icon
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.rotate
import androidx.compose.ui.text.font.Font
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.vesta.domain.modelsUI.CategoryUi
import kotlin.math.PI

@Composable
fun CategoryRow(
    image: String,
    name: String,
    onClick: ()->Unit = {}
){
    Row(Modifier
        .fillMaxWidth()
        .padding(top = 10.dp),
        horizontalArrangement = Arrangement.SpaceBetween) {
        Row {
            CustomAsyncImage(image)
            Spacer(Modifier.width(10.dp))
            Text(
                name,
                fontSize = 15.sp,
                fontWeight = FontWeight.Medium
            )
        }
        Icon(
            Icons.Default.KeyboardArrowDown,
            modifier = Modifier.rotate(PI.toFloat()),
            contentDescription = ""
        )
    }
}