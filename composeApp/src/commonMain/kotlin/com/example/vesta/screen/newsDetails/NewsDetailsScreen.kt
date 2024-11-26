package com.example.vesta.screen.newsDetails

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.grid.GridCells
import androidx.compose.foundation.lazy.grid.GridItemSpan
import androidx.compose.foundation.lazy.grid.LazyVerticalGrid
import androidx.compose.foundation.lazy.grid.items
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.runtime.collectAsState
import androidx.compose.runtime.getValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import cafe.adriel.voyager.core.model.rememberScreenModel
import cafe.adriel.voyager.core.screen.Screen
import cafe.adriel.voyager.navigator.LocalNavigator
import cafe.adriel.voyager.navigator.currentOrThrow
import cafe.adriel.voyager.navigator.tab.LocalTabNavigator
import com.example.vesta.components.CustomButton
import com.example.vesta.components.CustomCircularProgressIndicator
import com.example.vesta.components.CustomFlexAsyncImage
import com.example.vesta.components.CustomScaffold
import com.example.vesta.components.HeaderOneWord
import com.example.vesta.components.HeaderWithButtonBack
import com.example.vesta.components.HorizontalLine
import com.example.vesta.components.ProductCard
import com.example.vesta.ext.toFormattedDate
import com.example.vesta.screen.product.ProductScreen
import com.example.vesta.strings.VestaResourceStrings


class NewsDetailsScreen(private val id: Int): Screen {
    @OptIn(ExperimentalMaterial3Api::class)
    @Composable
    override fun Content() {

        val viewModel = rememberScreenModel { NewsDetailsViewModel() }
        val state by viewModel.stateFlow.collectAsState()
        val navigator = LocalNavigator.currentOrThrow
        val tabNavigator = LocalTabNavigator.current

        LaunchedEffect(viewModel) {
            viewModel.loadData(id)
        }

        CustomScaffold(
            topBar = {
                HeaderWithButtonBack(
                    onClick = {navigator.pop()},
                    text = VestaResourceStrings.home
                )
            }
        ) {
            if (viewModel.status.collectAsState().value && NewsDetailsState.InitState == state) {
                CustomCircularProgressIndicator()
            } else {

                LazyVerticalGrid(
                    modifier = Modifier.fillMaxSize().padding(horizontal = 15.dp),
                    columns = GridCells.Fixed(2),
                    contentPadding = PaddingValues(vertical = 10.dp)
                ){
                    item(span = { GridItemSpan(2)}){
                        Column(
                            Modifier
                                .fillMaxSize()
                                .padding(horizontal = 5.dp)
                        ) {

                            Text(
                                text = state.newsData.name,
                                fontWeight = FontWeight.SemiBold,
                                fontSize = 16.sp
                            )
                            Spacer(Modifier.height(20.dp))

                            CustomFlexAsyncImage(
                                image = state.newsData.image,
                                modifier = Modifier.fillMaxWidth().clip(RoundedCornerShape(15.dp)),
                                contentScale = ContentScale.FillWidth
                            )
                            Spacer(Modifier.height(10.dp))

                            Row(Modifier.fillMaxWidth(),
                                verticalAlignment = Alignment.CenterVertically,
                                horizontalArrangement = Arrangement.SpaceBetween
                            ){

                                Text(
                                    text = state.newsData.viewed.toString(),
                                    color = MaterialTheme.colorScheme.secondaryContainer,
                                    fontWeight = FontWeight.Normal,
                                    fontSize = 12.sp
                                )

                                Text(
                                    text = state.newsData.dateAdded.toFormattedDate(),
                                    color = MaterialTheme.colorScheme.secondaryContainer,
                                    fontWeight = FontWeight.Normal,
                                    fontSize = 12.sp
                                )

                            }
                            Spacer(Modifier.height(10.dp))

                            if(state.newsData.description.isNotEmpty()){
                                Text(
                                    text = state.newsData.description,
                                    fontWeight = FontWeight.Normal,
                                    fontSize = 14.sp
                                )
                            }

                        }
                    }

                   //items(){}

                    item(span = { GridItemSpan(2)}) {
                        CustomButton(
                            onClick = {},
                            text = if(false) VestaResourceStrings.all_comments else VestaResourceStrings.add_comment,
                            modifier = Modifier.fillMaxWidth().padding(horizontal = 5.dp, vertical = 15.dp)
                        )
                    }

                    // рекомендованные товары
                    if(state.newsData.relatedProduct.isNotEmpty()){
                        item(span = { GridItemSpan(2)}){
                            Column(Modifier.fillMaxWidth()) {
                                HorizontalLine()
                                Text(
                                    text = VestaResourceStrings.stock_products,
                                    fontWeight = FontWeight.SemiBold,
                                    fontSize = 16.sp,
                                    modifier = Modifier.padding(horizontal = 5.dp, vertical = 15.dp)
                                )
                            }


                        }
                        items(state.newsData.relatedProduct){ product ->
                            ProductCard(
                                image = product.image,
                                name = product.name,
                                price = product.price,
                                stickers = product.octStickers.specialStickerData,
                                onClick = {navigator.push(ProductScreen(product.productId))}
                            )
                        }
                    }
                }
            }
        }
    }
}
