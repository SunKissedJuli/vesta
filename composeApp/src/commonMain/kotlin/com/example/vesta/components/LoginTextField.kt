package com.example.vesta.components

import androidx.compose.foundation.border
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.text.BasicTextField
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.text.Placeholder
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.vesta.strings.VestaResourceStrings

@Composable
fun LoginTextField(
    modifier: Modifier = Modifier,
    value: String,
    onValueChange: (String)-> Unit,
    placeholder: String
) {
    Row(
        Modifier
            .fillMaxWidth()
            .height(60.dp)
            .border(1.dp, MaterialTheme.colorScheme.secondaryContainer)
    ){
        BasicTextField(
            value = value,
            onValueChange = { onValueChange(it) },
            modifier = Modifier
                .fillMaxWidth()
                .padding(start = 15.dp)
                .align(Alignment.CenterVertically),
            textStyle = TextStyle.Default.copy(
                fontSize = 18.sp,
                fontWeight = FontWeight.Normal,
            ),
            maxLines = 1,
            decorationBox = { innerTextField ->
                Box(modifier = Modifier.fillMaxWidth().align(Alignment.CenterVertically)) {
                    innerTextField()
                    if (value.isEmpty()) {
                        Text(
                            text = placeholder,
                            color = MaterialTheme.colorScheme.secondaryContainer,
                            fontSize = 18.sp,
                            maxLines = 1,
                            fontWeight = FontWeight.Normal,
                            modifier = Modifier.align(Alignment.CenterStart)
                        )
                    }
                }
            }
        )
    }
}