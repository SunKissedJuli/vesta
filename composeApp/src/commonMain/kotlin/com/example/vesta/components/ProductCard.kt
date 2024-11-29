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
import androidx.compose.foundation.layout.fillMaxHeight
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.vesta.data.models.product.ProductResponseUi
import com.example.vesta.domain.modelsUI.SpecialStickerDataUi
import com.example.vesta.ext.QuantityToStore
import com.example.vesta.images.VestaResourceImages
import com.example.vesta.strings.VestaResourceStrings
import io.github.skeptick.libres.compose.painterResource
import kotlin.random.Random

@OptIn(ExperimentalLayoutApi::class)
@Composable
fun ProductCard(
    stickers: List<SpecialStickerDataUi>,
    image: String,
    name: String,
    price: Int,
    isFavorite: Boolean = false,
    onClick: ()-> Unit,
    onCartClick: ()-> Unit = {},
    onHeartClick: ()-> Unit = {},
){

    var favorite by remember{ mutableStateOf(isFavorite) }

    Surface(
        Modifier
            .fillMaxWidth()
            .height(270.dp)
            .padding(5.dp),
        shape = RoundedCornerShape(15.dp),
        shadowElevation = 5.dp) {

        CustomScaffold(
            modifier = Modifier
                .fillMaxSize()
                .clip(RoundedCornerShape(15.dp))
                .background(MaterialTheme.colorScheme.background),
            onClick = onClick,
            topBar = {
                FlowRow(
                    modifier = Modifier.fillMaxWidth(),) {
                    for (sticker in stickers) {
                        ProductSticker(sticker)
                    }
                }
            },
            bottomBar = {
                Column {
                    CustomButton(
                        onClick = onCartClick,
                        fontSize = 12.sp,
                        modifier = Modifier.height(25.dp).padding(horizontal = 10.dp),
                        text = VestaResourceStrings.in_cart
                    )
                    Spacer(Modifier.height(10.dp))
                }
            }
        ){
            Column {
                Box(Modifier.fillMaxWidth().weight(1f).padding(vertical = 10.dp, horizontal = 5.dp)){

                    CustomAsyncImage(image, modifier = Modifier.fillMaxHeight().fillMaxWidth(0.8f).align(Alignment.Center))

                    Column(Modifier.fillMaxHeight().align(Alignment.CenterEnd).padding(horizontal = 15.dp),
                        verticalArrangement = Arrangement.SpaceBetween) {
                        IconButton(
                            onClick = {
                                onHeartClick()
                                favorite = !favorite
                            },
                            Modifier.size(30.dp)
                        ) {

                            Icon(
                                painter = painterResource(if (favorite) VestaResourceImages.icon_fav_clicked else VestaResourceImages.icon_fav),
                                contentDescription = "",
                                modifier = Modifier.size(20.dp),
                                tint = MaterialTheme.colorScheme.primary
                            )
                        }

                        IconButton(
                            onClick = {},
                            Modifier.size(30.dp)
                        ) {
                            Icon(
                                painterResource(VestaResourceImages.icon_statistic),
                                contentDescription = "",
                                Modifier.size(20.dp)
                            )
                        }
                    }
                }

                Column(Modifier.weight(1f),
                    verticalArrangement = Arrangement.Center,
                    horizontalAlignment = Alignment.CenterHorizontally) {
                    Text(
                        text = name,
                        fontSize = 12.sp,
                        softWrap = true,
                        textAlign = TextAlign.Center,
                        modifier = Modifier.padding(horizontal = 10.dp),
                        maxLines = 3
                    )

                    Text(
                        text = "${price} ${VestaResourceStrings.rub}",
                        fontSize = 12.sp,
                        textAlign = TextAlign.Center,
                        fontWeight = FontWeight.Bold,
                        modifier = Modifier.padding(vertical = 7.dp),
                    )
                }
            }

        }

    }
}

@OptIn(ExperimentalLayoutApi::class)
@Composable
fun NotUsableProductCardForMainScreen(
    product: ProductResponseUi,
    onClick: ()-> Unit,
){
    Surface(
        Modifier
            .fillMaxWidth()
            .height(310.dp)
            .padding(start = 5.dp, end = 5.dp, top = 5.dp, bottom = 5.dp),
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
                Text(text = product.description.nameKorr,
                    fontSize = 14.sp,
                    softWrap = true,
                    textAlign = TextAlign.Center,
                    modifier = Modifier.padding(horizontal = 7.dp),
                    maxLines = 2)

                Text(
                    text = "${product.multistoreProduct.price} ${VestaResourceStrings.rub}",
                    color = MaterialTheme.colorScheme.secondary,
                    fontSize = 14.sp,
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
