package com.example.vesta.screen.subCategory

import androidx.compose.foundation.background
import androidx.compose.foundation.border
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxHeight
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.lazy.grid.GridCells
import androidx.compose.foundation.lazy.grid.GridItemSpan
import androidx.compose.foundation.lazy.grid.LazyVerticalGrid
import androidx.compose.foundation.lazy.grid.items
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.BottomSheetDefaults
import androidx.compose.material3.BottomSheetScaffold
import androidx.compose.material3.BottomSheetScaffoldState
import androidx.compose.material3.Button
import androidx.compose.material3.DrawerValue
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.ModalBottomSheet
import androidx.compose.material3.ModalDrawerSheet
import androidx.compose.material3.ModalNavigationDrawer
import androidx.compose.material3.SheetState
import androidx.compose.material3.SheetValue
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.material3.rememberBottomSheetScaffoldState
import androidx.compose.material3.rememberDrawerState
import androidx.compose.material3.rememberModalBottomSheetState
import androidx.compose.material3.rememberStandardBottomSheetState
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.runtime.collectAsState
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.rememberCoroutineScope
import androidx.compose.runtime.saveable.rememberSaveable
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.draw.rotate
import androidx.compose.ui.draw.shadow
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import cafe.adriel.voyager.core.lifecycle.LifecycleEffect
import cafe.adriel.voyager.core.model.rememberScreenModel
import cafe.adriel.voyager.core.screen.Screen
import cafe.adriel.voyager.core.screen.ScreenKey
import cafe.adriel.voyager.navigator.LocalNavigator
import cafe.adriel.voyager.navigator.currentOrThrow
import com.example.vesta.components.CustomAsyncImage
import com.example.vesta.components.CustomButton
import com.example.vesta.components.CustomCheckBox
import com.example.vesta.components.CustomCircularProgressIndicator
import com.example.vesta.components.CustomScaffold
import com.example.vesta.components.HeaderWithButtonBack
import com.example.vesta.components.HorizontalLine
import com.example.vesta.components.ProductCard
import com.example.vesta.ext.clickableBlank
import com.example.vesta.images.VestaResourceImages
import com.example.vesta.screen.product.ProductScreen
import com.example.vesta.strings.VestaResourceStrings
import io.github.skeptick.libres.compose.painterResource
import kotlinx.coroutines.launch

