package com.example.vesta.components

import androidx.compose.foundation.border
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.defaultMinSize
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.width
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.vesta.domain.modelsUI.ProductDataResponseUi
import com.example.vesta.strings.VestaResourceStrings

@Composable
fun ProductCard(
    product: ProductDataResponseUi,
    onClick: ()-> Unit
){
    Surface(
        Modifier
            .fillMaxWidth()
            .defaultMinSize(minHeight = 270.dp)
            .padding(horizontal = 20.dp, vertical = 7.dp),
        shadowElevation = 5.dp) {

        Column(Modifier.fillMaxSize().clickable(onClick = onClick)) {
            Column(Modifier.fillMaxWidth()){
               if(product.octStickers.stickerData.title.isNotEmpty()){
                   ProductSticker(product.octStickers.stickerData)
               }
                if(product.octStickers.specialStickerData.title.isNotEmpty()){
                    ProductStickerSpecial(product.octStickers.specialStickerData)
                }
            }

            Row(Modifier.fillMaxWidth().weight(2f).padding(10.dp)){
                Box( Modifier.weight(1f)){
                    CustomAsyncImage(product.image, modifier = Modifier.fillMaxSize())
                }

                Spacer(Modifier.width(10.dp))
                Text(text = product.nameKorr,
                    fontSize = 16.sp,
                    softWrap = true,
                    modifier = Modifier.weight(1.25f),
                    maxLines = 6)
            }

            Row(Modifier.fillMaxWidth().weight(1f).padding(start = 10.dp, bottom = 10.dp, end = 10.dp)){
                Column( Modifier.weight(1f),
                    verticalArrangement = Arrangement.SpaceBetween,
                    horizontalAlignment = Alignment.CenterHorizontally){
                    Text(text = VestaResourceStrings.product_code,
                        color = MaterialTheme.colorScheme.secondaryContainer,
                        fontSize = 16.sp,
                        softWrap = true,
                        textAlign = TextAlign.Center,
                        maxLines = 2)
                    Text(text = product.model,
                        color = MaterialTheme.colorScheme.secondaryContainer,
                        fontSize = 16.sp,
                        softWrap = true,
                        textAlign = TextAlign.Center,
                        maxLines = 2)
                    Spacer(Modifier.height(10.dp))
                    Text(text = "Склад такой-то",
                        color = MaterialTheme.colorScheme.secondary,
                        fontSize = 16.sp,
                        softWrap = true,
                        maxLines = 2)
                }
                Spacer(Modifier.width(10.dp))
                Column( Modifier.weight(1.25f),
                    verticalArrangement = Arrangement.SpaceBetween,
                    horizontalAlignment = Alignment.CenterHorizontally){

                    Row(Modifier.fillMaxWidth()){
                        CounterBlock(
                            onIncrement = {},
                            onDeIncrement = {},
                            modifier = Modifier.weight(3f)
                        )
                        CardButton(modifier = Modifier.weight(1f)) { }

                    }
                    Spacer(Modifier.height(10.dp))
                    Text(text = "${product.price} ${VestaResourceStrings.rub}",
                        color = MaterialTheme.colorScheme.secondary,
                        fontSize = 16.sp,
                        softWrap = true,
                        maxLines = 2)
                }
            }
        }
    }
}