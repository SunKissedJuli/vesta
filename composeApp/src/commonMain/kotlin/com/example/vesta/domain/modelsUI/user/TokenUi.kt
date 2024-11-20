package com.example.vesta.domain.modelsUI.user

import com.example.vesta.data.models.user.Token
import kotlinx.serialization.SerialName
import kotlinx.serialization.Serializable

data class TokenUi(
  val plainTextToken: String
)

@Serializable
class TokenRegistrationUi(
  @SerialName("accessToken")val token: Token?
)

