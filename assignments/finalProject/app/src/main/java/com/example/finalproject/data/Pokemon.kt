package com.example.finalproject.data

data class Pokemon(
    val results : Results?
)

data class Results(
    val name: String?,
    val url: String?
)