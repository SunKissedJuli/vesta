package com.example.vesta.screen.home

import com.example.vesta.domain.repository.InfoRepository
import com.example.vesta.domain.repository.ProductRepository
import com.example.vesta.platform.BaseScreenModel
import org.koin.core.component.inject
import org.orbitmvi.orbit.syntax.simple.intent

internal class HomeViewModel: BaseScreenModel<HomeState, Unit>(HomeState.InitState) {

    private val infoRepository: InfoRepository by inject()

    fun loadData(){
        loadStocks()
    }

    fun loadStocks() = intent{
        launchOperation(
            operation = {
                infoRepository.getStocks()
            },
            success = { response ->
                reduceLocal { state.copy(
                    stockData = response
                ) }
            }
        )
    }
}
