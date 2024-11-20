package com.example.vesta.data.models.user

import kotlinx.serialization.SerialName
import kotlinx.serialization.Serializable

@Serializable
class TokenResponse(
    @SerialName("token")val token: Token?
)

@Serializable
class Token(
    @SerialName("plainTextToken")val plainTextToken: String?
)


