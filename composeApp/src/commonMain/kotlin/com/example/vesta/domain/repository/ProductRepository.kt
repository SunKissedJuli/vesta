package com.example.vesta.domain.repository

import com.example.vesta.data.models.product.ProductResponseUi
import com.example.vesta.domain.modelsUI.CategoryByIdResponseUi
import com.example.vesta.domain.modelsUI.CategoryUi
import com.example.vesta.domain.modelsUI.ProductsDataResponseUi
import com.example.vesta.domain.modelsUI.ProductsResponseUi
import com.example.vesta.domain.modelsUI.blog.RelatedProductUi
import com.example.vesta.platform.Either
import com.example.vesta.platform.Failure

interface ProductRepository {

    suspend fun getAllCategory() : Either<Failure, List<CategoryUi>>

    suspend fun getCategoryById(
        categoryId: Int,
        limit: Int = 25,
        page: Int = 1
    ): Either<Failure, CategoryByIdResponseUi>

    suspend fun getProduct(
        productId: Int,
    ): Either<Failure, ProductResponseUi>

    suspend fun getFeaturedProducts(): Either<Failure, List<RelatedProductUi>>

    suspend fun addToWishlist(
        productId: Int,
    ): Either<Failure, Unit>


}