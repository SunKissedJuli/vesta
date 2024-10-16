package com.example.vesta.data.models.product

import kotlinx.serialization.Serializable
import kotlinx.serialization.SerialName

@Serializable
class Review(
    @SerialName("author") val author: String?,
    @SerialName("customer_id") val customerId: Int?,
    @SerialName("date_added") val dateAdded: String?,
    @SerialName("date_modified") val dateModified: String?,
    @SerialName("product_id") val productId: Int?,
    @SerialName("rating") val rating: Int?,
    @SerialName("reply") val reply: String?,
    @SerialName("review_id") val reviewId: Int?,
    @SerialName("status") val status: Int?,
    @SerialName("text") val text: String?
)