package com.example.finalproject

import com.example.finalproject.data.Results

interface ListsView {
    fun findPageIndex():Int
    fun bindPokemon(pokeList: List<Results?>)
    fun showError(errorMessage: String)
    //fun bindCategories(categories: List<String>)
}