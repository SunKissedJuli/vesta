package com.example.vesta.ext

fun String.toToken(): String{
    return "Bearer $this"
}