package com.example.vesta.screen.category

import com.example.vesta.data.repositoryImpl.ProductRepositoryImpl
import com.example.vesta.domain.manager.ObserverManager
import com.example.vesta.domain.repository.ProductRepository
import com.example.vesta.platform.BaseScreenModel
import org.koin.core.component.inject
import org.orbitmvi.orbit.syntax.simple.blockingIntent
import org.orbitmvi.orbit.syntax.simple.intent
import org.orbitmvi.orbit.syntax.simple.reduce

internal class CategoryViewModel: BaseScreenModel<CategoryState, Unit>(CategoryState.InitState) {
    private val productRepository: ProductRepository by inject()
    private val bottomBarVisibleManager: ObserverManager by inject()

    fun loadData() = intent {
        launchOperation(
            operation = {
                productRepository.getAllCategory()
            },
            success = { response ->
                reduceLocal { state.copy(
                    categoryList = response,
                )}
            }
        )
    }

    fun updateSearchString(searchString: String) = blockingIntent {
        reduce { state.copy(searchString = searchString) }
    }

    fun setBottomBarVisible(visible: Boolean){
        bottomBarVisibleManager.setBottomBarVisibility(visible)
    }
}