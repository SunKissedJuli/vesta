package com.example.vesta.screen.newsDetails

import com.example.vesta.domain.manager.AuthManager
import com.example.vesta.domain.manager.ObserverManager
import com.example.vesta.domain.repository.InfoRepository
import com.example.vesta.domain.repository.ProductRepository
import com.example.vesta.platform.BaseScreenModel
import org.koin.core.component.inject
import org.orbitmvi.orbit.syntax.simple.intent


internal class NewsDetailsViewModel: BaseScreenModel<NewsDetailsState, Unit>(NewsDetailsState.InitState) {

    private val infoRepository: InfoRepository by inject()
    private val productRepository: ProductRepository by inject()
    private val manager: AuthManager by inject()
    private val bottomBarVisibleManager: ObserverManager by inject()

    fun loadData(id: Int) = intent {
        launchOperation(
            operation = {
                infoRepository.getBlogById(id)
            },
            success = { response ->
                reduceLocal { state.copy(newsData = response,) }
            }
        )
    }

    fun addToWishlist(id: Int) = intent {
        launchOperation(
            operation = {
                productRepository.addToWishlist(id)
            },
        )
    }
}