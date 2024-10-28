package com.example.vesta.screen.sity

import com.example.vesta.data.models.info.SityUi
import com.example.vesta.domain.manager.AuthManager
import com.example.vesta.domain.repository.InfoRepository
import com.example.vesta.platform.BaseScreenModel
import org.koin.core.component.inject
import org.orbitmvi.orbit.syntax.simple.intent

internal class SityViewModel:BaseScreenModel<SityState, Unit>(SityState.InitState) {

    private val infoRepository: InfoRepository by inject()
    private val authManager: AuthManager by inject()

    fun loadData() = intent{
        launchOperation(
            operation = {
                infoRepository.getSites()
            },
            success = { response ->
                reduceLocal {
                    state.copy(
                        sities = response
                    )
                }
            },
        )
    }

    fun getChoosenSity() : SityUi{
        return state.sities.find { it.storeId == authManager.sity }?: SityUi.empty
    }

    fun updateChoosenSity(id: Int){
       authManager.sity = id
    }
}