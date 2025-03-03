package com.example.vesta.components

import androidx.compose.foundation.background
import androidx.compose.foundation.border
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxHeight
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.wrapContentSize
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.vesta.strings.VestaResourceStrings

@Composable
fun CounterBlock(
    modifier: Modifier = Modifier,
    count: Int = 1,
    onIncrement: () -> Unit,
    onDeIncrement: ()-> Unit,
    buttonColor: Color = MaterialTheme.colorScheme.tertiary,
    tintColor: Color = MaterialTheme.colorScheme.secondaryContainer,
    countColor: Color = MaterialTheme.colorScheme.secondaryContainer) {

    Row(
        modifier
            .height(35.dp)
            .border(1.dp, MaterialTheme.colorScheme.tertiary),
        verticalAlignment = Alignment.CenterVertically) {

        Row(
            Modifier
                .fillMaxHeight()
                .weight(1f)
                .background(buttonColor)
                .clickable{ if(count>1){ onDeIncrement() } },
            verticalAlignment = Alignment.CenterVertically,
            horizontalArrangement = Arrangement.Center){
            Text(text = VestaResourceStrings.minus,
                color = tintColor,
                fontWeight = FontWeight.Bold)
        }

        Text(text = count.toString(),
            style = MaterialTheme.typography.headlineMedium,
            color = countColor,
            fontSize = 15.sp,
            modifier = Modifier.weight(1.25f)
                .wrapContentSize(Alignment.Center))

        Row(
            Modifier
                .fillMaxHeight()
                .weight(1f)
                .background(buttonColor)
                .clickable{ onIncrement()},
            verticalAlignment = Alignment.CenterVertically,
            horizontalArrangement = Arrangement.Center){
                Text(text = VestaResourceStrings.plus,
                    color = tintColor,
                    fontWeight = FontWeight.Bold)
        }
    }
}