package com.example.vesta.data.models.user

import kotlinx.serialization.SerialName
import kotlinx.serialization.Serializable

@Serializable
class NewUser(
    @SerialName("email") var email: String?,
    @SerialName("firstname") var firstName: String?,
    @SerialName("lastname") var lastName: String?,
    @SerialName("middlename") var middleName: String?,
    @SerialName("password") var password: String?,
    @SerialName("password_confirmation") var passwordConfirmation: String?,
    @SerialName("telephone") var telephone: String?,
    @SerialName("store_id") var storeId: Int?,
    @SerialName("newsletter") var newsletter: Int?
)