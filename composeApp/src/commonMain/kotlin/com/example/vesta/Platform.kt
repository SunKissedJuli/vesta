package com.example.vesta

interface Platform {
    val name: String
}

expect fun getPlatform(): Platform