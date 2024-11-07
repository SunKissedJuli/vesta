package com.example.vesta.data.models.user

import kotlinx.serialization.SerialName
import kotlinx.serialization.Serializable

@Serializable
class CurrentUser(
    @SerialName("address_id") val address_id: Int?,
    @SerialName("bonus_card")val bonus_card: String?,
    @SerialName("cart")val cart: String?,
    @SerialName("code") val code: String?,
    @SerialName("custom_field")val custom_field: String?,
    @SerialName("customer_group_id")val customer_group_id: Int?,
    @SerialName("customer_id")val customer_id: Int?,
    @SerialName("date_added")val date_added: String?,
    @SerialName("email")val email: String?,
    @SerialName("fax")val fax: String?,
    @SerialName("firstname") val firstname: String?,
    @SerialName("ip")val ip: String?,
    @SerialName("language_id")val language_id: Int?,
    @SerialName("lastname")val lastname: String?,
    @SerialName("middlename")val middlename: String?,
    @SerialName("newsletter")val newsletter: Int?,
    @SerialName("password") val password: String?,
    @SerialName("priority_pickup_id") val priority_pickup_id: Int?,
    @SerialName("safe")val safe: Int?,
    @SerialName("salt")val salt: String?,
    @SerialName("status")val status: Int?,
    @SerialName("store_id")val store_id: Int?,
    @SerialName("telephone")val telephone: String?,
    @SerialName("token")val token: String?,
    @SerialName("order") val orders: List<SmallOrder>?,
)

@Serializable
class SmallOrder(
    @SerialName("order_id") val orderId: Int?,
    @SerialName("name") val name: String?,
    @SerialName("total") val total: String?,
    @SerialName("date_added") val dateAdded: String?,
)