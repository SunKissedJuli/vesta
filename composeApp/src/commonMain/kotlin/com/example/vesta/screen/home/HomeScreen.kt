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
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.lazy.grid.GridCells
import androidx.compose.foundation.lazy.grid.GridItemSpan
import androidx.compose.foundation.lazy.grid.LazyVerticalGrid
import androidx.compose.foundation.lazy.grid.items
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Icon
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.SegmentedButton
import androidx.compose.material3.SegmentedButtonDefaults
import androidx.compose.material3.SingleChoiceSegmentedButtonRow
import androidx.compose.material3.Surface
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
import cafe.adriel.voyager.core.lifecycle.LifecycleEffect
import cafe.adriel.voyager.core.model.rememberScreenModel
import cafe.adriel.voyager.core.screen.Screen
import cafe.adriel.voyager.navigator.LocalNavigator
import cafe.adriel.voyager.navigator.currentOrThrow
import cafe.adriel.voyager.navigator.tab.LocalTabNavigator
import com.example.vesta.components.CustomAsyncImage
import com.example.vesta.components.CustomButton
import com.example.vesta.components.CustomCircularProgressIndicator
import com.example.vesta.components.CustomScaffold
import com.example.vesta.components.HeaderOneWord
import com.example.vesta.components.ProductCard
import com.example.vesta.images.VestaResourceImages
import com.example.vesta.platform.OpenPhone
import com.example.vesta.screen.product.ProductScreen
import com.example.vesta.screen.city.CityScreen
import com.example.vesta.screen.city.CityViewModel
import com.example.vesta.screen.newsDetails.NewsDetailsScreen
import com.example.vesta.screen.tabs.HomeTab
import com.example.vesta.strings.VestaResourceStrings
import io.github.skeptick.libres.compose.painterResource

