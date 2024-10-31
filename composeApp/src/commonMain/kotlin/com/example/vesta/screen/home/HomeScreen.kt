package com.example.vesta.screen.home

import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.safeContentPadding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.LazyRow
import androidx.compose.foundation.lazy.grid.GridCells
import androidx.compose.foundation.lazy.grid.GridItemSpan
import androidx.compose.foundation.lazy.grid.LazyVerticalGrid
import androidx.compose.foundation.lazy.grid.items
import androidx.compose.foundation.lazy.items
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.SegmentedButton
import androidx.compose.material3.SegmentedButtonColors
import androidx.compose.material3.SegmentedButtonDefaults
import androidx.compose.material3.SingleChoiceSegmentedButtonRow
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.runtime.collectAsState
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableIntStateOf
import androidx.compose.runtime.mutableStateListOf
import androidx.compose.runtime.remember
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.draw.shadow
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import cafe.adriel.voyager.core.model.rememberScreenModel
import cafe.adriel.voyager.core.screen.Screen
import cafe.adriel.voyager.navigator.LocalNavigator
import cafe.adriel.voyager.navigator.currentOrThrow
import com.example.vesta.components.CustomCircularProgressIndicator
import com.example.vesta.components.CustomFlexAsyncImage
import com.example.vesta.components.CustomScaffold
import com.example.vesta.components.ProductCardForMainScreen
import com.example.vesta.domain.modelsUI.info.BlogUi
import com.example.vesta.domain.modelsUI.info.MainBlogObjectDataUi
import com.example.vesta.domain.modelsUI.info.MainBlogObjectUi
import com.example.vesta.ext.clickableBlank
import com.example.vesta.images.VestaResourceImages
import com.example.vesta.platform.OpenPhone
import com.example.vesta.screen.mainTab.MainTabScreen
import com.example.vesta.screen.product.ProductScreen
import com.example.vesta.screen.sity.SityScreen
import com.example.vesta.screen.sity.SityViewModel
import com.example.vesta.screen.splash.SplashEvent
import com.example.vesta.screen.welcome.WelcomeScreen
import com.example.vesta.strings.VestaResourceStrings
import io.github.skeptick.libres.compose.painterResource

class HomeScreen: Screen {
    @OptIn(ExperimentalMaterial3Api::class)
    @Composable
    override fun Content() {

        val viewModel = rememberScreenModel { HomeViewModel() }
        val sityViewModel = rememberScreenModel { SityViewModel() }
        val state by viewModel.stateFlow.collectAsState()
        val navigator = LocalNavigator.currentOrThrow

        LaunchedEffect(viewModel){
            viewModel.loadData()
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
                            text = VestaResourceStrings.home,
                            fontSize = 16.sp,
                            fontWeight = FontWeight.Medium,
                            lineHeight = 19.5.sp
                        )
                    }
                }
            }
        ) {
            if(viewModel.status.collectAsState().value && HomeState.InitState==state){
                CustomCircularProgressIndicator()
            } else {

                if(state.isOpenPhone){
                    OpenPhone(state.phone)
                }
                if(state.isOpenSity){
                    SityScreen(sityViewModel) { viewModel.openSity() }
                }

                Box(Modifier.fillMaxSize()) {

                    LazyVerticalGrid(
                        modifier = Modifier.fillMaxSize(),
                        columns = GridCells.Fixed(2),
                        contentPadding = PaddingValues(vertical = 10.dp)) {

                        //блок со слайдером акций
                        item(span = { GridItemSpan(2) }) {
                            LazySliderRow(data = state.stockData)
                        }

                        //блок с актуальными продуктами
                        items(state.productList, key = {it.hashCode()}){ product ->
                            ProductCardForMainScreen(product, onClick = {navigator.push(ProductScreen(product.productId))})
                        }

                        //блок с новостями, акциями, новинками
                        item(span = { GridItemSpan(2) }) {
                            Column(Modifier.padding(top = 15.dp, bottom = 10.dp)) {
                                Row(Modifier.fillMaxWidth(),
                                    horizontalArrangement = Arrangement.Center){
                                    SingleChoiceSegmentedButtonRow {
                                        state.pages.forEachIndexed { index, choice ->

                                            SegmentedButton(
                                                selected = state.selectedPage == index,
                                                onClick = {viewModel.updatePage(index) },
                                                colors = SegmentedButtonDefaults.colors(
                                                    activeBorderColor = MaterialTheme.colorScheme.primary,
                                                    activeContainerColor = MaterialTheme.colorScheme.primary,
                                                    activeContentColor = MaterialTheme.colorScheme.background,
                                                    inactiveContentColor =  MaterialTheme.colorScheme.onSecondary,
                                                    inactiveBorderColor =  MaterialTheme.colorScheme.primary,
                                                    inactiveContainerColor =  MaterialTheme.colorScheme.background,
                                                ),
                                                shape = SegmentedButtonDefaults.itemShape(
                                                    index = index,
                                                    count = state.pages.count()
                                                )
                                            ) {
                                               Text(choice)
                                            }
                                        }
                                    }
                                }

                                when(state.selectedPage){
                                    0 -> { BlogObjectBox(state.newsData)}
                                    1 -> { BlogObjectBox(state.stockData)}
                                    2 -> { BlogObjectBox(state.newProductsData)}
                                }
                            }
                        }
                    }

                    //кнопки
                    Box(Modifier
                        .fillMaxWidth()
                        .align(Alignment.BottomCenter)
                        .padding(horizontal = 30.dp, vertical = 15.dp)){

                        Box(
                            modifier = Modifier
                                .align(Alignment.BottomStart)
                                .size(40.dp)
                                .clip(CircleShape)
                                .background(MaterialTheme.colorScheme.primary, CircleShape)
                                .clickable { viewModel.openSity() }
                        ){
                            Icon(
                                painterResource(VestaResourceImages.icon_geolocation),
                                contentDescription = "",
                                tint = MaterialTheme.colorScheme.background,
                                modifier = Modifier.align(Alignment.Center)
                            )
                        }

                        Box(
                            modifier = Modifier
                                .align(Alignment.BottomEnd)
                                .size(40.dp)
                                .clip(CircleShape)
                                .background(MaterialTheme.colorScheme.primary, CircleShape)
                                .clickable {  viewModel.openPhone()}
                        ){
                            Icon(
                                painterResource(VestaResourceImages.icon_phone),
                                contentDescription = "",
                                tint = MaterialTheme.colorScheme.background,
                                modifier = Modifier.align(Alignment.Center)
                            )
                        }
                    }
                }
            }
        }
    }
}

