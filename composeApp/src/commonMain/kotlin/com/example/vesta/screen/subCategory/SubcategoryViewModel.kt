package com.example.vesta.screen.subCategory

import com.example.vesta.domain.repository.ProductRepository
import com.example.vesta.platform.BaseScreenModel
import org.koin.core.component.inject
import org.orbitmvi.orbit.syntax.simple.intent

internal class SubcategoryViewModel: BaseScreenModel<SubcategoryState, Unit>(SubcategoryState.InitState) {

    private val productRepository: ProductRepository by inject()

    fun loadData(id: Int) = intent {
//        launchOperation(
//            operation = {
//                productRepository.getCategoryById()
//            }
//        )
    }
}