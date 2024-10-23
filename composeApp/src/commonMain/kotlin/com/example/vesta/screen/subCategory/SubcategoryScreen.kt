package com.example.vesta.screen.subCategory

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxHeight
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.grid.GridCells
import androidx.compose.foundation.lazy.grid.GridItemSpan
import androidx.compose.foundation.lazy.grid.LazyGridScope
import androidx.compose.foundation.lazy.grid.LazyVerticalGrid
import androidx.compose.foundation.lazy.grid.items
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.runtime.collectAsState
import androidx.compose.runtime.getValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.shadow
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import cafe.adriel.voyager.core.model.rememberScreenModel
import cafe.adriel.voyager.core.screen.Screen
import cafe.adriel.voyager.core.screen.ScreenKey
import cafe.adriel.voyager.navigator.LocalNavigator
import cafe.adriel.voyager.navigator.currentOrThrow
import com.example.vesta.components.CustomButton
import com.example.vesta.components.CustomCircularProgressIndicator
import com.example.vesta.components.CustomScaffold
import com.example.vesta.components.FilterButton
import com.example.vesta.components.ProductCard
import com.example.vesta.components.SubcategorySquare
import com.example.vesta.screen.category.CategoryScreen
import com.example.vesta.screen.product.ProductScreen
import com.example.vesta.strings.VestaResourceStrings

class SubcategoryScreen(private val id: Int): Screen {
    override val key: ScreenKey = id.toString()
    @Composable
    override fun Content() {

        val viewModel = rememberScreenModel { SubcategoryViewModel() }
        val state by viewModel.stateFlow.collectAsState()
        val navigator = LocalNavigator.currentOrThrow

        LaunchedEffect(id){
            viewModel.loadData(id)
        }
        CustomScaffold(
            topBar = {
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
                        verticalAlignment = Alignment.CenterVertically,
                        horizontalArrangement = Arrangement.Center
                    ) {

                        Text(
                            text = VestaResourceStrings.catalog,
                            fontSize = 16.sp,
                            fontWeight = FontWeight.Medium,
                            lineHeight = 19.5.sp
                        )
                    }
                }
            }
        ) {
            Column(Modifier.fillMaxHeight()) {

                if(viewModel.status.collectAsState().value || SubcategoryState.InitState==state){
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
                        item(span = { GridItemSpan(2)}){
                            CustomButton(
                                text = VestaResourceStrings.filter,
                                onClick = {},
                                modifier = Modifier.padding(start = 15.dp, end = 15.dp, top = 15.dp))
                        }

                        //субкатегории
                        items(state.subcategoryList.children) { subcategory ->
                            SubcategorySquare(
                                image = subcategory.image,
                                name = subcategory.description[0].name,
                                onClick = { navigator.push(SubcategoryScreen(subcategory.categoryId)) }
                            )
                        }

                        //сортировка
                        item(span = { GridItemSpan(2)}) {
                            Column(
                                Modifier.fillMaxWidth()
                                    .padding(start = 25.dp, end = 15.dp, top = 10.dp)
                            ) {
                                Text(
                                    text = VestaResourceStrings.sort,
                                    fontSize = 17.sp,
                                    fontWeight = FontWeight.Medium
                                )
                                Spacer(Modifier.height(5.dp))
                                Text(
                                    text = VestaResourceStrings.sort_ascending,
                                    fontSize = 17.sp,
                                    fontWeight = FontWeight.Medium
                                )
                                Spacer(Modifier.height(5.dp))
                                Text(
                                    text = VestaResourceStrings.sort_descending,
                                    fontSize = 17.sp,
                                    fontWeight = FontWeight.Medium
                                )
                            }
                        }

                        //продукты
                        items(state.productList, span = { GridItemSpan(2)}){ product->
                            ProductCard(
                                product = product,
                                onClick = {navigator.push(ProductScreen(product.productId))}
                            )
                        }
                    }
                }
            }
        }
    }
}