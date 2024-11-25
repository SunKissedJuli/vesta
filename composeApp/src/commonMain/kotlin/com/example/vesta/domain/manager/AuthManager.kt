package com.example.vesta.domain.manager

interface AuthManager {
    var token: String?
    var sessionId: String?
    var city: Int?
}