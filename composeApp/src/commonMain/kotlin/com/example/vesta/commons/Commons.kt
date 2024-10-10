package com.example.vesta.commons

fun String.toToken(): String{
    return "Bearer $this"
}