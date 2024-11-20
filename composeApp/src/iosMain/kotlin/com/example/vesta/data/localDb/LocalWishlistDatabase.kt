package com.example.vesta.data.localDb

import androidx.room.Room
import androidx.sqlite.driver.bundled.BundledSQLiteDriver
import kotlinx.coroutines.Dispatchers

//fun getDatabaseBuilder(): LocalWishlistDatabase {
//    val dbFile = "${NSHomeDirectory()}/mrx_note.db"
//    return Room.databaseBuilder<LocalWishlistDatabase>(
//        name = dbFile,
//        factory = { LocalWishlistDatabase::class.instantiateImpl() }
//    ).setDriver(BundledSQLiteDriver())
//        .setQueryCoroutineContext(Dispatchers.IO)
//        .build()
//}



