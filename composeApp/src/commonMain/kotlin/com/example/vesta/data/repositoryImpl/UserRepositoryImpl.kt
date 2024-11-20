package com.example.vesta.data.repositoryImpl

import com.example.vesta.data.api.VestaApi
import com.example.vesta.data.mapper.info.toUI
import com.example.vesta.data.mapper.toUI
import com.example.vesta.data.mapper.user.toUI
import com.example.vesta.data.models.CategoryByIdResponse
import com.example.vesta.data.models.info.SityUi
import com.example.vesta.data.models.info.toUI
import com.example.vesta.data.models.product.toUI
import com.example.vesta.data.models.user.NewUser
import com.example.vesta.data.models.user.UserUpdate
import com.example.vesta.domain.manager.AuthManager
import com.example.vesta.domain.modelsUI.CategoryByIdResponseUi
import com.example.vesta.domain.modelsUI.CategoryUi
import com.example.vesta.domain.modelsUI.info.ShopsUi
import com.example.vesta.domain.modelsUI.info.StocksUi
import com.example.vesta.domain.modelsUI.user.CurrentUserUi
import com.example.vesta.domain.modelsUI.user.TokenUi
import com.example.vesta.domain.repository.InfoRepository
import com.example.vesta.domain.repository.ProductRepository
import com.example.vesta.domain.repository.UserRepository
import com.example.vesta.platform.Either
import com.example.vesta.platform.Failure
import com.example.vesta.platform.apiCall

class UserRepositoryImpl(private val vestaApi: VestaApi) : UserRepository {

    override suspend fun autirize(login: String, password: String): Either<Failure, TokenUi> {
        return apiCall (call = {
            vestaApi.autorize(login, password)
        },
            mapResponse = {token -> token.toUI()})
    }

    override suspend fun getCurrentUser(): Either<Failure, CurrentUserUi> {
        return apiCall (call = {
            vestaApi.getCurrentUser()
        },
            mapResponse = {user -> user.toUI()})
    }

    override suspend fun logOut(): Either<Failure, Unit> {
        return apiCall (call = {
            vestaApi.logOut()
        },
            mapResponse = {Unit})
    }

    override suspend fun editUser(user: UserUpdate): Either<Failure, Unit> {
        return apiCall (call = {
            vestaApi.editUser(user)
        },
            mapResponse = {Unit})
    }

    override suspend fun registration(user: NewUser): Either<Failure, TokenUi> {
        return apiCall (call = {
            vestaApi.registration(user)
        },
            mapResponse = {token -> token.toUI()})
    }
}