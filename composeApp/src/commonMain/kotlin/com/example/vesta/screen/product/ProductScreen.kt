package com.example.vesta.screen.product

import androidx.compose.foundation.ExperimentalFoundationApi
import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.border
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
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.foundation.verticalScroll
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.runtime.collectAsState
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.rememberCoroutineScope
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.alpha
import androidx.compose.ui.draw.clip
import androidx.compose.ui.draw.rotate
import androidx.compose.ui.draw.shadow
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.layout.onGloballyPositioned
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import cafe.adriel.voyager.core.lifecycle.LifecycleEffect
import cafe.adriel.voyager.core.model.rememberScreenModel
import cafe.adriel.voyager.core.screen.Screen
import cafe.adriel.voyager.navigator.LocalNavigator
import cafe.adriel.voyager.navigator.currentOrThrow
import com.example.vesta.components.CustomButton
import com.example.vesta.components.CustomCircularProgressIndicator
import com.example.vesta.components.CustomFlexAsyncImage
import com.example.vesta.components.CustomScaffold
import com.example.vesta.components.HorizontalLine
import com.example.vesta.components.VerticalLine
import com.example.vesta.data.models.product.ImageUi
import com.example.vesta.ext.QuantityToStore
import com.example.vesta.ext.cleanHtml
import com.example.vesta.ext.clickableBlank
import com.example.vesta.images.VestaResourceImages
import com.example.vesta.screen.tabs.HomeTab
import com.example.vesta.strings.VestaResourceStrings
import io.github.skeptick.libres.compose.painterResource
import kotlinx.coroutines.delay
import kotlinx.coroutines.launch

class ProductScreen(private val id: Int): Screen{
    @Composable
    override fun Content() {
        val viewModel = rememberScreenModel { ProductViewModel() }
        val state by viewModel.stateFlow.collectAsState()
        val navigator = LocalNavigator.currentOrThrow

        LifecycleEffect(
            onStarted = {
                viewModel.setBottomBarVisible(false)
            }
        )

        LaunchedEffect(viewModel){
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
                        horizontalArrangement = Arrangement.SpaceBetween
                    ) {
                        Box{
                            Spacer(modifier = Modifier.width(20.dp))
                            IconButton(
                                onClick = { navigator.pop() },
                            ) {
                                Icon(
                                    painter = painterResource(VestaResourceImages.button_back),
                                    contentDescription = "",
                                    modifier = Modifier.size(24.dp)
                                )
                            }
                        }

                        Box{

                        }
                    }
                }
            },
            // добавление в корзину. пока без функционала
            bottomBar = {
                Box(
                    modifier = Modifier
                        .fillMaxWidth().height(85.dp).background(Color.Transparent)
                        .shadow(
                            5.dp,
                            shape = MaterialTheme.shapes.medium,
                            ambientColor = Color(0x1FF00000),
                            clip = false,
                        )
                ) {
                    Row(
                        Modifier
                            .align(Alignment.BottomCenter)
                            .fillMaxWidth()
                            .height(70.dp)
                            .background(MaterialTheme.colorScheme.background),
                        verticalAlignment = Alignment.CenterVertically,
                        horizontalArrangement = Arrangement.SpaceBetween
                    ) {
                        CustomButton(
                            onClick = {},
                            modifier = Modifier.padding(start = 20.dp, end = 15.dp).fillMaxWidth(0.5f),
                            text = VestaResourceStrings.buy_now,
                            textColor = MaterialTheme.colorScheme.primary,
                            background = MaterialTheme.colorScheme.onSecondaryContainer
                        )

                        CustomButton(
                            onClick = {},
                            modifier = Modifier.padding(start = 15.dp , end = 20.dp),
                            text = VestaResourceStrings.to_cart,
                            textColor = MaterialTheme.colorScheme.background,
                            background = MaterialTheme.colorScheme.primary
                        )
                    }
                }
            }
        ) {
            if(viewModel.status.collectAsState().value || ProductState.InitState==state){
                CustomCircularProgressIndicator()
            } else {
                Column(Modifier
                    .fillMaxSize()
                    .verticalScroll(rememberScrollState())) {

                    Column(Modifier
                        .padding(horizontal = 20.dp, vertical = 5.dp)) {
                        Text(
                            text = state.productData.description.nameKorr,
                            fontSize = 16.sp,
                            fontWeight = FontWeight.Bold,
                            softWrap = true,
                        )

                        ImageViewer(
                            images = state.productData.images,
                            sale = "${if(state.productData.multistoreProduct.priceM!=0)state.productData.multistoreProduct.priceM else state.productData.multistoreProduct.price} ${VestaResourceStrings.rub}"
                        )

                        Text(
                            text = VestaResourceStrings.main_features,
                            fontSize = 14.sp,
                            fontWeight = FontWeight.Bold,
                            modifier = Modifier.padding(bottom = 5.dp, top = 15.dp)
                        )
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

                        //блок с информацией открывающийся/закрывающийся
                        ExpandPanel(
                            name = VestaResourceStrings.description,
                        ){
                            Column(Modifier.padding(top = 10.dp)){
                                Text(
                                    text = state.productData.description.description.cleanHtml(),
                                    fontSize = 12.sp,
                                    fontWeight = FontWeight.Normal
                                )

                                for(image in viewModel.extractImageLinks(state.productData.description.description)){
                                   CustomFlexAsyncImage(
                                       image,
                                       modifier = Modifier.fillMaxWidth(),
                                       contentScale = ContentScale.FillWidth
                                   )
                                    Spacer(Modifier.height(10.dp))
                               }
                            }
                        }
                        ExpandPanel(
                            name = VestaResourceStrings.specifications,
                        ){
                            Column(Modifier.padding(top = 10.dp)){
                                for(attribute in state.productData.attributes)
                                DetailsRow(
                                    title = attribute.attribute.description.name + VestaResourceStrings.colon,
                                    text = attribute.text
                                )
                            }
                        }
                        ExpandPanel(
                            name = VestaResourceStrings.reviews,
                        ){

                        }
                        ExpandPanel(
                            name = VestaResourceStrings.availability_in_store,
                        ){

                        }
                    }
                }
            }
        }
    }
}

