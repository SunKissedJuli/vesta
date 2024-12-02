package com.example.vesta.screen.favorites

import com.example.vesta.domain.repository.ProductRepository
import com.example.vesta.domain.repository.UserRepository
import com.example.vesta.platform.BaseScreenModel
import org.koin.core.component.inject
import org.orbitmvi.orbit.syntax.simple.intent

internal class FavoritesViewModel: BaseScreenModel<FavoritesState, Unit>(FavoritesState.InitState) {

    private val userRepository: UserRepository by inject()
    private val productRepository: ProductRepository by inject()

    fun loadData() = intent {
        launchOperation(
            operation = {
                userRepository.getWishlist()
            },
            success = { response ->
                reduceLocal {
                    state.copy(
                        favorites = response
                    )
                }
            }
        )
    }

    fun addToWishlist(id: Int) = intent {
        launchOperation(
            operation = {
                productRepository.addToWishlist(id)
            },
            success = {
               // reduceLocal { state.copy(favorites = state.favorites.get(id).copy(isFavorite = !state.favorites.get(id).isFavorite)) }
            },
            loading = {setStatus(false)}
        )
    }
}