@Composable
private fun LazySliderRow(
    data: MainBlogObjectUi,
    onClick: ()-> Unit = {}
){
    Column(
        Modifier
            .padding(top=10.dp, bottom = 10.dp)
            .clip(RoundedCornerShape(15.dp))
            .clickableBlank { onClick() }
    ) {
        Text(
            text = data.name,
            fontSize = 16.sp,
            fontWeight = FontWeight.Bold,
            lineHeight = 19.5.sp,
            modifier = Modifier.padding(bottom = 10.dp, start = 20.dp)
        )

        LazyRow(contentPadding = PaddingValues(horizontal = 20.dp)) {
            items(data.mainBlogObjectData.blogs) { blog ->
                CustomFlexAsyncImage(
                    image = blog.blogarticleImage,
                    modifier = Modifier
                        .width(110.dp)
                        .height(150.dp)
                        .clip(RoundedCornerShape(15.dp)),
                    contentScale = ContentScale.Crop
                )
                Spacer(Modifier.width(10.dp))
            }
        }
    }
}

@Composable
private fun BlogObjectBox(
    data: MainBlogObjectUi,
    onClick: ()-> Unit = {}
){
    Column(
        Modifier
            .padding(top = 10.dp, bottom = 10.dp)
            .clip(RoundedCornerShape(15.dp))
            .clickableBlank { onClick() }
    ) {
        Text(
            text = data.name,
            fontSize = 16.sp,
            fontWeight = FontWeight.Bold,
            lineHeight = 19.5.sp,
            modifier = Modifier.padding(bottom = 20.dp, start = 20.dp)
        )

        for(blog in data.mainBlogObjectData.blogs){
            CustomFlexAsyncImage(
                image = blog.blogarticleImage,
                modifier = Modifier
                    .fillMaxWidth()
                    .clip(RoundedCornerShape(15.dp)),
                contentScale = ContentScale.FillWidth
            )
            Text(
                text = blog.blogarticleName,
                fontSize = 16.sp,
                fontWeight = FontWeight.Bold,
                lineHeight = 19.5.sp,
                modifier = Modifier.padding(bottom = 10.dp, start = 20.dp, top = 10.dp)
            )
            Text(
                text = blog.blogarticleDescription,
                fontSize = 15.sp,
                fontWeight = FontWeight.Normal,
                lineHeight = 19.5.sp,
                maxLines = 5,
                modifier = Modifier.padding(bottom = 10.dp, start = 20.dp)
            )
        }
    }
}

