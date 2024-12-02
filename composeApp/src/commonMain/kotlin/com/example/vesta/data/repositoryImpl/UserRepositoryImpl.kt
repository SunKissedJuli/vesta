package com.example.vesta.data.repositoryImpl

import com.example.vesta.data.api.VestaApi
import com.example.vesta.data.mapper.blog.toUI
import com.example.vesta.data.mapper.user.toUI
import com.example.vesta.data.models.user.NewUser
import com.example.vesta.data.models.user.UserUpdate
import com.example.vesta.domain.modelsUI.blog.RelatedProductUi
import com.example.vesta.domain.modelsUI.user.CurrentUserUi
import com.example.vesta.domain.modelsUI.user.TokenUi
import com.example.vesta.domain.repository.UserRepository
import com.example.vesta.platform.Either
import com.example.vesta.platform.Failure
import com.example.vesta.platform.apiCall

class UserRepositoryImpl(private val vestaApi: VestaApi) : UserRepository {

    override suspend fun authorize(login: String, password: String): Either<Failure, TokenUi> {
        return apiCall (call = {
            vestaApi.authorize(login, password)
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
        })
    }

    override suspend fun editUser(user: UserUpdate): Either<Failure, Unit> {
        return apiCall (call = {
            vestaApi.editUser(user)
        })
    }

    override suspend fun registration(user: NewUser): Either<Failure, TokenUi> {
        return apiCall (call = {
            vestaApi.registration(user)
        },
            mapResponse = {token -> token.toUI()})
    }

    override suspend fun registrationNullableUser(): Either<Failure, TokenUi> {
        return apiCall (call = {
            vestaApi.registrationNullableUser()
        },
            mapResponse = {token -> token.toUI()})
    }

    override suspend fun getWishlist(): Either<Failure, List<RelatedProductUi>> {
        return apiCall (call = {
            vestaApi.getWishlist()
        },
            mapResponse = {product -> product.toUI()})
    }
}