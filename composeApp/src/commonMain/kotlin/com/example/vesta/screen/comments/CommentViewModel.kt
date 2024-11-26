package com.example.vesta.screen.comments

import com.example.vesta.domain.manager.AuthManager
import com.example.vesta.domain.manager.ObserverManager
import com.example.vesta.domain.repository.InfoRepository
import com.example.vesta.domain.repository.ProductRepository
import com.example.vesta.platform.BaseScreenModel
import org.koin.core.component.inject
import org.orbitmvi.orbit.syntax.simple.intent


internal class CommentViewModel: BaseScreenModel<CommentState, Unit>(CommentState.InitState) {

    private val infoRepository: InfoRepository by inject()
    private val productRepository: ProductRepository by inject()
    private val manager: AuthManager by inject()
    private val bottomBarVisibleManager: ObserverManager by inject()

    fun loadData() = intent {
        launchOperation(
            operation = {
                infoRepository.getBlogById(1)
            },
            success = { response ->
                reduceLocal { state.copy(newsData = response,) }
            }
        )
    }
}