package com.example.vesta.screen.product

import androidx.compose.foundation.ExperimentalFoundationApi
import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.defaultMinSize
import androidx.compose.foundation.layout.fillMaxHeight
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.lazy.LazyRow
import androidx.compose.foundation.lazy.items
import androidx.compose.foundation.pager.HorizontalPager
import androidx.compose.foundation.pager.PagerState
import androidx.compose.foundation.pager.rememberPagerState
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.foundation.verticalScroll
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.runtime.collectAsState
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.rememberCoroutineScope
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.alpha
import androidx.compose.ui.draw.clip
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.layout.onGloballyPositioned
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import cafe.adriel.voyager.core.model.rememberScreenModel
import cafe.adriel.voyager.core.screen.Screen
import cafe.adriel.voyager.navigator.LocalNavigator
import cafe.adriel.voyager.navigator.currentOrThrow
import com.example.vesta.components.CustomAsyncImage
import com.example.vesta.components.CustomCircularProgressIndicator
import com.example.vesta.components.CustomFlexAsyncImage
import com.example.vesta.components.CustomScaffold
import com.example.vesta.components.VerticalLine
import com.example.vesta.data.models.product.ImageUi
import com.example.vesta.ext.QuantityToStore
import com.example.vesta.screen.subCategory.SubcategoryViewModel
import com.example.vesta.strings.VestaResourceStrings
import io.github.skeptick.libres.compose.painterResource
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.launch

class ProductScreen(private val id: Int): Screen{
    @Composable
    override fun Content() {
        val viewModel = rememberScreenModel { ProductViewModel() }
        val state by viewModel.stateFlow.collectAsState()
        val navigator = LocalNavigator.currentOrThrow

        LaunchedEffect(viewModel){
            viewModel.loadData(id)
        }

        CustomScaffold(
            topBar = {

            }
        ) {
            if(viewModel.status.collectAsState().value || ProductState.InitState==state){
                CustomCircularProgressIndicator()
            } else {
                Column(Modifier
                    .fillMaxSize()
                    .verticalScroll(rememberScrollState())) {

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
                        ImageViewer(state.productData.images)

                        Column(Modifier.fillMaxWidth().padding(horizontal = 20.dp, vertical = 15.dp)) {
                            DetailsRow(
                                title = VestaResourceStrings.maufacturer,
                                text = state.productData.manufacturer.name
                            )
                            DetailsRow(
                                title = VestaResourceStrings.country,
                                text =  state.productData.isbn
                            )
                            DetailsRow(
                                title = VestaResourceStrings.guarantee,
                                text = VestaResourceStrings.service
                            )
                            DetailsRow(
                                title = VestaResourceStrings.article,
                                text = state.productData.model
                            )
                            DetailsRow(
                                title = VestaResourceStrings.availability,
                                text = state.productData.multistoreProduct.quantity.QuantityToStore()
                            )
                        }
                    }
                }
            }
        }
    }
}

@Composable
private fun DetailsRow(title: String, text: String){
    if(text.isNotEmpty()){
        Row(Modifier.fillMaxWidth().padding(vertical = 3.dp)){
            Text(
                text = title,
                fontSize = 19.sp,
                fontWeight = FontWeight.Medium,
                modifier = Modifier.padding(end = 5.dp)
            )
            Text(
                text = text,
                fontSize = 19.sp,
                fontWeight = FontWeight.Medium,
                modifier = Modifier.padding(end = 5.dp)
            )
        }
    }
}

@OptIn(ExperimentalFoundationApi::class)
@Composable
private fun ImageViewer(
    images: List<ImageUi>
) {
    val pagerState = rememberPagerState(pageCount = { images.size })

    Box(modifier = Modifier.fillMaxWidth()) {
        Column(
            modifier = Modifier.fillMaxWidth(),
            horizontalAlignment = Alignment.CenterHorizontally
        ) {
            HorizontalPager(
                state = pagerState,
                modifier = Modifier
                    .fillMaxWidth()
                    .padding(horizontal = 25.dp)
            ) { imageIndex ->
                CustomFlexAsyncImage(image = images[imageIndex].image)
            }
            Spacer(Modifier.height(15.dp))
            IndicatorDots(pagerState = pagerState, images = images)
        }
    }
}

@OptIn(ExperimentalFoundationApi::class)
@Composable
private fun IndicatorDots(
    pagerState: PagerState,
    modifier: Modifier = Modifier,
    images: List<ImageUi>
) {
    val coroutineScope = rememberCoroutineScope()
    LazyRow(
        modifier = modifier,
        horizontalArrangement = Arrangement.Center,
        verticalAlignment = Alignment.CenterVertically
    ) {
        items(images) { image ->
            CustomFlexAsyncImage(
                image = image.image,
                modifier = Modifier
                    .height(100.dp)
                    .clickable {
                        val index = images.indexOf(image)
                        if (index != -1) {
                            coroutineScope.launch {
                                pagerState.animateScrollToPage(index)
                            }
                        }
                    },
                contentScale = ContentScale.FillHeight
            )
            Spacer(modifier = Modifier.width(10.dp))
        }
    }
}