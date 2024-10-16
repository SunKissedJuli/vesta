package com.example.vesta.screen.product

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.defaultMinSize
import androidx.compose.foundation.layout.fillMaxHeight
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.lazy.LazyRow
import androidx.compose.foundation.lazy.items
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.runtime.collectAsState
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.layout.onGloballyPositioned
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import cafe.adriel.voyager.core.model.rememberScreenModel
import cafe.adriel.voyager.core.screen.Screen
import cafe.adriel.voyager.navigator.LocalNavigator
import cafe.adriel.voyager.navigator.currentOrThrow
import com.example.vesta.components.CustomAsyncImage
import com.example.vesta.components.CustomCircularProgressIndicator
import com.example.vesta.components.CustomScaffold
import com.example.vesta.components.VerticalLine
import com.example.vesta.screen.subCategory.SubcategoryViewModel

class ProductScreen(private val id: Int): Screen{
    @Composable
    override fun Content() {
        val viewModel = rememberScreenModel { ProductViewModel() }
        val state by viewModel.stateFlow.collectAsState()
        val navigator = LocalNavigator.currentOrThrow

        LaunchedEffect(viewModel){
            println("лоад дата")
            viewModel.loadData(id)
        }

        CustomScaffold(
            topBar = {

            }
        ) {
            if(viewModel.status.collectAsState().value || ProductState.InitState==state){
               println("крутилка")
                CustomCircularProgressIndicator()
            } else {
                println("я сосу хуй")
                Column(Modifier
                    .fillMaxSize()) {

                    Column(Modifier
                        .fillMaxWidth()) {

                        //тут будет отображение прошлых запросов

                        Row(Modifier
                            .fillMaxWidth()
                            .padding(vertical = 20.dp, horizontal = 30.dp),
                            verticalAlignment = Alignment.CenterVertically){
                            VerticalLine(Modifier
                                .width(3.dp)
                                .height(100.dp)
                                .background(MaterialTheme.colorScheme.onTertiary)
                            )
                            Spacer(Modifier.width(15.dp))

                            Text(
                                text = state.productData.description[0].nameKorr,
                                fontSize = 25.sp,
                                fontWeight = FontWeight.Bold,
                                softWrap = true,
                            )
                        }
                    }
                    Column(Modifier
                        .fillMaxSize()
                        .padding(20.dp)
                        .background(MaterialTheme.colorScheme.background)) {
                        println( state.productData.image)
                        CustomAsyncImage(
                            image = state.productData.image,
                            contentScale = ContentScale.FillWidth,
                            modifier = Modifier.fillMaxWidth()
                                .defaultMinSize(minHeight = 250.dp))
                        LazyRow(Modifier.height(150.dp)) {
                            items(state.productData.images){image ->
                                CustomAsyncImage(
                                    image = image,
                                    modifier = Modifier.fillMaxHeight())
                            }
                        }
                    }
                }
            }
        }
    }

}