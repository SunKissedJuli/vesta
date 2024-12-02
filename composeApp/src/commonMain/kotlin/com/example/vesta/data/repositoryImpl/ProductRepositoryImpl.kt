package com.example.vesta.data.repositoryImpl

import com.example.vesta.data.api.VestaApi
import com.example.vesta.data.mapper.blog.toUI
import com.example.vesta.data.mapper.toUI
import com.example.vesta.data.models.CategoryByIdResponse
import com.example.vesta.data.models.product.ProductResponseUi
import com.example.vesta.data.models.product.toUI
import com.example.vesta.domain.manager.AuthManager
import com.example.vesta.domain.modelsUI.CategoryByIdResponseUi
import com.example.vesta.domain.modelsUI.CategoryUi
import com.example.vesta.domain.modelsUI.ProductsDataResponseUi
import com.example.vesta.domain.modelsUI.ProductsResponseUi
import com.example.vesta.domain.modelsUI.blog.RelatedProductUi
import com.example.vesta.domain.repository.ProductRepository
import com.example.vesta.platform.Either
import com.example.vesta.platform.Failure
import com.example.vesta.platform.apiCall

class ProductRepositoryImpl(private val vestaApi: VestaApi, private val manager: AuthManager) : ProductRepository {

    override suspend fun getAllCategory(): Either<Failure, List<CategoryUi>> {
        return apiCall (call = {
            vestaApi.getAllCategory(city = manager.city?:0)
        },
            mapResponse = { category -> category.toUI() })
    }

    override suspend fun getCategoryById(categoryId: Int, limit: Int, page: Int): Either<Failure, CategoryByIdResponseUi> {
        return apiCall (call = {
            vestaApi.getCategoryById(categoryId, limit, page, city = manager.city?:0)
        },
        mapResponse = { category -> category.toUI() })
    }

    override suspend fun getProduct(productId: Int): Either<Failure, ProductResponseUi> {
        return apiCall (call = {
            vestaApi.getProduct(productId, city = manager.city?:0)
        },
            mapResponse = { product -> product.toUI() })
    }

    override suspend fun getFeaturedProducts(): Either<Failure, List<RelatedProductUi>> {
        return apiCall (call = {
            vestaApi.getFeaturedProducts(city = manager.city?:0)
        },
            mapResponse = { product -> product.toUI() })
    }

    override suspend fun addToWishlist(productId: Int): Either<Failure, Unit> {
        return apiCall (call = {
            vestaApi.addToWishlist(productId)
        })
    }
}