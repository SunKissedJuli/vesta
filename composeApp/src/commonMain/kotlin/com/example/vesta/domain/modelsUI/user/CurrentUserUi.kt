package com.example.vesta.domain.modelsUI.user

import kotlinx.serialization.SerialName
import kotlinx.serialization.Serializable

data class CurrentUserUi(
    val addressId: Int,
    val bonusCard: String,
    val cart: String,
    val code: String,
    val customField: String,
    val customerGroupId: Int,
    val customerId: Int,
    val dateAdded: String,
    val email: String,
    val fax: String,
    val firstName: String,
    val ip: String,
    val languageId: Int,
    val lastName: String,
    val middleName: String,
    val newsletter: Int,
    val password: String,
    val priorityPickupId: Int,
    val safe: Int,
    val salt: String,
    val status: Int,
    val storeId: Int,
    val telephone: String,
    val token: String,
    val orders: List<SmallOrderUi>
) {
    companion object {
        val empty = CurrentUserUi(
            addressId = 0,
            bonusCard = "",
            cart = "",
            code = "",
            customField = "",
            customerGroupId = 0,
            customerId = 0,
            dateAdded = "",
            email = "",
            password = "",
            fax = "",
            firstName = "",
            lastName = "",
            middleName = "",
            newsletter = 0,
            priorityPickupId = 0,
            safe = 0,
            storeId = 0,
            status = 0,
            salt = "",
            telephone = "",
            token = "",
            ip = "",
            languageId = 0,
            orders = emptyList()
        )
    }
}

data class SmallOrderUi(
    val orderId: Int,
    val name: String,
    val total: String,
    val dateAdded: String,
)