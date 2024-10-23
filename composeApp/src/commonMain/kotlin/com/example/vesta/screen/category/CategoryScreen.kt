package com.example.vesta.screen.category

import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.MaterialTheme
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.runtime.collectAsState
import androidx.compose.runtime.getValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.unit.dp
import cafe.adriel.voyager.core.model.rememberScreenModel
import cafe.adriel.voyager.core.screen.Screen
import cafe.adriel.voyager.navigator.LocalNavigator
import cafe.adriel.voyager.navigator.currentOrThrow
import com.example.vesta.components.CategoryRow
import com.example.vesta.components.CustomCircularProgressIndicator
import com.example.vesta.components.CustomScaffold
import com.example.vesta.components.SearchTextField
import com.example.vesta.images.VestaResourceImages
import com.example.vesta.screen.subCategory.SubcategoryScreen
import com.example.vesta.screen.subCategory.SubcategoryState
import io.github.skeptick.libres.compose.painterResource

class CategoryScreen: Screen {
    @Composable
    override fun Content() {
        val viewModel = rememberScreenModel { CategoryViewModel() }
        val state by viewModel.stateFlow.collectAsState()
        val navigator = LocalNavigator.currentOrThrow
        LaunchedEffect(viewModel){
            viewModel.loadData()
        }


            CustomScaffold(
                topBar = {
                    Column(Modifier.fillMaxWidth()) {
                        Image(painterResource(VestaResourceImages.logo),
                            contentDescription = "",
                            modifier = Modifier
                                .fillMaxWidth()
                                .padding(horizontal = 30.dp, vertical = 10.dp),
                            contentScale = ContentScale.FillWidth)

                        Box(Modifier
                            .fillMaxWidth()
                            .height(66.dp)
                            .background(MaterialTheme.colorScheme.secondary)){
                            Row(Modifier
                                .fillMaxSize()
                                .align(Alignment.Center)
                                .padding(13.dp)
                                .clip(RoundedCornerShape(25.dp))
                                .background(MaterialTheme.colorScheme.background),
                                verticalAlignment = Alignment.CenterVertically){
                                    SearchTextField(
                                    state.searchString,
                                    {viewModel.updateSearchString(it)})
                            }
                        }
                    }
                }
            ) {
                if(viewModel.status.collectAsState().value && CategoryState.InitState==state){

                    CustomCircularProgressIndicator()
                } else{
                    Box(Modifier
                        .fillMaxSize()
                        .background(MaterialTheme.colorScheme.tertiary)) {

                        LazyColumn(Modifier
                            .fillMaxSize()
                            .padding(horizontal = 15.dp)
                            .background(MaterialTheme.colorScheme.background)) {
                                items(state.categoryList){category ->
                                    CategoryRow(
                                        onClick = { navigator.push(SubcategoryScreen(category.categoryId))},
                                        image = category.octImage,
                                      //  name = category.description[0].name
                                        name = category.name
                                    )
                                }
                        }
                    }
                }
           }
    }
}