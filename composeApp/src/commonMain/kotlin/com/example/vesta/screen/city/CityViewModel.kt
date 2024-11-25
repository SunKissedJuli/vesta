package com.example.vesta.screen.city

import com.example.vesta.data.models.info.CityUi
import com.example.vesta.domain.manager.AuthManager
import com.example.vesta.domain.repository.InfoRepository
import com.example.vesta.platform.BaseScreenModel
import org.koin.core.component.inject
import org.orbitmvi.orbit.syntax.simple.intent

internal class CityViewModel:BaseScreenModel<CityState, Unit>(CityState.InitState) {

    private val infoRepository: InfoRepository by inject()
    private val authManager: AuthManager by inject()

    fun loadData() = intent{
        launchOperation(
            operation = {
                infoRepository.getCites()
            },
            success = { response ->
                reduceLocal {
                    state.copy(
                        cities = response
                    )
                }
            },
        )
    }

    fun getChoosenSity() : CityUi {
        return state.cities.find { it.storeId == authManager.city }?: CityUi.empty
    }

    fun updateChoosenSity(id: Int){
       authManager.city = id
    }
}