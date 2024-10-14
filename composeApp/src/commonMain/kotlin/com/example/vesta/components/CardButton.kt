package com.example.vesta.components

import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxHeight
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Button
import androidx.compose.material3.Icon
import androidx.compose.material3.MaterialTheme
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.unit.dp
import com.example.vesta.images.VestaResourceImages
import io.github.skeptick.libres.compose.painterResource

@Composable
fun CardButton(
    modifier: Modifier = Modifier,
    onClick: ()-> Unit
){
    Row(
        modifier = modifier
            .height(35.dp)
            .fillMaxWidth()
            .clip(RoundedCornerShape(10.dp))
            .background( MaterialTheme.colorScheme.primary)
            .clickable { onClick() },
        horizontalArrangement = Arrangement.Center,
        verticalAlignment = Alignment.CenterVertically
    ) {
        Icon(
            painter = painterResource(VestaResourceImages.icon_shopping_basket),
            tint = MaterialTheme.colorScheme.background,
            contentDescription = "",
            modifier = Modifier.size(25.dp)
        )
    }
}