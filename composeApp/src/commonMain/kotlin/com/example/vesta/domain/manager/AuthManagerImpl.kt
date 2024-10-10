package com.example.vesta.domain.manager

import com.russhwolf.settings.Settings
import org.koin.core.component.KoinComponent
import org.koin.core.component.inject

class AuthManagerImpl: AuthManager, KoinComponent {

    private val settings by inject<Settings>()

    override var token: String?
        get() = if (settings.getString(TOKEN).isBlank()) null else settings.getString(TOKEN, "")
        set(value){
            settings.putString(TOKEN, value.orEmpty())
        }

    companion object{
        private const val TOKEN = "TOKEN"
    }
}