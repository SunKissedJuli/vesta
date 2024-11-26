package com.example.vesta.screen.subCategory

import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxHeight
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.lazy.grid.GridCells
import androidx.compose.foundation.lazy.grid.GridItemSpan
import androidx.compose.foundation.lazy.grid.LazyVerticalGrid
import androidx.compose.foundation.lazy.grid.items
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.runtime.collectAsState
import androidx.compose.runtime.getValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.draw.shadow
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import cafe.adriel.voyager.core.lifecycle.LifecycleEffect
import cafe.adriel.voyager.core.model.rememberScreenModel
import cafe.adriel.voyager.core.screen.Screen
import cafe.adriel.voyager.core.screen.ScreenKey
import cafe.adriel.voyager.navigator.LocalNavigator
import cafe.adriel.voyager.navigator.currentOrThrow
import com.example.vesta.components.CustomAsyncImage
import com.example.vesta.components.CustomCircularProgressIndicator
import com.example.vesta.components.CustomScaffold
import com.example.vesta.components.HeaderWithButtonBack
import com.example.vesta.components.ProductCard
import com.example.vesta.images.VestaResourceImages
import com.example.vesta.screen.product.ProductScreen
import com.example.vesta.strings.VestaResourceStrings
import io.github.skeptick.libres.compose.painterResource

class SubcategoryScreen(private val id: Int): Screen {
    override val key: ScreenKey = id.toString()
    @Composable
    override fun Content() {

        val viewModel = rememberScreenModel { SubcategoryViewModel() }
        val state by viewModel.stateFlow.collectAsState()
        val navigator = LocalNavigator.currentOrThrow
        LifecycleEffect(
            onStarted = {
                viewModel.setBottomBarVisible(true)
            }
        )
        LaunchedEffect(id){
            viewModel.loadData(id)
        }
        CustomScaffold(
            topBar = {
                if(state.isProducts){
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
                        Box(
                            Modifier
                                .align(Alignment.TopCenter)
                                .height(46.dp)
                                .fillMaxWidth()
                                .background(MaterialTheme.colorScheme.background)
                        ) {
                            Row(
                                Modifier
                                    .fillMaxSize()
                                    .padding(horizontal = 20.dp),
                                verticalAlignment = Alignment.CenterVertically,
                                horizontalArrangement = Arrangement.SpaceBetween
                            ) {
                                IconButton(
                                    onClick = {
                                        viewModel.updateIsProduct(false)
                                        if(state.subcategoryList.children.isEmpty()){
                                            navigator.pop()
                                        }
                                              },
                                ) {
                                    Icon(
                                        painter = painterResource(VestaResourceImages.button_back),
                                        contentDescription = "",
                                        modifier = Modifier.size(24.dp)
                                    )
                                }
                                Text(
                                    text = VestaResourceStrings.catalog,
                                    fontSize = 16.sp,
                                    fontWeight = FontWeight.Medium,
                                    lineHeight = 19.5.sp
                                )
                                IconButton(
                                    onClick = { },
                                ) {
                                    Icon(
                                        painter = painterResource(VestaResourceImages.icon_filter),
                                        contentDescription = "",
                                        modifier = Modifier.size(24.dp)
                                    )
                                }
                            }
                        }
                    }
                }
                else{
                    HeaderWithButtonBack(
                        onClick = {navigator.pop()},
                        text = VestaResourceStrings.catalog
                    )
                }
            }
        ) {
            Column(Modifier.fillMaxHeight()) {

                if (viewModel.status.collectAsState().value || SubcategoryState.InitState == state) {
                    CustomCircularProgressIndicator()
                } else {
                    LazyVerticalGrid(
                        columns = GridCells.Fixed(2),
                        modifier = Modifier
                            .fillMaxWidth()
                            .padding(horizontal = 15.dp)
                            .background(MaterialTheme.colorScheme.background),
                        verticalArrangement = Arrangement.spacedBy(8.dp),
                        horizontalArrangement = Arrangement.spacedBy(8.dp)
                    ) {
                        if (!state.isProducts) {
                            item(span = { GridItemSpan(2) }) {
                                Surface(
                                    Modifier
                                        .fillMaxWidth()
                                        .height(75.dp)
                                        .padding(horizontal = 5.dp, vertical = 10.dp),
                                    shape = RoundedCornerShape(25.dp),
                                    shadowElevation = 5.dp,
                                    color = MaterialTheme.colorScheme.secondaryContainer
                                ) {
                                    Row(
                                        Modifier
                                            .fillMaxSize()
                                            .background(MaterialTheme.colorScheme.background)
                                            .clickable { viewModel.updateIsProduct(true) },
                                        horizontalArrangement = Arrangement.Center,
                                        verticalAlignment = Alignment.CenterVertically
                                    ) {
                                        Icon(
                                            painterResource(VestaResourceImages.icon_big_cart),
                                            contentDescription = "",
                                            tint = MaterialTheme.colorScheme.primary
                                        )
                                        Spacer(Modifier.width(15.dp))
                                        Text(
                                            text = VestaResourceStrings.all_products,
                                            fontSize = 16.sp,
                                            fontWeight = FontWeight.SemiBold,
                                            color = MaterialTheme.colorScheme.onSecondary

                                        )
                                    }
                                }
                            }

                            //субкатегории
                            items(state.subcategoryList.children) { subcategory ->
                                SubcategoryCard(
                                    image = subcategory.image,
                                    name = subcategory.name,
                                    onClick = { navigator.push(SubcategoryScreen(subcategory.categoryId)) }
                                )
                            }
                        } else {
                            //продукты
                            items(state.productList) { product ->
                                ProductCard(
                                    image = product.image,
                                    name = product.nameKorr,
                                    price = product.price,
                                    stickers = product.octStickers.specialStickerData,
                                    onClick = {navigator.push(ProductScreen(product.productId))}
                                )
                            }
                            if (state.productList.isEmpty()) {
                                item(span = { GridItemSpan(2) }) {
                                    Row(
                                        Modifier
                                            .fillMaxWidth()
                                            .padding(20.dp),
                                        verticalAlignment = Alignment.CenterVertically,
                                        horizontalArrangement = Arrangement.Center
                                    ) {

                                        Text(
                                            text = VestaResourceStrings.sold,
                                            fontSize = 16.sp,
                                            fontWeight = FontWeight.Medium,
                                            lineHeight = 19.5.sp
                                        )

                                    }
                                }
                            }
                        }
                    }

                }
            }
        }
    }
}

@Composable
private fun SubcategoryCard(
    modifier: Modifier = Modifier,
    image: String,
    name: String,
    onClick: ()-> Unit
){
    Surface(
        Modifier
            .fillMaxWidth()
            .height(160.dp)
            .padding(5.dp),
        shape = RoundedCornerShape(25.dp),
        shadowElevation = 5.dp) {

        Column(
            Modifier
                .fillMaxSize()
                .clip(RoundedCornerShape(15.dp))
                .background(MaterialTheme.colorScheme.background)
                .clickable(onClick = onClick),
            verticalArrangement = Arrangement.Top,
            horizontalAlignment = Alignment.CenterHorizontally) {

            Box(Modifier.fillMaxWidth().height(100.dp).padding(vertical = 10.dp, horizontal = 10.dp)) {
                CustomAsyncImage(image, modifier = Modifier.fillMaxSize())
            }

            Text(
                text = name,
                fontSize = 12.sp,
                softWrap = true,
                maxLines = 3,
                textAlign = TextAlign.Center,
                modifier = Modifier.padding(horizontal = 10.dp)
            )

        }
    }
}
