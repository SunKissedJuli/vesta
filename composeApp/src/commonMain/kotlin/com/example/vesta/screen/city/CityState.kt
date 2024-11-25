package com.example.vesta.screen.city

import com.example.vesta.data.models.info.CityUi

data class CityState(
    val cities: List<CityUi>,
){
    companion object{
        val InitState = CityState(
            cities = listOf(),
        )
    }
}

