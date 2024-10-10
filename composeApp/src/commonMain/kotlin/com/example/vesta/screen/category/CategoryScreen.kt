package com.example.vesta.screen.category

import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.foundation.text.BasicTextField
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Search
import androidx.compose.material3.Icon
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.runtime.collectAsState
import androidx.compose.runtime.getValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import cafe.adriel.voyager.core.model.rememberScreenModel
import cafe.adriel.voyager.core.screen.Screen
import com.example.vesta.components.CategoryRow
import com.example.vesta.components.CustomScaffold
import com.example.vesta.components.SearchTextField
import com.example.vesta.domain.modelsUI.CategoryUi
import com.example.vesta.images.VestaResourceImages
import com.example.vesta.strings.VestaResourceStrings
import io.github.skeptick.libres.compose.painterResource

class CategoryScreen: Screen {
    @Composable
    override fun Content() {
        val viewModel = rememberScreenModel { CategoryViewModel() }
        val state by viewModel.stateFlow.collectAsState()

        LaunchedEffect(viewModel){
            viewModel.loadData()
        }

        if(viewModel.status.collectAsState().value){
            //тут типа загрузка
        } else{
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
                Box(Modifier
                    .fillMaxSize()
                    .background(MaterialTheme.colorScheme.tertiary)) {

                    LazyColumn(Modifier
                        .fillMaxSize()
                        .padding(horizontal = 15.dp)
                        .background(MaterialTheme.colorScheme.background)) {
                        items(state.topCategoryList){category ->
                            CategoryRow(
                                category.octImage,
                                category.description[0].name
                            )
                        }
                    }
                }
            }
        }
    }
}