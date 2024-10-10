package com.example.vesta.data.repositoryImpl

import com.example.vesta.data.api.VestaApi
import com.example.vesta.data.mapper.toUI
import com.example.vesta.domain.modelsUI.CategoryUi
import com.example.vesta.domain.repository.ProductRepository
import com.example.vesta.platform.Either
import com.example.vesta.platform.Failure
import com.example.vesta.platform.apiCall

class ProductRepositoryImpl(private val vestaApi: VestaApi) : ProductRepository {
    override suspend fun getAllCategory(): Either<Failure, List<CategoryUi>> {
        return apiCall (call = {
            vestaApi.getAllCategory().values.toList()
        },
            mapResponse = { userData -> userData.toUI() })
    }

    override suspend fun getCategoryById(): Either<Failure, CategoryUi> {
        return apiCall (call = {
            vestaApi.getCategoryById()
        },
            mapResponse = { userData -> userData.toUI() })
    }
}