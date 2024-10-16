package com.example.vesta.data.mapper.product

import com.example.vesta.data.models.product.Review
import com.example.vesta.data.models.product.ReviewUi

fun Review.toUI(): ReviewUi {
    return ReviewUi(
        author = this.author.orEmpty(),
        customerId = this.customerId ?: 0,
        dateAdded = this.dateAdded.orEmpty(),
        dateModified = this.dateModified.orEmpty(),
        productId = this.productId ?: 0,
        rating = this.rating ?: 0,
        reply = this.reply.orEmpty(),
        reviewId = this.reviewId ?: 0,
        status = this.status ?: 0,
        text = this.text.orEmpty()
    )
}