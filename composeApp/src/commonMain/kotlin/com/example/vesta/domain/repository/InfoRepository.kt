package com.example.vesta.domain.repository

import com.example.vesta.data.models.info.SityUi
import com.example.vesta.domain.modelsUI.CategoryUi
import com.example.vesta.domain.modelsUI.info.ShopsUi
import com.example.vesta.platform.Either
import com.example.vesta.platform.Failure

interface InfoRepository {

    suspend fun getSites() : Either<Failure, List<SityUi>>

    suspend fun getShops() : Either<Failure, List<ShopsUi>>
}