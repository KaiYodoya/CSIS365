package com.example.finalproject

import androidx.recyclerview.widget.RecyclerView

class ListsPresenter (
    val view: ListsView,
    val pokeservice: PokeService
)   {

    fun start() {
        getPokemon()
    }

    private fun getPokemon() {
        pokeservice.getPokemon(
            successCallback = { poke ->
                view.bindPokemon(poke)
                // recyclerview is created and bind within bindPokemon(List<Results?>)
            },

            failureCallback = { errorMessage ->
                view.showError(errorMessage)
            },
            view.findPageIndex()
        )
    }


}