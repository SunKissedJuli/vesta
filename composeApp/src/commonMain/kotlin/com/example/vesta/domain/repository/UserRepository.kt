package com.example.vesta.domain.repository

import com.example.vesta.data.models.user.NewUser
import com.example.vesta.data.models.user.UserUpdate
import com.example.vesta.domain.modelsUI.blog.RelatedProductUi
import com.example.vesta.domain.modelsUI.user.CurrentUserUi
import com.example.vesta.domain.modelsUI.user.TokenUi
import com.example.vesta.platform.Either
import com.example.vesta.platform.Failure

interface UserRepository {

    suspend fun authorize(login: String, password: String) : Either<Failure,TokenUi>

    suspend fun getCurrentUser() : Either<Failure,CurrentUserUi>

    suspend fun logOut() : Either<Failure,Unit>

    suspend fun editUser(user: UserUpdate) : Either<Failure,Unit>

    suspend fun registration(user: NewUser) : Either<Failure, TokenUi>

    suspend fun registrationNullableUser() : Either<Failure, TokenUi>

    suspend fun getWishlist() : Either<Failure, List<RelatedProductUi>>

}