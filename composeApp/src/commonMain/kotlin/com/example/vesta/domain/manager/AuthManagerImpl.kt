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

    override var sity: Int?
        get() {
            return if (settings.contains(SITY)) settings.getInt(SITY, 0) else null
        }
        set(value) {
            settings.putInt(SITY, value ?: 0)
        }

    companion object{
        private const val TOKEN = "TOKEN"
        private const val SITY = "SITY"
    }
}