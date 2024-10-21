package com.example.vesta.data.repositoryImpl

import com.example.vesta.data.api.VestaApi
import com.example.vesta.data.mapper.info.toUI
import com.example.vesta.data.mapper.toUI
import com.example.vesta.data.models.CategoryByIdResponse
import com.example.vesta.data.models.info.SityUi
import com.example.vesta.data.models.info.toUI
import com.example.vesta.domain.manager.AuthManager
import com.example.vesta.domain.modelsUI.CategoryByIdResponseUi
import com.example.vesta.domain.modelsUI.CategoryUi
import com.example.vesta.domain.modelsUI.info.ShopsUi
import com.example.vesta.domain.modelsUI.info.StocksUi
import com.example.vesta.domain.repository.InfoRepository
import com.example.vesta.domain.repository.ProductRepository
import com.example.vesta.platform.Either
import com.example.vesta.platform.Failure
import com.example.vesta.platform.apiCall

class InfoRepositoryImpl(private val vestaApi: VestaApi, private val manager: AuthManager) : InfoRepository {
    override suspend fun getSites(): Either<Failure, List<SityUi>> {
        return apiCall (call = {
            vestaApi.getSites()
        },
            mapResponse = { sity -> sity.toUI() })
    }

    override suspend fun getShops(): Either<Failure, List<ShopsUi>> {
        return apiCall (call = {
            vestaApi.getShops(manager.sity?:0)
        },
            mapResponse = { shop -> shop.toUI() })
    }

    override suspend fun getStocks(): Either<Failure, List<StocksUi>> {
        return apiCall (call = {
            vestaApi.getStocks(manager.sity?:0)
        },
            mapResponse = { stock -> stock.toUI() })
    }

}