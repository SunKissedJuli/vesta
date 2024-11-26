package com.example.vesta.screen.category

import androidx.compose.foundation.background
import androidx.compose.foundation.border
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.MaterialTheme
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
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import cafe.adriel.voyager.core.lifecycle.LifecycleEffect
import cafe.adriel.voyager.core.model.rememberScreenModel
import cafe.adriel.voyager.core.screen.Screen
import cafe.adriel.voyager.navigator.LocalNavigator
import cafe.adriel.voyager.navigator.currentOrThrow
import com.example.vesta.components.CustomAsyncImage
import com.example.vesta.components.CustomCircularProgressIndicator
import com.example.vesta.components.CustomScaffold
import com.example.vesta.components.HorizontalLine
import com.example.vesta.components.SearchTextField
import com.example.vesta.ext.clickableBlank
import com.example.vesta.screen.subCategory.SubcategoryScreen
import com.example.vesta.strings.VestaResourceStrings

class CategoryScreen: Screen {
    @Composable
    override fun Content() {
        val viewModel = rememberScreenModel { CategoryViewModel() }
        val state by viewModel.stateFlow.collectAsState()
        val navigator = LocalNavigator.currentOrThrow
        LifecycleEffect(
            onStarted = {
                viewModel.setBottomBarVisible(true)
            }
        )

        LaunchedEffect(viewModel){
            viewModel.loadData()
        }

            CustomScaffold(
                topBar = {
                    Box(
                        modifier = Modifier
                            .fillMaxWidth().height(105.dp).background(Color.Transparent)
                            .shadow(
                                5.dp,
                                shape = MaterialTheme.shapes.medium,
                                ambientColor = Color(0x1FF00000),
                                clip = false,
                            )
                    ) {
                        Column(Modifier
                            .fillMaxWidth()
                            .height(100.dp)
                            .background(MaterialTheme.colorScheme.background)
                            .align(Alignment.TopCenter),
                            verticalArrangement = Arrangement.Center) {
                            Row(
                                Modifier
                                    .fillMaxWidth()
                                    .height(35.dp)
                                    .padding(top=5.dp)
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
                            Spacer(Modifier.height(10.dp))

                            Row(Modifier
                                .fillMaxWidth()
                                .height(40.dp)
                                .padding(start = 20.dp, end = 20.dp)
                                .clip(RoundedCornerShape(50.dp))
                                .border(1.dp, MaterialTheme.colorScheme.secondaryContainer, RoundedCornerShape(50.dp)),
                                verticalAlignment = Alignment.CenterVertically){
                                SearchTextField(
                                    state.searchString,
                                    {viewModel.updateSearchString(it)})
                            }
                            Spacer(Modifier.height(10.dp))
                        }
                    }
                }
            ) {
                if(viewModel.status.collectAsState().value && CategoryState.InitState==state){
                    CustomCircularProgressIndicator()
                } else{
                    LazyColumn(Modifier
                        .fillMaxSize()
                        .padding(horizontal = 15.dp)
                        .background(MaterialTheme.colorScheme.background)) {

                        items(state.categoryList){category ->
                            CategoryRow(
                                onClick = { navigator.push(SubcategoryScreen(category.categoryId))},
                                image = category.octImage,
                                name = category.name
                            )
                        }
                    }
                }
           }
    }
}

@Composable
fun CategoryRow(
    image: String,
    name: String,
    onClick: ()->Unit = {}
){
    Column {
        Row(Modifier
            .clickableBlank { onClick() }
            .fillMaxWidth()
            .padding(top = 5.dp, start = 10.dp, end = 10.dp, bottom = 5.dp),
            verticalAlignment = Alignment.CenterVertically) {

            CustomAsyncImage(image)
            Spacer(Modifier.width(10.dp))
            Text(
                name,
                fontSize = 14.sp,
                fontWeight = FontWeight.Medium
            )

        }
        HorizontalLine(
            modifier = Modifier.padding(bottom = 5.dp),
            background = MaterialTheme.colorScheme.secondaryContainer)
    }

}