@Composable
private fun DetailsRow(title: String, text: String){
    if(text.isNotEmpty()&& text != "?"){
        Row(Modifier.fillMaxWidth().padding(vertical = 3.dp)){
            Text(
                text = title,
                fontSize = 12.sp,
                fontWeight = FontWeight.Normal,
                modifier = Modifier.padding(end = 5.dp)
            )
            Text(
                text = text,
                fontSize = 12.sp,
                fontWeight = FontWeight.Normal,
                modifier = Modifier.padding(end = 5.dp)
            )
        }
    }
}

@OptIn(ExperimentalFoundationApi::class)
@Composable
private fun ImageViewer(
    images: List<ImageUi>,
    sale: String
) {
    val pagerState = rememberPagerState(pageCount = { images.size })
    Surface(
        Modifier
            .fillMaxWidth()
            .height(220.dp)
            .padding(start = 5.dp, end = 5.dp, top = 15.dp, bottom = 5.dp),
        shape = RoundedCornerShape(25.dp),
        shadowElevation = 5.dp) {

        Box(modifier = Modifier.fillMaxWidth()) {
            Column(
                modifier = Modifier.fillMaxWidth().padding(bottom = 5.dp, top = 10.dp, start = 20.dp, end = 20.dp),
                horizontalAlignment = Alignment.CenterHorizontally,
                verticalArrangement = Arrangement.Center
            ) {
                HorizontalPager(
                    state = pagerState,
                    modifier = Modifier.fillMaxWidth()
                ) { imageIndex ->
                    println(images[imageIndex].image)
                    CustomFlexAsyncImage(
                        image = images[imageIndex].image,
                        modifier = Modifier.height(130.dp),
                        contentScale = ContentScale.FillHeight)
                }
                Spacer(Modifier.height(5.dp))
                IndicatorDots(pagerState = pagerState, imageCount = images.size)

                HorizontalLine(
                    modifier = Modifier.padding(bottom = 7.dp, top = 5.dp)
                )

                Row(Modifier.fillMaxWidth()){
                    Spacer(Modifier.width(10.dp))
                    Text(
                        text = sale,
                        fontSize = 14.sp,
                        fontWeight = FontWeight.Bold,
                        color = MaterialTheme.colorScheme.primary
                    )
                }
            }
        }
    }
}

@OptIn(ExperimentalFoundationApi::class)
@Composable
private fun IndicatorDots(
    pagerState: PagerState,
    modifier: Modifier = Modifier,
    imageCount: Int
) {
    Row(
        modifier = modifier.padding(5.dp),
        horizontalArrangement = Arrangement.Center,
        verticalAlignment = Alignment.CenterVertically
    ) {
        repeat(imageCount) { index ->
            val background = if(index == pagerState.currentPage) MaterialTheme.colorScheme.primary else MaterialTheme.colorScheme.onSecondaryContainer
            Box(
                modifier = Modifier
                    .size(5.dp)
                    .clip(CircleShape)
                    .background(background)
            )
            Spacer(modifier = Modifier.width(10.dp))
        }
    }
}

@Composable
private fun ExpandPanel(
    name: String,
    content: @Composable () -> Unit
){
    var isOpen by remember{mutableStateOf(false)}
    val rotation = if(isOpen) 90f else 0f
    Column(
        Modifier
            .fillMaxWidth()
            .padding(top = 8.dp)
    ) {
        HorizontalLine(Modifier.padding(bottom = 8.dp))
        Row(Modifier
            .fillMaxWidth()
            .clickableBlank { isOpen = !isOpen },
            horizontalArrangement = Arrangement.SpaceBetween){
            Text(
                text = name,
                fontSize = 14.sp,
                fontWeight = FontWeight.Bold,
            )
            Icon(
                modifier = Modifier.rotate(rotation),
                painter = painterResource(VestaResourceImages.icon_arrow),
                contentDescription = "",
            )
        }

        if(isOpen){
            content()
        }
    }
}