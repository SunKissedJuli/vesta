package com.example.vesta.data.repositoryImpl

import com.example.vesta.data.api.VestaApi
import com.example.vesta.data.mapper.toUI
import com.example.vesta.data.models.CategoryByIdResponse
import com.example.vesta.domain.modelsUI.CategoryByIdResponseUi
import com.example.vesta.domain.modelsUI.CategoryUi
import com.example.vesta.domain.repository.ProductRepository
import com.example.vesta.platform.Either
import com.example.vesta.platform.Failure
import com.example.vesta.platform.apiCall

class ProductRepositoryImpl(private val vestaApi: VestaApi) : ProductRepository {
    override suspend fun getAllCategory(): Either<Failure, List<CategoryUi>> {
        return apiCall (call = {
            vestaApi.getAllCategory()
        },
            mapResponse = { category -> category.toUI() })
    }

    override suspend fun getCategoryById(categoryId: Int, limit: Int, page: Int): Either<Failure, CategoryByIdResponseUi> {
        return apiCall (call = {
            vestaApi.getCategoryById(categoryId, limit, page)
        },
        mapResponse = { category -> category.toUI() })
    }
}