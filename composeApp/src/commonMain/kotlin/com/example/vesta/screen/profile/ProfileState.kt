package com.example.vesta.screen.profile

import com.example.vesta.commons.Constantas.DEFAULT_STRING
import com.example.vesta.domain.modelsUI.user.CurrentUserUi

data class ProfileState(
    val currentUser: CurrentUserUi,

    ){
    companion object{
        val InitState = ProfileState(
            currentUser = CurrentUserUi.empty,
        )
    }
}
