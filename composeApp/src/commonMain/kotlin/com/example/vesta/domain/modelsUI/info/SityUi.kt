package com.example.vesta.data.models.info

import kotlinx.serialization.Serializable

@Serializable
data class CityUi(
    val storeId: Int,
    val name: String,
    val url: String,
    val ssl: String,
    val phone: String
){
    companion object{
        val empty = CityUi(
            storeId = 0,
            name = "",
            url = "",
            ssl = "",
            phone = ""
        )
    }
}

