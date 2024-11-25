package com.example.vesta.components

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.text.BasicTextField
import androidx.compose.material3.Icon
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.vesta.ext.clickableBlank
import com.example.vesta.images.VestaResourceImages
import com.example.vesta.strings.VestaResourceStrings
import io.github.skeptick.libres.compose.painterResource

@Composable
fun SearchTextField(
    value: String,
    onValueChange: (String)->Unit,
    onClick: ()-> Unit = {}){
    Row(verticalAlignment = Alignment.CenterVertically,
        horizontalArrangement = Arrangement.SpaceBetween){
        BasicTextField(
            value = value,
            onValueChange = { onValueChange(it) },
            modifier = Modifier
                .fillMaxWidth()
                .padding(start = 15.dp, end = 15.dp),
            textStyle = TextStyle.Default.copy(fontSize = 14.sp),
            maxLines = 1,
            decorationBox = { innerTextField ->
                Box(modifier = Modifier.fillMaxWidth().align(Alignment.CenterVertically)) {
                    innerTextField()

                    Row(Modifier.fillMaxWidth(),
                        horizontalArrangement = Arrangement.SpaceBetween,
                        verticalAlignment = Alignment.CenterVertically){
                        if (value.isEmpty()) {
                            Text(
                                text = VestaResourceStrings.search_string,
                                color = MaterialTheme.colorScheme.secondaryContainer,
                                fontSize = 14.sp,
                                maxLines = 1
                            )
                        }
                        else{
                            Spacer(Modifier.width(10.dp))
                        }
                        Icon(
                            painterResource(VestaResourceImages.icon_search),
                            modifier = Modifier
                                .size(20.dp)
                                .clickableBlank{onClick()},
                            contentDescription = "",
                            tint = MaterialTheme.colorScheme.onSecondary
                        )
                    }
                }
            }
        )
    }
}