class SubcategoryScreen(private val id: Int): Screen {
    override val key: ScreenKey = id.toString()
    @OptIn(ExperimentalMaterial3Api::class)
    @Composable
    override fun Content() {

        val viewModel = rememberScreenModel { SubcategoryViewModel() }
        val state by viewModel.stateFlow.collectAsState()
        val navigator = LocalNavigator.currentOrThrow
        val bottomSheetState = rememberModalBottomSheetState(true)
        val scope = rememberCoroutineScope()

        LifecycleEffect(
            onStarted = {
                viewModel.setBottomBarVisible(true)
            }
        )

        LaunchedEffect(id){
            viewModel.loadData(id)
        }

        if(state.showFilter){
            ModalBottomSheet(
                onDismissRequest = { viewModel.updateShowFilter(false) },
                sheetState = bottomSheetState,
                containerColor = MaterialTheme.colorScheme.background
            ) {
                Column(Modifier.fillMaxWidth().padding(horizontal = 20.dp)) {
                    Text(
                        text = VestaResourceStrings.filters,
                        fontSize = 16.sp,
                        fontWeight = FontWeight.Bold,
                        lineHeight = 19.5.sp,
                        modifier = Modifier.align(Alignment.CenterHorizontally).padding(top = 10.dp)
                    )

                    ExpandPanel(
                        name = VestaResourceStrings.filter_subcategory,
                        content = {
                            Column {
                                for(subcategory in state.subcategoryList.children){
                                    CheckRow(
                                        checked = false,
                                        onCheckedChange = {},
                                        text = subcategory.name
                                    )
                                }
                            }
                        }
                    )

                    Text(
                        text = VestaResourceStrings.cost,
                        fontSize = 16.sp,
                        fontWeight = FontWeight.Medium,
                        lineHeight = 19.5.sp,
                        modifier = Modifier.align(Alignment.Start)
                    )
                    HorizontalLine(Modifier.padding(top = 10.dp, bottom = 15.dp))

                    Text(
                        text = VestaResourceStrings.available,
                        fontSize = 16.sp,
                        fontWeight = FontWeight.Medium,
                        lineHeight = 19.5.sp,
                        modifier = Modifier.align(Alignment.Start)
                    )
                    CheckRow(
                        checked = false,
                        text = VestaResourceStrings.filter_all,
                        onCheckedChange = {}
                    )
                    CheckRow(
                        checked = true,
                        text = VestaResourceStrings.filter_available,
                        onCheckedChange = {}
                    )
                    CheckRow(
                        checked = false,
                        text = VestaResourceStrings.filter_opt,
                        onCheckedChange = {}
                    )

                    ExpandPanel(
                        name = VestaResourceStrings.filter_maufacturer,
                        content = {}
                    )

                    CustomButton(
                        onClick = {},
                        text = VestaResourceStrings.apply_filter,
                        modifier = Modifier.height(50.dp)
                    )

                    CustomButton(
                        onClick = {},
                        text = VestaResourceStrings.clean,
                        modifier = Modifier.padding(top=15.dp, bottom = 10.dp).border(1.dp, MaterialTheme.colorScheme.primary, RoundedCornerShape(50.dp)),
                        background = MaterialTheme.colorScheme.background,
                        textColor = MaterialTheme.colorScheme.primary
                    )
                }
            }
        }

        CustomScaffold(
            topBar = {
                if (state.isProducts) {
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
                        Box(
                            Modifier
                                .align(Alignment.TopCenter)
                                .height(46.dp)
                                .fillMaxWidth()
                                .background(MaterialTheme.colorScheme.background)
                        ) {
                            Row(
                                Modifier
                                    .fillMaxSize()
                                    .padding(horizontal = 20.dp),
                                verticalAlignment = Alignment.CenterVertically,
                                horizontalArrangement = Arrangement.SpaceBetween
                            ) {
                                IconButton(
                                    onClick = {
                                        viewModel.updateIsProduct(false)
                                        if (state.subcategoryList.children.isEmpty()) {
                                            navigator.pop()
                                        }
                                    },
                                ) {
                                    Icon(
                                        painter = painterResource(VestaResourceImages.button_back),
                                        contentDescription = "",
                                        modifier = Modifier.size(24.dp)
                                    )
                                }
                                Text(
                                    text = VestaResourceStrings.catalog,
                                    fontSize = 16.sp,
                                    fontWeight = FontWeight.Medium,
                                    lineHeight = 19.5.sp
                                )
                                IconButton(
                                    onClick = {
                                    scope.launch { bottomSheetState.hide() }.invokeOnCompletion {
                                        if (!bottomSheetState.isVisible) {
                                            viewModel.updateShowFilter(true) }
                                        }
                                    }
                                ) {
                                    Icon(
                                        painter = painterResource(VestaResourceImages.icon_filter),
                                        contentDescription = "",
                                        modifier = Modifier.size(24.dp)
                                    )
                                }
                            }
                        }
                    }
                } else {
                    HeaderWithButtonBack(
                        onClick = { navigator.pop() },
                        text = VestaResourceStrings.catalog
                    )
                }
            }
        ) {

            if (viewModel.status.collectAsState().value || SubcategoryState.InitState == state) {
                CustomCircularProgressIndicator()
            } else {
                LazyVerticalGrid(
                    columns = GridCells.Fixed(2),
                    modifier = Modifier
                        .fillMaxWidth()
                        .padding(horizontal = 15.dp)
                        .background(MaterialTheme.colorScheme.background),
                    verticalArrangement = Arrangement.spacedBy(8.dp),
                    horizontalArrangement = Arrangement.spacedBy(8.dp)
                ) {
                    if (!state.isProducts) {
                        item(span = { GridItemSpan(2) }) {
                            Surface(
                                Modifier
                                    .fillMaxWidth()
                                    .height(75.dp)
                                    .padding(horizontal = 5.dp, vertical = 10.dp),
                                shape = RoundedCornerShape(25.dp),
                                shadowElevation = 5.dp,
                                color = MaterialTheme.colorScheme.secondaryContainer
                            ) {
                                Row(
                                    Modifier
                                        .fillMaxSize()
                                        .background(MaterialTheme.colorScheme.background)
                                        .clickable { viewModel.updateIsProduct(true) },
                                    horizontalArrangement = Arrangement.Center,
                                    verticalAlignment = Alignment.CenterVertically
                                ) {
                                    Icon(
                                        painterResource(VestaResourceImages.icon_big_cart),
                                        contentDescription = "",
                                        tint = MaterialTheme.colorScheme.primary
                                    )
                                    Spacer(Modifier.width(15.dp))
                                    Text(
                                        text = VestaResourceStrings.all_products,
                                        fontSize = 16.sp,
                                        fontWeight = FontWeight.SemiBold,
                                        color = MaterialTheme.colorScheme.onSecondary
                                    )
                                }
                            }
                        }

                        //субкатегории
                        items(
                            state.subcategoryList.children,
                            key = { it.hashCode() }) { subcategory ->
                            SubcategoryCard(
                                image = subcategory.image,
                                name = subcategory.name,
                                onClick = { navigator.push(SubcategoryScreen(subcategory.categoryId)) }
                            )
                        }
                    } else {
                        //продукты
                        items(state.productList, key = { it.hashCode() }) { product ->
                            ProductCard(
                                image = product.image,
                                name = product.nameKorr,
                                price = product.price,
                                stickers = product.octStickers.specialStickerData,
                                onClick = { navigator.push(ProductScreen(product.productId)) },
                                isFavorite = product.isFavorite,
                                onHeartClick = { viewModel.addToWishlist(product.productId) }
                            )
                        }
                        if (state.productList.isEmpty()) {
                            item(span = { GridItemSpan(2) }) {
                                Row(
                                    Modifier
                                        .fillMaxWidth()
                                        .padding(20.dp),
                                    verticalAlignment = Alignment.CenterVertically,
                                    horizontalArrangement = Arrangement.Center
                                ) {
                                    Text(
                                        text = VestaResourceStrings.sold,
                                        fontSize = 16.sp,
                                        fontWeight = FontWeight.Medium,
                                        lineHeight = 19.5.sp
                                    )
                                }
                            }
                        }
                    }
                }
            }
        }
    }
}

