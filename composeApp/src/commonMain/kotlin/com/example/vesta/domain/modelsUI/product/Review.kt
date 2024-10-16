package com.example.vesta.data.models.product

import kotlinx.serialization.Serializable
import kotlinx.serialization.SerialName

@Serializable
class ReviewUi(
    val author: String,
    val customerId: Int,
    val dateAdded: String,
    val dateModified: String,
    val productId: Int,
    val rating: Int,
    val reply: String,
    val reviewId: Int,
    val status: Int,
    val text: String
) {
    companion object {
        val empty = ReviewUi(
            author = "",
            customerId = 0,
            dateAdded = "",
            dateModified = "",
            productId = 0,
            rating = 0,
            reply = "",
            reviewId = 0,
            status = 0,
            text = ""
        )
    }
}