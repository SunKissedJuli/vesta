package com.example.vesta.screen.subCategory

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
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
import androidx.compose.ui.Modifier
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import cafe.adriel.voyager.core.model.rememberScreenModel
import cafe.adriel.voyager.core.screen.Screen
import com.example.vesta.components.CustomScaffold
import com.example.vesta.components.FilterButton
import com.example.vesta.components.ProductCard
import com.example.vesta.components.SubcategorySquare
import com.example.vesta.strings.VestaResourceStrings

class SubcategoryScreen(val id: Int): Screen {
    @Composable
    override fun Content() {

        val viewModel = rememberScreenModel { SubcategoryViewModel() }
        val state by viewModel.stateFlow.collectAsState()

        LaunchedEffect(viewModel){
            viewModel.loadData(id)
        }
        CustomScaffold(
            topBar = {

            }
        ) {
            Column(Modifier.fillMaxHeight()) {
                Row(
                    Modifier
                        .fillMaxWidth()
                        .height(70.dp)){

                }

                if(viewModel.status.collectAsState().value){
                    //тут загрузка будет
                } else {

                    LazyVerticalGrid(
                        columns = GridCells.Fixed(2),
                        modifier = Modifier
                            .fillMaxWidth()
                            .padding(horizontal = 20.dp)
                            .background(MaterialTheme.colorScheme.background),
                        verticalArrangement = Arrangement.spacedBy(8.dp),
                        horizontalArrangement = Arrangement.spacedBy(8.dp)
                    ) {
                        item(span = { GridItemSpan(2)}){
                            FilterButton(
                                onClick = {},
                                modifier = Modifier.padding(start = 15.dp, end = 15.dp, top = 15.dp))
                        }

                        //субкатегории
                        items(state.subcategoryList.children) { subcategory ->
                            SubcategorySquare(
                                image = subcategory.image,
                                name = subcategory.description[0].name
                            )
                        }

                        //сортировка
                        item(span = { GridItemSpan(2)}) {
                            Column(
                                Modifier.fillMaxWidth()
                                    .padding(start = 15.dp, end = 15.dp, top = 10.dp)
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
                        items(state.productList.data, span = { GridItemSpan(2)}){ product->
                            ProductCard(product)
                        }

                    }
                }
            }
        }
    }
}