@Composable
private fun SubcategoryCard(
    image: String,
    name: String,
    onClick: ()-> Unit
){
    Surface(
        Modifier
            .fillMaxWidth()
            .height(160.dp)
            .padding(5.dp),
        shape = RoundedCornerShape(25.dp),
        shadowElevation = 5.dp) {

        Column(
            Modifier
                .fillMaxSize()
                .clip(RoundedCornerShape(15.dp))
                .background(MaterialTheme.colorScheme.background)
                .clickable(onClick = onClick),
            verticalArrangement = Arrangement.Top,
            horizontalAlignment = Alignment.CenterHorizontally) {

            Box(Modifier.fillMaxWidth().height(100.dp).padding(vertical = 10.dp, horizontal = 10.dp)) {
                CustomAsyncImage(image, modifier = Modifier.fillMaxSize())
            }
            Text(
                text = name,
                fontSize = 12.sp,
                softWrap = true,
                maxLines = 3,
                textAlign = TextAlign.Center,
                modifier = Modifier.padding(horizontal = 10.dp)
            )
        }
    }
}

@Composable
private fun CheckRow(
    checked: Boolean,
    onCheckedChange: (Boolean)->Unit,
    text: String
){
    Row(Modifier.fillMaxWidth().padding(top = 10.dp),
        verticalAlignment = Alignment.CenterVertically){
        CustomCheckBox(
            checked = checked,
            onCheckedChange = onCheckedChange
        )
        Spacer(Modifier.width(15.dp))
        Text(
            text = text,
            fontSize = 14.sp,
            fontWeight = FontWeight.Normal
        )
    }
}

@Composable
private fun ExpandPanel(
    name: String,
    content: @Composable () -> Unit
){
    var isOpen by remember{ mutableStateOf(false) }
    val rotation = if(isOpen) 90f else 0f
    Column(
        Modifier
            .fillMaxWidth()
            .padding(top = 15.dp)
    ) {
        Row(
            Modifier
                .fillMaxWidth()
                .clickableBlank { isOpen = !isOpen },
            horizontalArrangement = Arrangement.SpaceBetween){
            Text(
                text = name,
                fontSize = 16.sp,
                fontWeight = FontWeight.Medium,
            )
            Icon(
                modifier = Modifier.rotate(rotation),
                painter = painterResource(VestaResourceImages.icon_arrow),
                contentDescription = "",
            )
        }
        HorizontalLine(Modifier.padding(vertical = 10.dp))

        if(isOpen){
            content()
        }
    }
}
