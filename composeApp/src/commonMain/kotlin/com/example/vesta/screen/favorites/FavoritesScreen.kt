package com.example.vesta.screen.favorites

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.grid.GridCells
import androidx.compose.foundation.lazy.grid.LazyVerticalGrid
import androidx.compose.foundation.lazy.grid.items
import androidx.compose.material3.MaterialTheme
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.runtime.collectAsState
import androidx.compose.runtime.getValue
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import cafe.adriel.voyager.core.model.rememberScreenModel
import cafe.adriel.voyager.core.screen.Screen
import cafe.adriel.voyager.navigator.LocalNavigator
import cafe.adriel.voyager.navigator.currentOrThrow
import com.example.vesta.components.CustomCircularProgressIndicator
import com.example.vesta.components.CustomScaffold
import com.example.vesta.components.HeaderOneWord
import com.example.vesta.components.HeaderWithButtonBack
import com.example.vesta.components.ProductCard
import com.example.vesta.screen.product.ProductScreen
import com.example.vesta.strings.VestaResourceStrings

class FavoritesScreen: Screen {
    @Composable
    override fun Content() {
        val viewModel = rememberScreenModel { FavoritesViewModel() }
        val state by viewModel.stateFlow.collectAsState()
        val navigator = LocalNavigator.currentOrThrow
        LaunchedEffect(viewModel){
            viewModel.loadData()
        }

        CustomScaffold(
            topBar = {
                HeaderWithButtonBack(
                    onClick = {navigator.pop()},
                    text = VestaResourceStrings.favorites)
            }
        ) {
            if (viewModel.status.collectAsState().value && FavoritesState.InitState == state) {
                CustomCircularProgressIndicator()
            } else {
                LazyVerticalGrid(
                    modifier = Modifier.fillMaxSize().padding(horizontal = 15.dp),
                    columns = GridCells.Fixed(2),
                    contentPadding = PaddingValues(vertical = 10.dp)
                ) {
                    items(state.favorites){ favorite ->
                        ProductCard(
                            stickers = favorite.octStickers.specialStickerData,
                            image = favorite.image,
                            name = favorite.name,
                            price = favorite.price,
                            isFavorite = favorite.isFavorite,
                            onHeartClick = {viewModel.addToWishlist(favorite.productId)},
                            onClick = {navigator.push(ProductScreen(favorite.productId))},
                        )
                    }
                }
            }
        }
    }
}