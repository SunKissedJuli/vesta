package com.example.vesta.data.localDb

import android.content.Context
import androidx.room.Room
import androidx.sqlite.driver.bundled.BundledSQLiteDriver
import kotlinx.coroutines.Dispatchers

fun getDatabaseBuilder(context: Context): LocalWishlistDatabase {
    val dbFile = context.getDatabasePath("local_wishlist.db")
    return Room.databaseBuilder<LocalWishlistDatabase>(context, dbFile.absolutePath)
        .setDriver(BundledSQLiteDriver())
        .setQueryCoroutineContext(Dispatchers.IO)
        .build()
}