class HomeScreen: Screen {
    @OptIn(ExperimentalMaterial3Api::class)
    @Composable
    override fun Content() {

        val viewModel = rememberScreenModel { HomeViewModel() }
        val cityViewModel = rememberScreenModel { CityViewModel() }
        val state by viewModel.stateFlow.collectAsState()
        val navigator = LocalNavigator.currentOrThrow
        val tabNavigator = LocalTabNavigator.current

        LifecycleEffect(
            onStarted = {
                tabNavigator.current = HomeTab
                viewModel.setBottomBarVisible(true)
            }
        )
        LaunchedEffect(viewModel){
            viewModel.loadData()
        }

        CustomScaffold(
            topBar = {
                HeaderOneWord(VestaResourceStrings.home)
            }
        ) {
            if(viewModel.status.collectAsState().value && HomeState.InitState==state){
                CustomCircularProgressIndicator()
            } else {

                if(state.isOpenPhone){
                    OpenPhone(state.phone)
                }
                if(state.isOpenSity){
                    CityScreen(cityViewModel) { viewModel.openSity() }
                }

                Box(Modifier.fillMaxSize()) {

                    LazyVerticalGrid(
                        modifier = Modifier.fillMaxSize().padding(horizontal = 15.dp),
                        columns = GridCells.Fixed(2),
                        contentPadding = PaddingValues(vertical = 10.dp)) {

                        item(span = { GridItemSpan(2) }) {

                            Row(Modifier.fillMaxWidth().padding(bottom = 10.dp, start = 5.dp, end = 5.dp),
                                horizontalArrangement = Arrangement.Center){

                                SingleChoiceSegmentedButtonRow {
                                    state.pages.forEachIndexed { index, choice ->
                                        SegmentedButton(
                                            icon = {},
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
                        }

                        when(state.selectedPage){
                            0 -> {
                                //блок с актуальными продуктами
                                items(state.productList, key = {it.hashCode()}){ product ->
                                    ProductCard(
                                        image = product.image,
                                        name = product.description.nameKorr,
                                        price = product.multistoreProduct.price,
                                        stickers = product.octStickers.specialStickerData,
                                        onClick = {navigator.push(ProductScreen(product.productId))}
                                    )
                                }
                            }
                            1 -> {
                                // новости
                                items(state.newsData.mainBlogObjectData, key = {it.hashCode()}){ news ->
                                    NewsItem(
                                        name = news.blogarticleName,
                                        icon = news.blogarticleImage,
                                        onClick = {navigator.push(NewsDetailsScreen(news.blogarticleId))}
                                    )
                                }

                            }
                            2 -> {
                                // акции
                                items(state.stockData.mainBlogObjectData, key = {it.hashCode()}){ stock ->
                                    NewsItem(
                                        name = stock.blogarticleName,
                                        icon = stock.blogarticleImage,
                                        onClick = {navigator.push(NewsDetailsScreen(stock.blogarticleId))}
                                    )
                                }
                            }
                            3 -> {
                                //новинки
                                items(state.newProductsData.mainBlogObjectData, key = {it.hashCode()}){ product ->
                                    NewsItem(
                                        name = product.blogarticleName,
                                        icon = product.blogarticleImage,
                                        onClick = {navigator.push(NewsDetailsScreen(product.blogarticleId))}
                                    )
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
private fun NewsItem(
    name: String,
    icon: String,
    onClick: ()-> Unit
){
    Surface(
        Modifier
            .fillMaxWidth()
            .height(260.dp)
            .padding(5.dp),
        shape = RoundedCornerShape(15.dp),
        shadowElevation = 5.dp) {

        Box(
            Modifier
                .fillMaxSize()
                .clip(RoundedCornerShape(15.dp))
                .background(MaterialTheme.colorScheme.background)
                .clickable(onClick = onClick),
        ){
            Column(
                Modifier
                    .fillMaxSize()
                    .padding(10.dp),
                verticalArrangement = Arrangement.Center) {

                CustomAsyncImage(
                    image = icon,
                    modifier = Modifier
                        .height(150.dp)
                        .fillMaxWidth(),
                    contentScale = ContentScale.FillHeight
                )
                Spacer(Modifier.height(10.dp))
                Text(
                    text = name,
                    fontSize = 14.sp,
                    fontWeight = FontWeight.Medium,
                    maxLines = 2
                )
                Spacer(Modifier.height(10.dp))
                CustomButton(
                    onClick = onClick,
                    text = VestaResourceStrings.more,
                    fontSize = 12.sp,
                    modifier = Modifier.height(25.dp)
                )
            }
        }
    }
}
//@Composable
//private fun LazySliderRow(
//    data: MainBlogObjectUi,
//    onClick: ()-> Unit = {}
//){
//    Column(
//        Modifier
//            .padding(top=10.dp, bottom = 10.dp)
//            .clip(RoundedCornerShape(15.dp))
//            .clickableBlank { onClick() }
//    ) {
//        Text(
//            text = data.name,
//            fontSize = 16.sp,
//            fontWeight = FontWeight.Bold,
//            lineHeight = 19.5.sp,
//            modifier = Modifier.padding(bottom = 10.dp, start = 20.dp)
//        )
//
//        LazyRow(contentPadding = PaddingValues(horizontal = 20.dp)) {
//            items(data.mainBlogObjectData.blogs) { blog ->
//                CustomFlexAsyncImage(
//                    image = blog.blogarticleImage,
//                    modifier = Modifier
//                        .width(110.dp)
//                        .height(150.dp)
//                        .clip(RoundedCornerShape(15.dp)),
//                    contentScale = ContentScale.Crop
//                )
//                Spacer(Modifier.width(10.dp))
//            }
//        }
//    }
//}

//@Composable
//private fun BlogObjectBox(
//    data: MainBlogObjectUi,
//    onClick: ()-> Unit = {}
//){
//    Column(
//        Modifier
//            .padding(top = 10.dp, bottom = 10.dp)
//            .clip(RoundedCornerShape(15.dp))
//            .clickableBlank { onClick() }
//    ) {
//        Text(
//            text = data.name,
//            fontSize = 16.sp,
//            fontWeight = FontWeight.Bold,
//            lineHeight = 19.5.sp,
//            modifier = Modifier.padding(bottom = 20.dp, start = 20.dp)
//        )
//
//        for(blog in data.mainBlogObjectData.blogs){
//            CustomFlexAsyncImage(
//                image = blog.blogarticleImage,
//                modifier = Modifier
//                    .fillMaxWidth()
//                    .clip(RoundedCornerShape(15.dp)),
//                contentScale = ContentScale.FillWidth
//            )
//            Text(
//                text = blog.blogarticleName,
//                fontSize = 16.sp,
//                fontWeight = FontWeight.Bold,
//                lineHeight = 19.5.sp,
//                modifier = Modifier.padding(bottom = 10.dp, start = 20.dp, top = 10.dp)
//            )
//            Text(
//                text = blog.blogarticleDescription,
//                fontSize = 15.sp,
//                fontWeight = FontWeight.Normal,
//                lineHeight = 19.5.sp,
//                maxLines = 5,
//                modifier = Modifier.padding(bottom = 10.dp, start = 20.dp)
//            )
//        }
//    }
//}

