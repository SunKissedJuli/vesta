package com.example.vesta.data.models.user

import com.example.vesta.domain.modelsUI.user.UserUpdateUi
import kotlinx.serialization.SerialName
import kotlinx.serialization.Serializable

@Serializable
class UserUpdate(
    @SerialName("email") var email: String?,
    @SerialName("firstname") var firstName: String?,
    @SerialName("lastname") var lastName: String?,
    @SerialName("middlename") var middleName: String?,
    @SerialName("oldpassword") var oldPassword: String?,
    @SerialName("password") var password: String?,
    @SerialName("password_confirmation") var passwordConfirmation: String?,
    @SerialName("telephone") var telephone: String?
) {
    companion object {
        val empty = UserUpdate(
            email = null,
            firstName = null,
            lastName = null,
            middleName = null,
            oldPassword = null,
            password = null,
            passwordConfirmation = null,
            telephone = null
        )
    }
}