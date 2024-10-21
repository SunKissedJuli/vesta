package com.example.vesta.screen.home

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.lazy.LazyRow
import androidx.compose.foundation.lazy.items
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
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
import com.example.vesta.images.VestaResourceImages
import com.example.vesta.screen.category.CategoryState
import com.example.vesta.screen.signIn.SignInViewModel
import com.example.vesta.strings.VestaResourceStrings
import io.github.skeptick.libres.compose.painterResource

class HomeScreen: Screen {
    @Composable
    override fun Content() {

        val viewModel = rememberScreenModel { HomeViewModel() }
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

                Box(Modifier.fillMaxSize()) {
                    Column(Modifier.fillMaxSize().padding(20.dp)) {
                        Text(
                            text = VestaResourceStrings.popular_product,
                            fontSize = 16.sp,
                            fontWeight = FontWeight.Bold,
                            lineHeight = 19.5.sp,
                            modifier = Modifier.padding(bottom = 20.dp)
                        )

                        LazyRow(Modifier) {
                            items(state.stockData) { stock ->
                                CustomFlexAsyncImage(
                                    image = stock.image,
                                    modifier = Modifier
                                        .width(150.dp)
                                        .height(80.dp)
                                        .clip(RoundedCornerShape(15.dp)),
                                    contentScale = ContentScale.Crop,

                                )
                                Spacer(Modifier.width(10.dp))
                            }
                        }

                        Spacer(Modifier.height(20.dp))
                        Text(
                            text = VestaResourceStrings.special_offers,
                            fontSize = 16.sp,
                            fontWeight = FontWeight.Bold,
                            lineHeight = 19.5.sp,
                            modifier = Modifier.padding(bottom = 20.dp)
                        )
                    }
                }
            }
        }
    }
}