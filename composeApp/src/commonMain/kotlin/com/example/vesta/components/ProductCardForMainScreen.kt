package com.example.vesta.components

import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.ExperimentalLayoutApi
import androidx.compose.foundation.layout.FlowRow
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.vesta.data.models.product.ProductResponseUi
import com.example.vesta.domain.modelsUI.ProductsDataResponseUi
import com.example.vesta.ext.QuantityToStore
import com.example.vesta.strings.VestaResourceStrings

@OptIn(ExperimentalLayoutApi::class)
@Composable
fun ProductCardForMainScreen(
    product: ProductResponseUi,
    onClick: ()-> Unit,
){
    Surface(
        Modifier
            .fillMaxWidth()
            .height(310.dp)
            .padding(horizontal = 10.dp, vertical = 7.dp),
        shape = RoundedCornerShape(15.dp),
        shadowElevation = 5.dp) {

        Column(
            Modifier
                .fillMaxSize()
                .clip(RoundedCornerShape(15.dp))
                .background(MaterialTheme.colorScheme.background)
                .clickable(onClick = onClick),
            verticalArrangement = Arrangement.Center) {
            FlowRow(
                modifier = Modifier.fillMaxWidth(),) {
                for (sticker in product.octStickers.specialStickerData) {
                    ProductSticker(sticker)
                }
            }

            Row(Modifier.fillMaxWidth().weight(1f).padding(vertical = 10.dp, horizontal = 5.dp)){
                CustomAsyncImage(product.image, modifier = Modifier.fillMaxSize())
            }
            Spacer(Modifier.width(10.dp))

            Column(Modifier.weight(1.5f),
                verticalArrangement = Arrangement.Center,
                horizontalAlignment = Alignment.CenterHorizontally) {
                Text(text = product.description[0].nameKorr,
                    fontSize = 14.sp,
                    softWrap = true,
                    textAlign = TextAlign.Center,
                    modifier = Modifier.padding(horizontal = 7.dp),
                    maxLines = 2)

                Text(
                    text = "${product.multistoreProduct.price} ${VestaResourceStrings.rub}",
                    color = MaterialTheme.colorScheme.secondary,
                    fontSize = 15.sp,
                    textAlign = TextAlign.Center,
                    modifier = Modifier.padding(vertical = 7.dp),
                )
                Column(
                    Modifier.fillMaxWidth(),
                    verticalArrangement = Arrangement.Center,
                    horizontalAlignment = Alignment.CenterHorizontally){
                    Row(Modifier.fillMaxWidth().height(35.dp)){
                        CounterBlock(
                            onIncrement = {},
                            onDeIncrement = {},
                            modifier = Modifier.weight(3f)
                        )
                        CardButton(modifier = Modifier.weight(1f)) { }
                    }
                }
                Spacer(Modifier.height(7.dp))
                Text(
                    text = product.quantityLen117.QuantityToStore(),
                    color = MaterialTheme.colorScheme.secondary,
                    fontSize = 14.sp,
                    softWrap = true,
                    textAlign = TextAlign.Center,
                    maxLines = 2
                )
            }

        }
    }
}
