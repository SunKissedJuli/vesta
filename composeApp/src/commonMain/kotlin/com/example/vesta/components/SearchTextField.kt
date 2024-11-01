package com.example.vesta.components

import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.foundation.text.BasicTextField
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Search
import androidx.compose.material3.Icon
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.vesta.ext.clickableBlank
import com.example.vesta.strings.VestaResourceStrings

@Composable
fun SearchTextField(
    value: String,
    onValueChange: (String)->Unit,
    onClick: ()-> Unit = {}){
    Row(verticalAlignment = Alignment.CenterVertically){
        BasicTextField(
            value = value,
            onValueChange = { onValueChange(it) },
            modifier = Modifier
                .fillMaxWidth(0.9f)
                .padding(start = 15.dp),
            textStyle = TextStyle.Default.copy(
                fontSize = 17.sp,
            ),
            maxLines = 1,
            decorationBox = { innerTextField ->
                Box(modifier = Modifier.fillMaxWidth().align(Alignment.CenterVertically)) {
                    innerTextField()
                    if (value.isEmpty()) {
                        Text(
                            text = VestaResourceStrings.search_string,
                            color = MaterialTheme.colorScheme.secondaryContainer,
                            fontSize = 12.sp,
                            maxLines = 1,
                            modifier = Modifier.align(Alignment.CenterStart)
                        )
                    }
                }
            }
        )
        Icon(
            Icons.Default.Search,
            modifier = Modifier
                .padding(horizontal = 5.dp)
                .size(25.dp)
                .clickableBlank{onClick()},
            contentDescription = "",
            tint = MaterialTheme.colorScheme.onTertiary
        )
    }
}