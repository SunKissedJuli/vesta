package com.example.vesta.domain.repository

import com.example.vesta.domain.modelsUI.CategoryUi
import com.example.vesta.platform.Either
import com.example.vesta.platform.Failure

interface ProductRepository {

    suspend fun getAllCategory() : Either<Failure, List<CategoryUi>>

    suspend fun getCategoryById() : Either<Failure, CategoryUi>

}