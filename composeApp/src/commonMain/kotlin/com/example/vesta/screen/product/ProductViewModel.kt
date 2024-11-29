package com.example.vesta.screen.product

import com.example.vesta.data.models.product.ImageUi
import com.example.vesta.domain.manager.AuthManager
import com.example.vesta.domain.manager.ObserverManager
import com.example.vesta.domain.repository.ProductRepository
import com.example.vesta.platform.BaseScreenModel
import org.koin.core.component.inject
import org.orbitmvi.orbit.syntax.simple.intent

internal class ProductViewModel:BaseScreenModel<ProductState, Unit>(ProductState.InitState) {

    private val productRepository: ProductRepository by inject()
    private val bottomBarVisibleManager: ObserverManager by inject()

    fun loadData(id: Int) = intent {
        launchOperation(
            operation = {
                productRepository.getProduct(id)
            },
            success = { response ->
                if (response.image.isNotEmpty()) {
                    val mainImage = ImageUi(response.image, 0, 0, 0)
                    val allImages: List<ImageUi> = listOf(mainImage) + response.images

                    reduceLocal {
                        state.copy(
                            productData = response.copy(images = allImages)
                        )
                    }
                } else {
                    reduceLocal {
                        state.copy(
                            productData = response
                        )
                    }
                }
            }
        )
    }

    fun setBottomBarVisible(visible: Boolean){
        bottomBarVisibleManager.setBottomBarVisibility(visible)
    }

    fun extractImageLinks(input: String): List<String> {
        val decodedInput = input
            .replace("&lt;", "<")
            .replace("&gt;", ">")
            .replace("&quot;", "\"")
            .replace("&amp;", "&")
        val regex = Regex("""<img src=["'](https://[^"']*)["'][^>]*>""")
        return regex.findAll(decodedInput).mapNotNull { it.groups[1]?.value }.toList()
    }

    fun addToWishlist(id: Int) = intent {
        launchOperation(
            operation = {
                productRepository.addToWishlist(id)
            },
            success = {
                reduceLocal { state.copy(productData = state.productData.copy(isFavorite = !state.productData.isFavorite)) }
            },
            loading = {setStatus(false)}
        )
    }
}