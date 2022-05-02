package com.example.finalproject.view

import com.example.finalproject.data.PokemonDetail

interface DetailView {
    fun bindDetail(pokeResponse: PokemonDetail)
    fun showError(errorMessage: String)
}