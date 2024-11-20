package com.example.vesta.domain.repository

import androidx.room.Dao
import androidx.room.Insert
import androidx.room.OnConflictStrategy
import androidx.room.Query
import androidx.room.Update
import com.example.vesta.data.models.LocalWishlist

@Dao
interface LocalWishlistDao {

    @Query("SELECT * FROM LocalWishlist")
    suspend fun getAllWishlist(): List<LocalWishlist>

    @Update
    suspend fun updateFavorites(wishlist: LocalWishlist)

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    suspend fun addFavorites(wishlist: LocalWishlist)

    @Query("DELETE FROM LocalWishlist WHERE id = :productId")
    suspend fun deleteFavoriteById(productId: String)

    @Query("SELECT * FROM LocalWishlist WHERE id = :productId")
    suspend fun getFavoriteById(productId: String): LocalWishlist?
}