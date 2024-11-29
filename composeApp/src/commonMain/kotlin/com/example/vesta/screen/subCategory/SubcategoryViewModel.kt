package com.example.vesta.screen.subCategory

import com.example.vesta.domain.manager.ObserverManager
import com.example.vesta.domain.repository.ProductRepository
import com.example.vesta.platform.BaseScreenModel
import org.koin.core.component.inject
import org.orbitmvi.orbit.syntax.simple.blockingIntent
import org.orbitmvi.orbit.syntax.simple.intent
import org.orbitmvi.orbit.syntax.simple.reduce

internal class SubcategoryViewModel: BaseScreenModel<SubcategoryState, SubcategotyEvent>(SubcategoryState.InitState) {

    private val productRepository: ProductRepository by inject()
    private val bottomBarVisibleManager: ObserverManager by inject()

    fun loadData(id: Int) = intent {
        launchOperation(
            operation = {
                productRepository.getCategoryById(
                    categoryId = id
                )
            },
            success = {response ->
                reduceLocal {
                    state.copy(
                        subcategoryList = response.category,
                        productList = response.products,
                        isProducts = response.category.children.isEmpty()
                    )
                }},
        )
    }

    fun setBottomBarVisible(visible: Boolean){
        bottomBarVisibleManager.setBottomBarVisibility(visible)
    }

    fun updateIsProduct(isProduct: Boolean) = blockingIntent{
       reduce { state.copy(isProducts = isProduct) }
    }

    fun updateShowFilter(showFilter: Boolean) = blockingIntent{
        reduce { state.copy(showFilter = showFilter) }
    }

    fun addToWishlist(id: Int) = intent {
        launchOperation(
            operation = {
                productRepository.addToWishlist(id)
            },
            loading = {setStatus(false)}
        )
    }
}