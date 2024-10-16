package com.example.vesta.screen.product

import com.example.vesta.domain.repository.ProductRepository
import com.example.vesta.platform.BaseScreenModel
import org.koin.core.component.inject
import org.orbitmvi.orbit.syntax.simple.intent

internal class ProductViewModel:BaseScreenModel<ProductState, Unit>(ProductState.InitState) {

    private val productRepository: ProductRepository by inject()

    fun loadData(id: Int) = intent {
        println("лоаддаата во вьюмодельке")
        launchOperation(
            operation = {
                productRepository.getProduct(id)
            },
            success = { response ->
                reduceLocal {
                    state.copy(
                        productData = response
                    )
                }
            }
        )
    }

}