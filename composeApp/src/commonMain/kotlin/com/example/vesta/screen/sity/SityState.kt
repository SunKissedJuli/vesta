package com.example.vesta.screen.sity

import com.example.vesta.data.models.info.SityUi

data class SityState(
    val sities: List<SityUi>,
){
    companion object{
        val InitState = SityState(
            sities = listOf(),
        )
    }
}

