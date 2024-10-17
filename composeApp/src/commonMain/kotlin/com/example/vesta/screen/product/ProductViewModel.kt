package com.example.vesta.screen.product

import com.example.vesta.data.models.product.ImageUi
import com.example.vesta.domain.manager.AuthManager
import com.example.vesta.domain.repository.ProductRepository
import com.example.vesta.platform.BaseScreenModel
import org.koin.core.component.inject
import org.orbitmvi.orbit.syntax.simple.intent

internal class ProductViewModel:BaseScreenModel<ProductState, Unit>(ProductState.InitState) {

    private val productRepository: ProductRepository by inject()

    fun loadData(id: Int) = intent {
        launchOperation(
            operation = {
                productRepository.getProduct(id)
            },
            success = { response ->
                val mainImage = ImageUi(response.image, 0, 0, 0)
                val allImages: List<ImageUi> = listOf(mainImage) + response.images
                reduceLocal {
                    state.copy(
                        productData = response.copy(images = allImages)
                    )
                }
            }
        )
    }

}