package com.example.finalproject.data

data class Resource(
    val forms: List<Forms?>,
    val sprites: Sprites?,
    val stats: List<Stats?>
    )

// Where the name is saved
data class Forms(
    val name: String?
    )

// Where the front_default is saved
data class Sprites(
    val front_default: String?
)

// Where the base stats are saved
data class Stats(
    val base_stat: Int?
)