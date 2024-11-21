package com.example.vesta.components

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.width
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.shadow
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.vesta.images.VestaResourceImages
import io.github.skeptick.libres.compose.painterResource

@Composable
fun HeaderWithButtonBack(
    onClick: ()-> Unit,
    text: String
){
    Box(
        modifier = Modifier
            .fillMaxWidth().height(51.dp).background(Color.Transparent)
            .shadow(
                5.dp,
                shape = MaterialTheme.shapes.medium,
                ambientColor = Color(0x1FF00000),
                clip = false,
            )
    ) {
        Row(
            Modifier
                .align(Alignment.TopCenter)
                .fillMaxWidth()
                .height(46.dp)
                .background(MaterialTheme.colorScheme.background),
            verticalAlignment = Alignment.CenterVertically
        ) {
            Spacer(modifier = Modifier.width(20.dp))
            IconButton(
                onClick = { onClick() },
            ) {
                Icon(
                    painter = painterResource(VestaResourceImages.button_back),
                    contentDescription = "",
                    modifier = Modifier.size(24.dp)
                )
            }
            Spacer(modifier = Modifier.weight(1f))
            Text(
                text = text,
                fontSize = 16.sp,
                fontWeight = FontWeight.Medium,
                lineHeight = 19.5.sp
            )
            Spacer(modifier = Modifier.weight(1.2f))
            Spacer(modifier = Modifier.width(20.dp))
        }
    }
}
