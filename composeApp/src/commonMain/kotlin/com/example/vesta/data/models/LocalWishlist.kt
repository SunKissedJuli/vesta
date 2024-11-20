package com.example.vesta.data.models

import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity
data class LocalWishlist (
    @PrimaryKey(autoGenerate = true) val id: Int? = null,
    val productId: String
)