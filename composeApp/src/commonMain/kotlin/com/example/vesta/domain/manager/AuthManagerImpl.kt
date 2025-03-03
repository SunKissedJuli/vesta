package com.example.vesta.domain.manager

import com.russhwolf.settings.Settings
import com.russhwolf.settings.contains
import org.koin.core.component.KoinComponent
import org.koin.core.component.inject

class AuthManagerImpl: AuthManager, KoinComponent {

    private val settings by inject<Settings>()

    override var token: String?
        get() = if (settings.getString(TOKEN).isBlank()) null else settings.getString(TOKEN, "")
        set(value){
            settings.putString(TOKEN, value.orEmpty())
        }

    override var sessionId: String?
        get() = if (settings.getString(SESSION_ID).isBlank()) null else settings.getString(SESSION_ID, "")
        set(value){
            settings.putString(SESSION_ID, value.orEmpty())
        }

    override var city: Int?
        get() {
            return if (settings.contains(CITY)) settings.getInt(CITY, 0) else 0
        }
        set(value) {
            settings.putInt(CITY, value ?: 0)
        }

    companion object{
        private const val TOKEN = "TOKEN"
        private const val SESSION_ID = "SESSION_ID"
        private const val CITY = "CITY"
    }
}