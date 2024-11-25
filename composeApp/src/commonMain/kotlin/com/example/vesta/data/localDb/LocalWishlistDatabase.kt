package com.example.vesta.data.localDb

import androidx.room.Database
import androidx.room.RoomDatabase
import com.example.vesta.data.entity.LocalWishlist
import com.example.vesta.domain.repository.LocalWishlistDao


@Database(
    entities = [LocalWishlist::class],
    version = 1
)
abstract class LocalWishlistDatabase: RoomDatabase(), DB {

    abstract fun getDao(): LocalWishlistDao

    override fun clearAllTables(): Unit {}
}

interface DB {
    fun clearAllTables(): Unit {}
}

