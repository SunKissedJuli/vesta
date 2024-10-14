package com.example.vesta.domain.repository

import com.example.vesta.data.models.CategoryByIdResponse
import com.example.vesta.domain.modelsUI.CategoryByIdResponseUi
import com.example.vesta.domain.modelsUI.CategoryUi
import com.example.vesta.platform.Either
import com.example.vesta.platform.Failure

interface ProductRepository {

    suspend fun getAllCategory() : Either<Failure, List<CategoryUi>>

    suspend fun getCategoryById(
        categoryId: Int,
        limit: Int = 25,
        page: Int = 1
    ): Either<Failure, CategoryByIdResponseUi>


}