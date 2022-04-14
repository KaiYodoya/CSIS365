package com.example.finalproject

import android.widget.Button
import com.example.finalproject.data.Results

interface ListsView {
    fun queryBtn(): Button

    fun findPageIndex():Int
    fun bindPokemon(pokeList: List<Results?>)
    fun showError(errorMessage: String)
    //fun bindCategories(categories: List<String>)
}